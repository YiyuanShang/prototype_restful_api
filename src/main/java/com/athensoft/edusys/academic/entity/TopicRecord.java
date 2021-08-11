package com.athensoft.edusys.academic.entity;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.athensoft.edusys.product.entity.Topic;

//@Entity
//@Table(name = "acd_rel_session_topic")
public class TopicRecord {
//	@EmbeddedId
//	TopicRecordId topicRecordId;
//	
//	@OneToMany(targetEntity = Topic.class)
//	@JoinColumns({
//		  @JoinColumn(name = "session_id"),
//		  @JoinColumn(name = "topic_id")})
//	List<Topic> deliveredTopics;
}
