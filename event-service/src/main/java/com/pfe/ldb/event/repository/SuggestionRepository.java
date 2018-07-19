package com.pfe.ldb.event.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.pfe.ldb.entity.SuggestionEntity;

public interface SuggestionRepository  extends CrudRepository<SuggestionEntity,Integer> {

	List<SuggestionEntity> findByEventUserDestinationId(Integer eventUserDestinationId);
	
}
