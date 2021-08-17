package com.athensoft.edusys.academic.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;

import com.athensoft.edusys.academic.service.TopicConverter;
import com.athensoft.edusys.product.entity.Topic;

public class TopicRecordEntryId implements Serializable{
	private static final long serialVersionUID = 2790864776285692290L;

//	private Integer topicId;
	
	@Convert(converter = TopicConverter.class, attributeName = "topic.topicId")
	@JoinColumn(name = "topic_id")
	private Topic topic;
	
	private Integer topicRecordId;
	
	private TopicStatus topicType;

	public TopicRecordEntryId() {}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	

	public Integer getTopicRecordId() {
		return topicRecordId;
	}

//	public Integer getTopicId() {
//		return topicId;
//	}
//
//	public void setTopicId(Integer topicId) {
//		this.topicId = topicId;
//	}

	public void setTopicRecordId(Integer topicRecordId) {
		this.topicRecordId = topicRecordId;
	}

	public TopicStatus getTopicType() {
		return topicType;
	}

	public void setTopicType(TopicStatus topicType) {
		this.topicType = topicType;
	}

	


	

	
	
	

}
