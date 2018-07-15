package com.pfe.ldb.member.repository;

import org.springframework.data.repository.CrudRepository;

import com.pfe.ldb.entity.AuthoritiesEntity;

public interface AuthoritiesRepository extends CrudRepository<AuthoritiesEntity,Integer> {

	AuthoritiesEntity findByName(String name);
}

