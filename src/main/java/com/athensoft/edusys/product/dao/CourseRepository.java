package com.athensoft.edusys.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athensoft.edusys.product.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Integer>{

}
