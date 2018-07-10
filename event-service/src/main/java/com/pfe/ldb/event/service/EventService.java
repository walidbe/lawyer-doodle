package com.pfe.ldb.event.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.pfe.ldb.core.protogest.event.Event;
import com.pfe.ldb.core.protogest.event.EventGroup;
import com.pfe.ldb.core.protogest.event.EventJson;
import com.pfe.ldb.core.protogest.event.EventState;
import com.pfe.ldb.core.protogest.task.Task;
import com.pfe.ldb.core.protogest.task.TaskGroup;
import com.pfe.ldb.entity.EventEntity;
import com.pfe.ldb.entity.EventGroupEntity;
import com.pfe.ldb.entity.EventUserDestinationEntity;
import com.pfe.ldb.entity.MemberEntity;
import com.pfe.ldb.entity.TaskEntity;
import com.pfe.ldb.entity.TaskGroupEntity;
import com.pfe.ldb.event.controller.path.PathURI;
import com.pfe.ldb.event.imapper.IMapper;
import com.pfe.ldb.event.iservice.IEventService;
import com.pfe.ldb.event.mapper.EventGroupMapper;
import com.pfe.ldb.event.mapper.EventMapper;
import com.pfe.ldb.event.repository.EventGroupRepository;
import com.pfe.ldb.event.repository.EventRepository;
import com.pfe.ldb.event.repository.EventStateRepository;
import com.pfe.ldb.event.repository.EventUserDestinationRepository;
import com.pfe.ldb.event.repository.MemberRepository;

@Service
public class EventService implements IEventService {

	private final static Integer TASK_ID_DATE = 1;

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventGroupRepository eventGroupRepository;
	
	@Autowired
	private EventStateRepository eventStateRepository;

	@Autowired
	private EventUserDestinationRepository eventUserDestRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private  EventMapper eventMapper;
	
	private  EventGroupMapper eventGroupMapper = new EventGroupMapper();

	

	@Override
	public List<EventGroup> loadEventsGroup() {
		List<EventGroup> eventsGroup = new ArrayList<>();
		for(EventGroupEntity eventGroupEntity : eventGroupRepository.findAll()) {
			eventsGroup.add((EventGroup)eventGroupMapper.convertToDTO(eventGroupEntity));
		}
		return eventsGroup;
	}

	@Override
	public Event updateEvent(Event event) {
		if(event.getId() == null) {
			event.setEventState(EventState.PENDING);
		}
		else {
			event.setEventState(EventState.ACCEPTED);
		}
		EventEntity eventEntity = (EventEntity) eventMapper.convertToEntity(event);
		EventEntity updatedEvent = eventRepository.save(eventEntity);
		addSubscribers(event, updatedEvent);
		return (Event) eventMapper.convertToDTO(updatedEvent);
	}
	
	private void addSubscribers(Event event, EventEntity updatedEvent) {
		
		for(String email : event.getEmails()) {
			EventUserDestinationEntity dest = eventUserDestRepository.findByEventIdAndEmail(updatedEvent.getId(), email);
			MemberEntity member = memberRepository.findByEmail(email);
			if(dest == null) {
				eventUserDestRepository.save(new EventUserDestinationEntity(updatedEvent, email, member));
			}
			else {
				dest.setMember(member);
				eventUserDestRepository.save(dest);
			}
			sendEmail(email, event, updatedEvent);
		}
		
	}
	
	private void sendEmail(String email, Event event, EventEntity updatedEvent) {
		try {
			RestTemplate template = new RestTemplate();
			Map<String, String> map = new LinkedHashMap<>();
			map.put("email", email);
			map.put("eventName", event.getEventName());
			map.put("taskName", updatedEvent.getTask().getName());
			map.put("eventDate", updatedEvent.getEventDate().toString());
			map.put("source", updatedEvent.getMember().getFirstName() + " " + updatedEvent.getMember().getLastName());
			map.put("link", PathURI.sourceHost);
			MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
			header.add("Content-Type", "application/json");
			HttpEntity<?> httpEntity = new HttpEntity<>(map, header);
			template.postForObject(PathURI.emailHost, httpEntity, Map.class);
		}catch(Exception ex) {
			
		}

	}

	@Override
	public List<Event> updateEvents(List<Event> events) {
		List<Event> updatedEvent = new ArrayList<>();
		for(Event event : events) {
			updatedEvent.add(updateEvent(event));
		}
		
		return updatedEvent;
	}
	
	

	@Override
	public List<EventJson> loadEvents() {
		List<EventJson> events = new ArrayList<>();
		List<Integer> labels = new ArrayList<>();
		labels.add(1);
		labels.add(4);
		for(EventGroup eventGroup : loadEventsGroup()) {
			Boolean completed =false;
			Boolean pending = false;
			Boolean deleted = false;
			Boolean archived = false;
			EventEntity eventEntity = eventRepository.findByTaskIdAndEventGroupId(TASK_ID_DATE,  eventGroup.getId());
					
				EventState state = EventState.valueOf(eventEntity.getEventState().getName().toUpperCase());
				if(state.getState().equalsIgnoreCase("Accepted")) {
					completed = true;
					pending = false;
				}
				else if(state.getState().equalsIgnoreCase("Pending")) {
					completed = false;
					pending = true;
				}
				EventJson event = new EventJson(eventEntity.getId(), eventEntity.getEventDate(), eventEntity.getTask().getId(),
						eventEntity.getMember().getId(), state);
					List<String> emails = new ArrayList<>();
					for(EventUserDestinationEntity eventUser : eventUserDestRepository.findByEventId(event.getId())){
						emails.add(eventUser.getEmail());
					}
				   event.setTitle(eventGroup.getEventName());
				   event.setEmails(emails);
				   event.setLabels(labels);
				   event.setCompleted(completed);
				   event.setPending(pending);
				   event.setDeleted(deleted);
				   event.setArchived(archived);
				   event.setChildEvents(getChildEvent(eventGroup));
				   events.add(event);
			}
		return events;
	}
	
	private List<Event> getChildEvent(EventGroup eventGroup) {
		List<Event> childEvents = new ArrayList();
		for(EventEntity eventEntity : eventRepository.findByEventGroupId(eventGroup.getId())) {
			Event event = (Event)eventMapper.convertToDTO(eventEntity);
			event.setEventName(eventEntity.getTask().getName());
			childEvents.add(event);
			
		}
		return childEvents;
	}
	/*
	
	@Override
	public List<EventJson> loadEvents() {
		List<EventJson> events = new ArrayList<>();
		List<Integer> labels = new ArrayList<>();
		labels.add(1);
		labels.add(4);
		for(EventGroup eventGroup : loadEventsGroup()) {
			Boolean completed;
			Boolean pending;
		//	EventEntity eventEntity = eventRepository.findByTaskIdAndEventGroupId(TASK_ID_DATE,  eventGroup.getId());
			for(EventEntity eventEntity : eventRepository.findByEventGroupId(eventGroup.getId())) {
					
				EventState state = EventState.valueOf(eventEntity.getEventState().getName().toUpperCase());
				if(state.getState().equalsIgnoreCase("Accepted")) {
					completed = true;
					pending = false;
				}
				else if(state.getState().equalsIgnoreCase("Pending")) {
					completed = false;
					pending = true;
				}
				EventJson event = new EventJson(eventEntity.getId(), eventEntity.getEventDate(), eventEntity.getTask().getId(),
						eventEntity.getMember().getId(), state);
					List<String> emails = new ArrayList<>();
					for(EventUserDestinationEntity eventUser : eventUserDestRepository.findByEventId(event.getId())){
						emails.add(eventUser.getEmail());
					}
				   event.setTitle(eventGroup.getEventName());
				   event.setEmails(emails);
				   event.setLabels(labels);
				   events.add(event);
			}
		}
		return events;
	}*/

}
