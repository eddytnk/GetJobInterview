package edu.mum.candidate.entity;

import java.util.*;
import javax.persistence.*;

import edu.mum.common.Address;

@Entity
@Table(name="tb_experience")
public class Experience {
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate owner;
	
	private String position;	
	private String companyName;
	
	@Embedded
	private Address companyAddress;
	@Lob
	private String description;	
	private boolean isCurrentlyWorkHere;
	
	@Temporal(TemporalType.DATE)
	private Date periodFrom;
	
	@Temporal(TemporalType.DATE)
	private Date periodTo;

	//@Transient
	private Integer fromMonth;
	//@Transient
	private Integer fromYear;
	//@Transient
	private Integer toMonth;
	//@Transient
	private Integer toYear;
	
	

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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Address getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(Address companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPeriodFrom() {
		return periodFrom;
	}

	public void setPeriodFrom(Date periodFrom) {
		this.periodFrom = periodFrom;
	}

	public Date getPeriodTo() {
		return periodTo;
	}

	public void setPeriodTo(Date periodTo) {
		this.periodTo = periodTo;
	}

	public boolean isCurrentlyWorkHere() {
		return isCurrentlyWorkHere;
	}

	public void setCurrentlyWorkHere(boolean isCurrentlyWorkHere) {
		this.isCurrentlyWorkHere = isCurrentlyWorkHere;
	}

	public Integer getFromMonth() {
		return fromMonth;
	}

	public void setFromMonth(Integer fromMonth) {
		this.fromMonth = fromMonth;
	}

	public Integer getFromYear() {
		return fromYear;
	}

	public void setFromYear(Integer fromYear) {
		this.fromYear = fromYear;
	}

	public Integer getToMonth() {
		return toMonth;
	}

	public void setToMonth(Integer toMonth) {
		this.toMonth = toMonth;
	}

	public Integer getToYear() {
		return toYear;
	}

	public void setToYear(Integer toYear) {
		this.toYear = toYear;
	}

	
	

	
}
