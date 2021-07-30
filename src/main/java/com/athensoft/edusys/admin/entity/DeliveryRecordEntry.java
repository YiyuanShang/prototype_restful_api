package com.athensoft.edusys.admin.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

import com.athensoft.edusys.hr.entity.Employee;

@Embeddable
public class DeliveryRecordEntry implements Serializable{
	private static final long serialVersionUID = 1053151989709424903L;
	
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
		return Objects.hash(instructor);
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
