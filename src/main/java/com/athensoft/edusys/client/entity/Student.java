package com.athensoft.edusys.client.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "client_student")
@Getter @Setter @NoArgsConstructor @ToString
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int stuId;
	
	@Column(unique = true)
	private String stuNo;
	
	private String stuFirstName;
	private String stuLastName;
	private String email;
	private boolean isMember;
	private Date regDate;
	
	@Enumerated(EnumType.STRING)
	private StudentType stuType;
}
