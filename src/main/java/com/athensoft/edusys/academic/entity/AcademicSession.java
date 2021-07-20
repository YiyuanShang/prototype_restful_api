package com.athensoft.edusys.academic.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.athensoft.edusys.admin.entity.AttendanceRecord;
import com.athensoft.edusys.admin.entity.DeliveryRecord;
import com.athensoft.edusys.client.entity.Student;
import com.athensoft.edusys.hr.entity.Instructor;
import com.athensoft.edusys.product.entity.Topic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "acd_session")
@Getter @Setter @NoArgsConstructor @ToString
public class AcademicSession {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sessionId;
	
	private String groupNo;
	private int courseId;
	private int sessionSeqNo;
	
	@OneToOne
	@JoinColumn(name = "assgmt_record_id")
	private AssignmentRecord assignment;
	
	
	@OneToOne
	private DeliveryRecord deliveryRecord;
	
	@OneToOne
	private AttendanceRecord attendanceRecord;
	
	@ManyToMany(targetEntity = Topic.class)
	private List<Topic> topics;
}
