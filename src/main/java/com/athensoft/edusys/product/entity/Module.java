package com.athensoft.edusys.product.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "prod_module")
public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "module_id")
	private Integer moduleId = -1;

	private String moduleCode;

	private String moduleTitle;

	private String moduleDesc;

	@OneToMany
	@JoinTable(name = "prod_rel_module_question", joinColumns = @JoinColumn(name = "module_id", referencedColumnName = "module_id"), inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "question_id"))
	private List<Question> questions;

	@OneToMany
	@JoinTable(name = "prod_chapter", joinColumns = @JoinColumn(name = "module_id", referencedColumnName = "module_id"), inverseJoinColumns = @JoinColumn(name = "chapter_id", referencedColumnName = "chapter_id"))
	private List<Chapter> chapters;
	
	public Module() {
	}

	public Module(Integer moduleId, String moduleCode, String moduleTitle, String moduleDesc) {
		super();
		this.moduleId = moduleId;
		this.moduleCode = moduleCode;
		this.moduleTitle = moduleTitle;
		this.moduleDesc = moduleDesc;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModuleTitle() {
		return moduleTitle;
	}

	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}

	public String getModuleDesc() {
		return moduleDesc;
	}

	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", moduleCode=" + moduleCode + ", moduleTitle=" + moduleTitle
				+ ", moduleDesc=" + moduleDesc + ", questions=" + questions + ", chapters=" + chapters + "]";
	}

	
}
