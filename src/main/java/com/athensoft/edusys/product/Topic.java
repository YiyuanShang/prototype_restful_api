package com.athensoft.edusys.product;

import java.util.List;

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
@Table(name = "prod_topic")
@Getter @Setter @NoArgsConstructor @ToString
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int topicId;
	private String subject;
	private String module;
	private String topicDesc;
	private List<Question> questions;
}
