package com.athensoft.edusys.academic.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.athensoft.edusys.product.entity.Topic;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "acd_session_topic_record")
public class TopicRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "session_topic_record_id")
	private Integer topicRecordId;
	
	@OneToMany(targetEntity = TopicRecordEntry.class)
	@JoinColumn(name = "session_topic_record_id")
	@JsonManagedReference
	List<TopicRecordEntry> topicRecordEntries;

	@OneToOne
	@JoinColumn(name = "session_id")
	@JsonBackReference
	AcademicSession deliveredSession;
	
	public List<TopicRecordEntry> getTopicRecordEntries() {
		return topicRecordEntries;
	}

	public void setTopicRecordEntries(List<TopicRecordEntry> topicRecordEntries) {
		this.topicRecordEntries = topicRecordEntries;
	}

	public AcademicSession getDeliveredSession() {
		return deliveredSession;
	}

	public void setDeliveredSession(AcademicSession deliveredSession) {
		this.deliveredSession = deliveredSession;
	}

	public Integer getTopicRecordId() {
		return topicRecordId;
	}

	public void setTopicRecordId(Integer topicRecordId) {
		this.topicRecordId = topicRecordId;
	}
	
	
	

	
	
	
}
