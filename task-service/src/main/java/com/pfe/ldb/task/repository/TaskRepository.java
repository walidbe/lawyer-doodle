package com.pfe.ldb.task.repository;

import org.springframework.data.repository.CrudRepository;
import com.pfe.ldb.entity.TaskEntity;

public interface TaskRepository extends  CrudRepository<TaskEntity,Integer> {

}
