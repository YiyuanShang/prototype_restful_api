package com.athensoft.edusys.academic.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.athensoft.edusys.admin.entity.GroupStatus;
import com.athensoft.edusys.admin.entity.GroupType;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AcdSessionVO {
	
	@Column(nullable = false)
	private Integer sessionId;

	private Integer sessionSeqNo;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Etc/GMT+4")
	private Date deliveryDate;

	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date startTime;

	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date endTime;

	private Float duration;
	
	@Enumerated(EnumType.ORDINAL)
	private SessionStatus sessionStatus;
	
	@Column(nullable = false)
	private Integer groupId;

	@Column(unique = true)
	private String groupNo;
	
	@Enumerated(EnumType.ORDINAL)
	private GroupStatus groupStatus;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	private Integer sessionNum;

	@Enumerated(EnumType.ORDINAL)
	private GroupType groupType;

	private String groupName;

	private String groupDesc;
	
	
	

}
