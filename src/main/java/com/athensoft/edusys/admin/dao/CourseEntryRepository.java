package com.athensoft.edusys.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athensoft.edusys.admin.entity.CourseEntry;
import com.athensoft.edusys.admin.entity.CourseEntryId;

public interface CourseEntryRepository extends JpaRepository<CourseEntry, CourseEntryId>{

}
