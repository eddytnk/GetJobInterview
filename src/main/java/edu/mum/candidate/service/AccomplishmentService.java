package edu.mum.candidate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.candidate.entity.Accomplishment;
import edu.mum.candidate.repository.AccomplishmentRepository;

@Service
public class AccomplishmentService {
	@Autowired
	private AccomplishmentRepository accomplishmentRepository;
	
	public Accomplishment getAccomplishmentById(String id) {
		// TODO Auto-generated method stub
		return accomplishmentRepository.getOne(Long.parseLong(id)); 
	}

	public void updateAccomplishment(String id, Accomplishment accomplishment) {
		// TODO Auto-generated method stub
		Accomplishment toUpdate = getAccomplishmentById(id);
		toUpdate.setTitle(accomplishment.getTitle());
		toUpdate.setDescription(accomplishment.getDescription());		
		accomplishmentRepository.save(toUpdate);
	}

	public void delete(String id) {
		accomplishmentRepository.delete(getAccomplishmentById(id));		
	}	

}
