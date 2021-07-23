package com.athensoft.edusys.client.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.client.entity.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer>{

}
