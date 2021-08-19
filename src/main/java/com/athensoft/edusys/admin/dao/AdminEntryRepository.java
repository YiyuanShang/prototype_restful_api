package com.athensoft.edusys.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athensoft.edusys.admin.entity.AdminEntry;
import com.athensoft.edusys.admin.entity.AdminEntryId;

public interface AdminEntryRepository extends JpaRepository<AdminEntry, AdminEntryId>{
	List<AdminEntry> findAllByGroup_groupId(Integer groupId);
	
	

}
