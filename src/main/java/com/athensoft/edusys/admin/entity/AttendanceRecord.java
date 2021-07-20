package com.athensoft.edusys.admin.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.athensoft.edusys.client.entity.Student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "admin_attend_record")
public class AttendanceRecord {
	@ManyToMany(targetEntity = Student.class)
	private List<Student> attendedStudents;
}
