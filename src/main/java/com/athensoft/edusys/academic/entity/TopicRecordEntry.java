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

import com.athensoft.edusys.product.entity.Module;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "acd_session_topic_record_entry")
public class TopicRecordEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer entryId = -1;
	
	@Column(name = "session_topic_record_id", nullable = false)
	@JsonIgnore
	private Integer topicRecordId;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)	
	private TopicStatus topicStatus;

//	@Column(nullable = false)
//	private Integer moduleId;
	
	@Column(nullable = false)
	private Integer chapterId;
	
	
	public Integer getEntryId() {
		return entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public Integer getTopicRecordId() {
		return topicRecordId;
	}

	public void setTopicRecordId(Integer topicRecordId) {
		this.topicRecordId = topicRecordId;
	}

	public TopicStatus getTopicType() {
		return topicStatus;
	}

	public void setTopicType(TopicStatus topicStatus) {
		this.topicStatus = topicStatus;
	}

	public TopicStatus getTopicStatus() {
		return topicStatus;
	}

	public void setTopicStatus(TopicStatus topicStatus) {
		this.topicStatus = topicStatus;
	}

//	public Integer getModuleId() {
//		return moduleId;
//	}
//
//	public void setModuleId(Integer moduleId) {
//		this.moduleId = moduleId;
//	}

	public Integer getChapterId() {
		return chapterId;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

	@Override
	public String toString() {
		return "TopicRecordEntry [entryId=" + entryId + ", topicRecordId=" + topicRecordId + ", topicStatus="
				+ topicStatus + ", chapterId=" + chapterId + "]";
	}




	


	
	
	

	
}
