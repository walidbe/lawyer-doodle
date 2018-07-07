package com.pfe.ldb.event.repository;

import org.springframework.data.repository.CrudRepository;

import com.pfe.ldb.entity.EventUserDestinationEntity;

public interface EventUserDestinationRepository extends  CrudRepository<EventUserDestinationEntity,Integer> {

	EventUserDestinationEntity findByEventIdAndEmail(Integer eventId, String email);
}
