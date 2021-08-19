package com.athensoft.edusys.admin.entity;

import java.io.Serializable;

import com.athensoft.edusys.hr.entity.Admin;

public class AdminEntryId implements Serializable{
	private static final long serialVersionUID = 1L;

	private Admin admin;
	
	private AcademicGroup group;
	
	
	public AdminEntryId() {}
	public AdminEntryId(Admin admin, AcademicGroup group) {
		super();
		this.admin = admin;
		this.group = group;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public AcademicGroup getGroup() {
		return group;
	}

	public void setGroup(AcademicGroup group) {
		this.group = group;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
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
		AdminEntryId other = (AdminEntryId) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		return true;
	}
	
	

}
