package edu.mum.candidate.entity;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="tb_candidate")
public class Candidate {
	@Id @GeneratedValue
	private Long id;
	
	private String name;	
	private String pictureLocalURL;
	
	@Embedded
	Address address;
	
	private String summary;
	
	@OneToMany(mappedBy="owner")
	private List<Experience> experiences = new ArrayList<Experience>();;
	
	@OneToMany(mappedBy="owner")
	private List<Education> educations= new ArrayList<Education>();

	@OneToMany(mappedBy="owner")
	private List<Skill> skills = new ArrayList<Skill>();
	
	@OneToMany(mappedBy="owner")
	private List<Interest> interests= new ArrayList<Interest>();
	
	@OneToMany(mappedBy="owner")
	private List<Accomplishment> accomplishments= new ArrayList<Accomplishment>();
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public String getPictureLocalURL() {
		return pictureLocalURL;
	}

	public void setPictureLocalURL(String pictureLocalURL) {
		this.pictureLocalURL = pictureLocalURL;
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
