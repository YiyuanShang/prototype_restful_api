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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "acd_session_topic_record")
public class TopicRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "session_topic_record_id")
	private Integer topicRecordId;
	
	@OneToMany(targetEntity = TopicRecordEntry.class)
	@JoinColumn(name = "session_topic_record_id")
	List<TopicRecordEntry> topicRecordEntries;

	@OneToOne
	@JoinColumn(name = "session_id")
	@JsonBackReference
	AcademicSession deliveredSession;
	
	public TopicRecord() {}
	public TopicRecord(Integer topicRecordId, List<TopicRecordEntry> topicRecordEntries,
			AcademicSession deliveredSession) {
		super();
		this.topicRecordId = topicRecordId;
		this.topicRecordEntries = topicRecordEntries;
		this.deliveredSession = deliveredSession;
	}

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
	@Override
	public String toString() {
		return "TopicRecord [topicRecordId=" + topicRecordId + ", topicRecordEntries=" + topicRecordEntries
				+ ", sessionId=" + deliveredSession.getSessionId() + "]";
	}
	
	
	

	
	
	
}
