package edu.mum.candidate.service;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.candidate.entity.Candidate;
import edu.mum.candidate.repository.CandidateDAO;
import edu.mum.candidate.repository.CandidateRepository;

@Service
public class CandidateService {
	
	@Autowired
	private CandidateRepository repository;
	
	@Autowired
	private CandidateDAO dao;
	
	public void addCandidate(Candidate candidate) {
		repository.save(candidate);
	}
	
	public void updateCandidate(Candidate candidate) {
		//repository.
	}
	
	public void deleteCandidate(String candidateId) {
		repository.delete(getById(candidateId));
	}
	
	public Candidate getById(String candidateId){
		return repository.getOne(Long.parseLong(candidateId)); 
	}
	
	public List<Candidate> findByName(String name){
		return dao.findByName(name);
	}
	public List<Candidate> findByEmailAddress(String emailAddress){
		return dao.findByEmailAddress(emailAddress);
	}

	public Collection<Candidate> getCandidates() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}	
	
	
	
	

}
