package com.athensoft.edusys.admin.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "admin_group_schedule")
public class GroupSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_id")
	private Integer scheduleId = -1;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date deliveryDate;

	@Transient
	private String deliveryDay;

	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date startTime;

	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date endTime;

	@Transient
	private Float duration;

	public GroupSchedule() {
	}

	public GroupSchedule(Integer scheduleId, Date deliveryDate, String deliveryDay, Date startTime, Date endTime,
			Float duration) {
		super();
		this.scheduleId = scheduleId;
		this.deliveryDate = deliveryDate;
		this.deliveryDay = deliveryDay;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryDay() {
		DateFormat formatter = new SimpleDateFormat("EEE", Locale.ENGLISH);
	    return formatter.format(deliveryDate);
	}

	public void setDeliveryDay(String deliveryDay) {
		this.deliveryDay = deliveryDay;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Float getDuration() {
		// convert milliseconds to hours
		return (float) ((endTime.getTime() - startTime.getTime()) / (3.6 * Math.pow(10, 6)));
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "GroupSchedule [scheduleId=" + scheduleId + ", deliveryDate=" + deliveryDate + ", deliveryDay="
				+ deliveryDay + ", startTime=" + startTime + ", endTime=" + endTime + ", duration=" + duration + "]";
	}

	
}
