package com.athensoft.edusys.academic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athensoft.edusys.academic.entity.TopicRecordEntry;
import com.athensoft.edusys.academic.entity.TopicRecordEntryId;

public interface TopicRecordEntryRepository extends JpaRepository<TopicRecordEntry, TopicRecordEntryId>{

}
