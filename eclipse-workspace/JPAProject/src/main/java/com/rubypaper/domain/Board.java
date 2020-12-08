package com.rubypaper.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

//@Data
@Entity
@Table(name="NEW_BOARD", 
       uniqueConstraints={@UniqueConstraint(columnNames={"SEQ", "WRITER"})}) 
public class Board {
	@Id
	@GeneratedValue//(strategy=GenerationType.AUTO)
	// PK 컬럼과 매핑되는 변수를 식별자 변수라고 한다. 
	private Long seq;

	@Column(nullable=false, length=200)
	private String title;

	@Column(nullable=false, updatable=false)
	private String writer;

	@Column(nullable=false)
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="date default sysdate")
	private Date createDate = new Date();

	@Column(columnDefinition="number default 0")
	private Long cnt = 0L;
	
	@Transient
	private String searchCondition;

	@Transient
	private String searchKeyword;

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + ", searchCondition=" + searchCondition
				+ ", searchKeyword=" + searchKeyword + "]";
	}	
	
}
