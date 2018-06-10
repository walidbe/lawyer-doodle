package com.pfe.ldb.task.repository;

import org.springframework.data.repository.CrudRepository;

import com.pfe.ldb.entity.TaskEntity;

public interface TaskGroupRepository extends  CrudRepository<TaskEntity,Integer> {

}
