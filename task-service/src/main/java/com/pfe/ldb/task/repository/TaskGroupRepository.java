package com.pfe.ldb.task.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pfe.ldb.entity.TaskGroupEntity;

public interface TaskGroupRepository extends  CrudRepository<TaskGroupEntity,Integer> {

	List<TaskGroupEntity> findAllByParentId(Integer parentId);
}
