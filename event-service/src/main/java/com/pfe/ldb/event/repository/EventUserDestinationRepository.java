package com.pfe.ldb.event.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pfe.ldb.entity.EventUserDestinationEntity;

public interface EventUserDestinationRepository extends  CrudRepository<EventUserDestinationEntity,Integer> {

	EventUserDestinationEntity findByEventIdAndEmail(Integer eventId, String email);
	List<EventUserDestinationEntity> findByEventId(Integer eventId);
}
