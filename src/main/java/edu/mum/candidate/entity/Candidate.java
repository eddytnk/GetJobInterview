package edu.mum.candidate.entity;

import java.util.*;
import javax.persistence.*;

import edu.mum.common.Address;

@Entity
@Table(name="tb_candidate")
public class Candidate {
	@Id @GeneratedValue
	private Long id;
	
	private String name;
	private String emailAddress;
	private String pictureLocalURL;
	
	@Embedded
	Address address;
	
	private String title;
	private String summary;
	
	
	@OneToMany(mappedBy="owner" , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Experience> experiences = new ArrayList<Experience>();
	
	@OneToMany(mappedBy="owner" , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Education> educations= new ArrayList<Education>();

	@OneToMany(mappedBy="owner" , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Skill> skills = new ArrayList<Skill>();
	
	@OneToMany(mappedBy="owner" , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Interest> interests= new ArrayList<Interest>();
	
	@OneToMany(mappedBy="owner" , cascade = CascadeType.ALL, orphanRemoval = true)
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
	

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
	//convenience methods: start
	public void addAccomplishment(Accomplishment accomplishment) {
		accomplishments.add(accomplishment);
		accomplishment.setOwner(this);
	}	
	public void removeAccomplishment(Accomplishment accomplishment) {
		accomplishment.setOwner(null);
		this.accomplishments.remove(accomplishment);
	}
	public void addEducation(Education education) {
		educations.add(education);
		education.setOwner(this);
	}	
	public void removeEducation(Education education) {
		education.setOwner(null);
		this.educations.remove(education);
	}
	public void addExperience(Experience experience) {
		experiences.add(experience);
		experience.setOwner(this);
	}	
	public void removeExperience(Experience experience) {
		experience.setOwner(null);
		this.experiences.remove(experience);
	}
	public void addInterest(Interest interest) {
		interests.add(interest);
		interest.setOwner(this);
	}	
	public void removeInterest(Interest interest) {
		interest.setOwner(null);
		this.interests.remove(interest);
	}
	
	public void addSkill(Skill skill) {
		skills.add(skill);
		skill.setOwner(this);
	}	
	public void removeSkill(Skill skill) {
		skill.setOwner(null);
		this.skills.remove(skill);
	}
	
	//convenience methods: end
	

}
