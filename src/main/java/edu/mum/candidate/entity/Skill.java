package edu.mum.candidate.entity;

import javax.persistence.*;

@Entity
@Table(name="tb_skill")
public class Skill {
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate owner;
	
	private String title;
	private String description; // wanna use SkillCategory enitity? and then this entity will have Many to One to Candidate and that SkillCategory ? 
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	

	

}
