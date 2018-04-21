package edu.mum.candidate.domain;

import javax.persistence.*;
@Entity
@Table(name="tb_accomplishment")
public class Accomplishment {
	@Id @GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate owner;
	
	private String accomplishmentDescription; // wanna separate to Accomplishment types?  

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Candidate getOwner() {
		return owner;
	}

	public void setOwner(Candidate owner) {
		this.owner = owner;
	}

	public String getAccomplishmentDescription() {
		return accomplishmentDescription;
	}

	public void setAccomplishmentDescription(String accomplishmentDescription) {
		this.accomplishmentDescription = accomplishmentDescription;
	}
	
	
	
	

}
