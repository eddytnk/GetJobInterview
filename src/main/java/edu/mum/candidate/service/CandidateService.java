package edu.mum.candidate.service;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.candidate.entity.Candidate;
import edu.mum.candidate.entity.Experience;
import edu.mum.candidate.repository.CandidateDAO;
import edu.mum.candidate.repository.CandidateRepository;
import edu.mum.candidate.repository.ExperienceRepository;

@Service
public class CandidateService {
	
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private ExperienceRepository experienceRepository;
	
	@Autowired
	private CandidateDAO candidateDAO;
	
	public void addCandidate(Candidate candidate) {
		candidateRepository.save(candidate);
	}
	
	public void updateCandidate(String id, Candidate candidate) {
		Candidate toUpdate = getCandidateById(id); //repository.getOne(Long.parseLong(candidate.getId()+"")); 
		//if(existing != null) candidate.setId(existing.getId());
		toUpdate.setName(candidate.getName());
		toUpdate.setEmailAddress(candidate.getEmailAddress());
		toUpdate.setTitle(candidate.getTitle());
		toUpdate.setSummary(candidate.getSummary());
		toUpdate.setAddress(candidate.getAddress());
		candidateRepository.save(toUpdate);
		
		//repository.
	}
	
	public void deleteCandidate(String candidateId) {
		candidateRepository.delete(getCandidateById(candidateId));
	}
	
	public Candidate getCandidateById(String candidateId){
		return candidateRepository.getOne(Long.parseLong(candidateId)); 
	}
	
	public List<Candidate> findByName(String name){
		return candidateDAO.findByName(name);
	}
	public List<Candidate> findByEmailAddress(String emailAddress){
		return candidateDAO.findByEmailAddress(emailAddress);
	}

	public Collection<Candidate> getCandidates() {
		// TODO Auto-generated method stub
		return candidateRepository.findAll();
	}

	public void addExperience(String id,Experience experience) {
		// TODO Auto-generated method stub
		Candidate toUpdate = getCandidateById(id);  
		toUpdate.getExperiences().add(experience);
		experience.setOwner(toUpdate);
		/*toUpdate.setEmailAddress(candidate.getEmailAddress());
		toUpdate.setTitle(candidate.getTitle());
		toUpdate.setSummary(candidate.getSummary());
		toUpdate.setAddress(candidate.getAddress());*/
		candidateRepository.save(toUpdate);
		
		//repository.
	}

	public Experience getExperienceById(String id) {
		// TODO Auto-generated method stub
		return experienceRepository.getOne(Long.parseLong(id)); 
	}

	public void updateExperience(String id, Experience experience) {
		// TODO Auto-generated method stub
		Experience toUpdate = getExperienceById(id); //repository.getOne(Long.parseLong(candidate.getId()+"")); 
		//if(existing != null) candidate.setId(existing.getId());
		toUpdate.setPosition(experience.getPosition());
		toUpdate.setCompanyName(experience.getCompanyName());
		toUpdate.setCompanyAddress(experience.getCompanyAddress());
		toUpdate.setDescription(experience.getDescription());
		toUpdate.setCurrentlyWorkHere(experience.isCurrentlyWorkHere());
		toUpdate.setPeriodFrom(experience.getPeriodFrom());
		toUpdate.setPeriodTo(experience.getPeriodTo());
		toUpdate.setFromMonth(experience.getFromMonth());
		toUpdate.setFromYear(experience.getFromYear());
		toUpdate.setToMonth(experience.getToMonth());
		toUpdate.setToYear(experience.getToYear());
		experienceRepository.save(toUpdate);
		
		//repository.
	}	
	
	
	
	

}
