package edu.mum.candidate.service;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.candidate.entity.Accomplishment;
import edu.mum.candidate.entity.Candidate;
import edu.mum.candidate.entity.Education;
import edu.mum.candidate.entity.Experience;
import edu.mum.candidate.entity.Interest;
import edu.mum.candidate.entity.Skill;
import edu.mum.candidate.repository.CandidateDAO;
import edu.mum.candidate.repository.CandidateRepository;
import edu.mum.candidate.repository.ExperienceRepository;

@Service
public class CandidateService {
	
	@Autowired
	private CandidateRepository candidateRepository;

	
	@Autowired
	private CandidateDAO candidateDAO;
	
	public void addCandidate(Candidate candidate) {
		candidateRepository.save(candidate);
	}
	
	public void updateCandidate(String id, Candidate candidate) {
		Candidate toUpdate = getCandidateById(id); 
		toUpdate.setName(candidate.getName());
		toUpdate.setEmailAddress(candidate.getEmailAddress());
		toUpdate.setTitle(candidate.getTitle());
		toUpdate.setSummary(candidate.getSummary());
		toUpdate.setAddress(candidate.getAddress());
		candidateRepository.save(toUpdate);
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
		return candidateRepository.findAll();
	}

	public void addExperience(String id,Experience experience) {
		Candidate toUpdate = getCandidateById(id);  
		toUpdate.getExperiences().add(experience);
		experience.setOwner(toUpdate);
		candidateRepository.save(toUpdate);
	}

	public void addEducation(String id, Education education) {
		Candidate toUpdate = getCandidateById(id);  
		toUpdate.getEducations().add(education);
		education.setOwner(toUpdate);
		candidateRepository.save(toUpdate);
	}

	public void addSkill(String id, Skill skill) {
		Candidate toUpdate = getCandidateById(id);  
		toUpdate.getSkills().add(skill);
		skill.setOwner(toUpdate);
		candidateRepository.save(toUpdate);
	}

	public void addInterest(String id, Interest interest) {
		Candidate toUpdate = getCandidateById(id);  
		toUpdate.getInterests().add(interest);
		interest.setOwner(toUpdate);
		candidateRepository.save(toUpdate);
		
	}

	public void addAccomplishment(String id, Accomplishment accomplishment) {
		Candidate toUpdate = getCandidateById(id);  
		toUpdate.getAccomplishments().add(accomplishment);
		accomplishment.setOwner(toUpdate);
		candidateRepository.save(toUpdate);
	}

	public void updatePictureLocalURL(String id, String pictureLocalURL) {
		Candidate toUpdate = getCandidateById(id); 
		toUpdate.setPictureLocalURL(pictureLocalURL);
		candidateRepository.save(toUpdate);
		
	}

	
	
	
	
	

}
