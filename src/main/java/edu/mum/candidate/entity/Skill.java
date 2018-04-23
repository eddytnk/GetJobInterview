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
	
	private String skillName; // wanna use SkillCategory enitity? and then this entity will have Many to One to Candidate and that SkillCategory ? 

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

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	

}
