package edu.mum.candidate.domain;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="tb_candidate")
public class Candidate {
	@Id @GeneratedValue
	private int id;
	
	private String name;
	
	@Lob
	private byte[]picture;
	
	@Embedded
	Address address;
	
	private String summary;
	
	@OneToMany(mappedBy="owner")
	private List<Experience> experiences;
	
	@OneToMany(mappedBy="owner")
	private List<Education> educations;

	@OneToMany(mappedBy="owner")
	private List<Skill> skills;
	
	@OneToMany(mappedBy="owner")
	private List<Interest> interests;
	
	@OneToMany(mappedBy="owner")
	private List<Accomplishment> accomplishments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Interest> getInterests() {
		return interests;
	}

	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}

	public List<Accomplishment> getAccomplishments() {
		return accomplishments;
	}

	public void setAccomplishments(List<Accomplishment> accomplishments) {
		this.accomplishments = accomplishments;
	}
	
	
	
	
	
	
	
	
	

}
