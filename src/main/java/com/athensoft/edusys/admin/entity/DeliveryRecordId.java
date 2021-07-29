package com.athensoft.edusys.admin.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class DeliveryRecordId implements Serializable{
	private static final long serialVersionUID = -2145507013907203638L;

	private Integer sessionId;
	
	private Integer empId;

	public DeliveryRecordId() {}
	
	public DeliveryRecordId(Integer sessionId, Integer empId) {
		super();
		this.sessionId = sessionId;
		this.empId = empId;
	}

	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	public Integer getempId() {
		return empId;
	}

	public void setempId(Integer empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "DeliveryRecordId [sessionId=" + sessionId + ", empId=" + empId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(sessionId, empId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeliveryRecordId other = (DeliveryRecordId) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		return true;
	}
	
	
	

}
