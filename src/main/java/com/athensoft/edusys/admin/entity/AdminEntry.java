package com.athensoft.edusys.admin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.athensoft.edusys.hr.entity.Admin;

@Entity
@Table(name = "admin_rel_group_admin")
@IdClass(AdminEntryId.class)
public class AdminEntry {
	@Id
	@JoinColumn(name = "emp_id")
	@ManyToOne(targetEntity = Admin.class)
	private Admin admin;
	
	private String comment;
	private AdminStatus adminStatus;
	
	@Id
	@JoinColumn(name = "group_id")
	@ManyToOne(targetEntity = AcademicGroup.class)
	private AcademicGroup group;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public AdminStatus getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(AdminStatus adminStatus) {
		this.adminStatus = adminStatus;
	}

	public AcademicGroup getGroup() {
		return group;
	}

	public void setGroup(AcademicGroup group) {
		this.group = group;
	}
	
	

}
