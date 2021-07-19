package com.athensoft.edusys.client.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "client_member")
@Getter @Setter @NoArgsConstructor @ToString
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memId;
	private MemberType memType;
	private String email;
	private String memFirstName;
	private String memLastName;
	private Date regDate;
	private Date expiryDate;
	private float discountRate;
	private int creditLevel;
}
