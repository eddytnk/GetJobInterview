package edu.mum.candidate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.candidate.entity.Education;
import edu.mum.candidate.repository.EducationRepository;

@Service
public class EducationService {
	@Autowired
	private EducationRepository educationRepository;
	
	public Education getEducationById(String id) {
		// TODO Auto-generated method stub
		return educationRepository.getOne(Long.parseLong(id)); 
	}

	public void updateEducation(String id, Education education) {
		// TODO Auto-generated method stub
		Education toUpdate = getEducationById(id); //repository.getOne(Long.parseLong(candidate.getId()+"")); 
		toUpdate.setSchoolName(education.getSchoolName());
		toUpdate.setDegree(education.getDegree());
		toUpdate.setFieldStudy(education.getFieldStudy());
		toUpdate.setDescription(education.getDescription());
		toUpdate.setYearFrom(education.getYearFrom());
		toUpdate.setYearTo(education.getYearTo());
		
		educationRepository.save(toUpdate);
		
		//repository.
	}

	public void delete(String id) {
		educationRepository.delete(getEducationById(id));
		
	}	

}
