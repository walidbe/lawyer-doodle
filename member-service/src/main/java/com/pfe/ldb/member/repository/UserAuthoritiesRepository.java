package com.pfe.ldb.member.repository;

import org.springframework.data.repository.CrudRepository;

import com.pfe.ldb.entity.UserAuthoritiesEntity;

public interface UserAuthoritiesRepository extends CrudRepository<UserAuthoritiesEntity,Integer> {

	UserAuthoritiesEntity findByUserId(Integer userId);
}

