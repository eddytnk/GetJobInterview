package edu.mum.candidate.domain;

import javax.persistence.*;
@Entity
@Table(name="tb_interest")
public class Interest {
	@Id @GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate owner;
	
	private String interestName; // wanna use InterestCategory enitity? and then this entity will have Many to One to Candidate and that InterestCategory ? 

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

	public String getInterestName() {
		return interestName;
	}

	public void setInterestName(String interestName) {
		this.interestName = interestName;
	}
	

}
