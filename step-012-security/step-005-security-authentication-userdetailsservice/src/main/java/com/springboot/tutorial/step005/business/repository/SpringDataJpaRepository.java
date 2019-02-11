package com.springboot.tutorial.step005.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface SpringDataJpaRepository<E , ID extends Serializable> extends JpaRepository<E, ID>, CrudRepository<E, ID> {
}
