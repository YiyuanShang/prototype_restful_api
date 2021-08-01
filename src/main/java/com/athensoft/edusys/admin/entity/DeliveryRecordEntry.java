package com.athensoft.edusys.admin.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.athensoft.edusys.hr.entity.Employee;

@Embeddable
public class DeliveryRecordEntry implements Serializable{
	private static final long serialVersionUID = 1053151989709424903L;
	
//	@Column(name = "emp_id")
	@OneToOne(targetEntity = Employee.class)
	private Employee instructor;
	
	public DeliveryRecordEntry() {}
	
	

	public DeliveryRecordEntry(Employee instructor) {
		super();
		this.instructor = instructor;
	}


	public Employee getInstructor() {
		return instructor;
	}

	public void setInstructor(Employee instructor) {
		this.instructor = instructor;
	}

	

	@Override
	public String toString() {
		return "DeliveryRecordEntry [instructor=" + instructor + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instructor == null) ? 0 : instructor.hashCode());
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
		DeliveryRecordEntry other = (DeliveryRecordEntry) obj;
		if (instructor == null) {
			if (other.instructor != null)
				return false;
		} else if (!instructor.equals(other.instructor))
			return false;
		return true;
	}



	
	
	
	

}
