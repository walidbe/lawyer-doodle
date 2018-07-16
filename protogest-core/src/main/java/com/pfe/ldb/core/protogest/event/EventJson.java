package com.pfe.ldb.core.protogest.event;

import java.util.Date;
import java.util.List;

import com.pfe.ldb.core.protogest.utils.AbstractModel;

public class EventJson extends AbstractModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dueDate;
	private Integer task;
	private Integer sourceId;
	private EventState eventState;
	private String title;
	private String taskName;
	private List<String> emails;
	private List<Integer> labels;
	private Boolean completed;
	private Boolean deleted;
	private Boolean archived;
	private Boolean pending;
	private List<Event> childEvents;
	
	public EventJson() {
		super();
		this.dueDate = null;
		this.task = null;
		this.sourceId = null;
		this.eventState = null;
		this.title =null;
		this.emails = null;
	}
	
	public EventJson(Integer id, Date dueDate, Integer task, Integer sourceId, EventState eventState) {
		super(id);
		this.dueDate = dueDate;
		this.task = task;
		this.sourceId = sourceId;
		this.eventState = eventState;
	}
	
	
	public EventJson(Date dueDate, Integer task, Integer sourceId, EventState eventState) {
		super();
		this.dueDate = dueDate;
		this.task = task;
		this.sourceId = sourceId;
		this.eventState = eventState;
	}
	
	public EventJson(Date dueDate, Integer task, String title) {
		this.dueDate = dueDate;
		this.task = task;
		this.title = title;
	}
	
	public EventJson(Date dueDate, Integer task, String title, List<String> emails) {
		this.dueDate = dueDate;
		this.task = task;
		this.title = title;
		this.emails = emails;
	}
	
	
	
	
	
	public Integer getTask() {
		return task;
	}
	public void setTask(Integer task) {
		this.task = task;
	}
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	
	public EventState getEventState() {
		return eventState;
	}
	public void setEventState(EventState eventState) {
		this.eventState = eventState;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Integer> getLabels() {
		return labels;
	}

	public void setLabels(List<Integer> labels) {
		this.labels = labels;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

	public Boolean getPending() {
		return pending;
	}

	public void setPending(Boolean pending) {
		this.pending = pending;
	}

	public List<Event> getChildEvents() {
		return childEvents;
	}

	public void setChildEvents(List<Event> childEvents) {
		this.childEvents = childEvents;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	
}
