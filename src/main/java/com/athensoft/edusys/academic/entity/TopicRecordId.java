package com.athensoft.edusys.academic.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class TopicRecordId implements Serializable{
	private static final long serialVersionUID = 2790864776285692290L;

	private Integer sessionId;
	
	private Integer topicId;

	public TopicRecordId() {}
	
	public TopicRecordId(Integer sessionId, Integer topicId) {
		super();
		this.sessionId = sessionId;
		this.topicId = topicId;
	}

	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	@Override
	public String toString() {
		return "TopicRecordId [sessionId=" + sessionId + ", topicId=" + topicId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(sessionId, topicId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TopicRecordId other = (TopicRecordId) obj;
		if (topicId == null) {
			if (other.topicId != null)
				return false;
		} else if (!topicId.equals(other.topicId))
			return false;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		return true;
	}
	
	
	

}
