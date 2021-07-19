package com.athensoft.edusys.academic;

import java.util.Date;
import java.util.List;

import com.athensoft.edusys.product.Question;

public class AssignmentRecord {
	private int assgmtRecordId;
	private AssignmentType assgmtType;
	private Date issueDate;
	private Date dueDate;
	private List<Question> questions;
}
