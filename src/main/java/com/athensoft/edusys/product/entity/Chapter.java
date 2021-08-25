package com.athensoft.edusys.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prod_chapter")
public class Chapter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chapter_id")
	private Integer chapterId;
	
	private String chapterCode;
	
	private String chapterTitle;
	
	private String chapterDesc;

	public Integer getChapterId() {
		return chapterId;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

	public String getChapterCode() {
		return chapterCode;
	}

	public void setChapterCode(String chapterCode) {
		this.chapterCode = chapterCode;
	}

	public String getChapterTitle() {
		return chapterTitle;
	}

	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}

	public String getChapterDesc() {
		return chapterDesc;
	}

	public void setChapterDesc(String chapterDesc) {
		this.chapterDesc = chapterDesc;
	}

	@Override
	public String toString() {
		return "Chapter [chapterId=" + chapterId + ", chapterCode=" + chapterCode + ", chapterTitle=" + chapterTitle
				+ ", chapterDesc=" + chapterDesc + "]";
	}
	
	

}
