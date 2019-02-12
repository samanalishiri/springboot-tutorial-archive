package com.springboot.tutorial.security.business.repository;


import com.springboot.tutorial.security.domain.AuthorityEntity;

public interface AuthorityRepository extends SpringDataJpaRepository<AuthorityEntity, Long> {
}
