package com.athensoft.edusys.academic;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.athensoft.edusys.admin.AttendanceRecord;
import com.athensoft.edusys.admin.DeliveryRecord;
import com.athensoft.edusys.product.Topic;

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
	private AssignmentRecord assignment;
	private DeliveryRecord deliveryRecord;
	private AttendanceRecord attendanceRecord;
	private List<Topic> topics;
}
