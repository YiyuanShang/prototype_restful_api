package com.athensoft.edusys.academic.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.repository.Query;

import com.athensoft.edusys.product.entity.Topic;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "acd_session_topic_entry")
@IdClass(TopicRecordEntryId.class)
public class TopicRecordEntry {
	@Id
	@Column(name = "session_topic_record_id")
	@JsonIgnore
	private Integer topicRecordId;

	@Id
	@Column(name = "topic_type")
	@Enumerated(EnumType.ORDINAL)	
	private TopicStatus topicType;
	
//	@Id
//	@Column(name = "topic_id")
//	private Integer topicId;
	
	@Id
//	@Transient
	@OneToOne(targetEntity = Topic.class)
	@JoinColumn(name = "topic_id")
	private Topic topic;

	public Integer getTopicRecordId() {
		return topicRecordId;
	}

	public void setTopicRecordId(Integer topicRecordId) {
		this.topicRecordId = topicRecordId;
	}

	public TopicStatus getTopicType() {
		return topicType;
	}

	public void setTopicType(TopicStatus topicType) {
		this.topicType = topicType;
	}

	public Topic getTopic() {
		
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	

//	public Integer getTopicId() {
//		return topicId;
//	}
//
//	public void setTopicId(Integer topicId) {
//		this.topicId = topicId;
//	}

	@Override
	public String toString() {
		return "TopicRecordEntry [topicRecordId=" + topicRecordId + ", topicType=" + topicType + ", topic=" + topic
				+ "]";
	}
	
	

	
}
