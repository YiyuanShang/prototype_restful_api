package com.athensoft.edusys.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.athensoft.edusys.admin.dao.GroupStudentEntryRepository;
import com.athensoft.edusys.admin.entity.GroupStudentEntry;

@Service
public class GroupStudentEntryService {
	private final GroupStudentEntryRepository groupStudentEntryRepo;
	
	public GroupStudentEntryService(GroupStudentEntryRepository groupStudentEntryRepo) {
		this.groupStudentEntryRepo = groupStudentEntryRepo;
	}
	
	public List<GroupStudentEntry> getGroupStudentEntryListByGroupId(Integer groupId){
		return groupStudentEntryRepo.findAllByGroup_groupId(groupId);
	}

	public List<GroupStudentEntry> getGroupStudentEntryListByStuId(Integer stuId) {
		return groupStudentEntryRepo.findAllByStudent_stuId(stuId);
	}

}
