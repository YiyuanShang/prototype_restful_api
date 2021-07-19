package com.athensoft.edusys.academic;

import java.util.List;

import com.athensoft.edusys.admin.AttendanceRecord;
import com.athensoft.edusys.admin.DeliveryRecord;
import com.athensoft.edusys.product.Topic;

public class AcademicSession {
	private int sessionId;
	private String groupNo;
	private int courseId;
	private int sessionSeqNo;
	private AssignmentRecord assignment;
	private DeliveryRecord deliveryRecord;
	private AttendanceRecord attendanceRecord;
	private List<Topic> topics;
}
