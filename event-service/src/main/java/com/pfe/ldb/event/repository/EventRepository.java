package com.pfe.ldb.event.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pfe.ldb.entity.EventEntity;
import com.pfe.ldb.entity.TaskEntity;
import com.pfe.ldb.entity.UserEntity;

public interface EventRepository extends  CrudRepository<EventEntity,Integer> {

		EventEntity findByTaskIdAndEventGroupId(Integer taskId, Integer eventGroupId);
}
