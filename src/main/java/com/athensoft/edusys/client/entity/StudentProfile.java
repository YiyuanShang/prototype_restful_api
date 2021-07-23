package com.athensoft.edusys.client.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "client_student_profile")
@Getter @Setter @NoArgsConstructor @ToString
public class StudentProfile {
	@Id
	private int stuId;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stu_id")
	private Student student;
	
	@Column(name = "parentname_1")
	private String parentName1;
	
	@Column(name = "parentname_2")
	private String parentName2;
	
	@Column(name = "email_1")
	private String email1;
}
