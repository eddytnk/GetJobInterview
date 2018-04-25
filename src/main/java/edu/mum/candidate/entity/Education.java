package edu.mum.candidate.entity;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="tb_education")
public class Education {
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate owner;
	
	private String schoolName;
	private String degree;
	private String fieldStudy;
	@Lob
	private String description;
	
	private int yearFrom;
	private int yearTo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Candidate getOwner() {
		return owner;
	}
	public void setOwner(Candidate owner) {
		this.owner = owner;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getFieldStudy() {
		return fieldStudy;
	}
	public void setFieldStudy(String fieldStudy) {
		this.fieldStudy = fieldStudy;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getYearFrom() {
		return yearFrom;
	}
	public void setYearFrom(int yearFrom) {
		this.yearFrom = yearFrom;
	}
	public int getYearTo() {
		return yearTo;
	}
	public void setYearTo(int yearTo) {
		this.yearTo = yearTo;
	}
	
	

}
