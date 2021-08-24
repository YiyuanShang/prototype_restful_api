package com.athensoft.edusys.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athensoft.edusys.product.entity.Module;

public interface TopicRepository extends JpaRepository<Module, Integer>{

}
