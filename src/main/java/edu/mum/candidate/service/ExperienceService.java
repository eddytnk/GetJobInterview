package edu.mum.candidate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.candidate.entity.Experience;
import edu.mum.candidate.repository.ExperienceRepository;

@Service
public class ExperienceService {
	@Autowired
	private ExperienceRepository experienceRepository;
	
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

	public void delete(String id) {
		experienceRepository.delete(getExperienceById(id));
		
	}	

}
