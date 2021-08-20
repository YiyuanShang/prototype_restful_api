package com.athensoft.edusys.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athensoft.edusys.admin.entity.GroupStudentEntry;
import com.athensoft.edusys.admin.entity.GroupStudentEntryId;

public interface GroupStudentEntryRepository extends JpaRepository<GroupStudentEntry, GroupStudentEntryId>{
	List<GroupStudentEntry> findAllByGroup_groupId(Integer groupId);
	
	List<GroupStudentEntry> findAllByStudent_stuId(Integer stuId);
}
