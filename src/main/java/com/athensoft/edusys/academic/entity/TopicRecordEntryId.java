package com.athensoft.edusys.academic.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.athensoft.edusys.product.entity.Topic;

public class TopicRecordEntryId implements Serializable{
	private static final long serialVersionUID = 2790864776285692290L;

	private Topic topic;
	
	private Integer topicRecordId;
	
	private TopicType topicType;

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

	public void setTopicRecordId(Integer topicRecordId) {
		this.topicRecordId = topicRecordId;
	}

	public TopicType getTopicType() {
		return topicType;
	}

	public void setTopicType(TopicType topicType) {
		this.topicType = topicType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		result = prime * result + ((topicRecordId == null) ? 0 : topicRecordId.hashCode());
		result = prime * result + ((topicType == null) ? 0 : topicType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TopicRecordEntryId other = (TopicRecordEntryId) obj;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		if (topicRecordId == null) {
			if (other.topicRecordId != null)
				return false;
		} else if (!topicRecordId.equals(other.topicRecordId))
			return false;
		if (topicType != other.topicType)
			return false;
		return true;
	}

	


	

	
	
	

}
