package com.athensoft.edusys.admin.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class AttendanceRecordId implements Serializable{
	private static final long serialVersionUID = 5984393258377995702L;

	private Integer sessionId;
	
	private Integer stuId;

	public AttendanceRecordId() {}
	
	public AttendanceRecordId(Integer sessionId, Integer stuId) {
		super();
		this.sessionId = sessionId;
		this.stuId = stuId;
	}

	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	@Override
	public String toString() {
		return "AttendanceRecordId [sessionId=" + sessionId + ", stuId=" + stuId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(sessionId, stuId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttendanceRecordId other = (AttendanceRecordId) obj;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		if (stuId == null) {
			if (other.stuId != null)
				return false;
		} else if (!stuId.equals(other.stuId))
			return false;
		return true;
	}
	
	
	

}
