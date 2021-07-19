package com.athensoft.edusys.hr;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.athensoft.edusys.admin.EmpType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "hr_instructor")
@Getter @Setter @NoArgsConstructor @ToString
public class Instructor extends Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instructorId;
}
