package edu.mum.candidate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.candidate.entity.Interest;
import edu.mum.candidate.repository.InterestRepository;

@Service
public class InterestService {
	@Autowired
	private InterestRepository interestRepository;
	
	public Interest getInterestById(String id) {
		// TODO Auto-generated method stub
		return interestRepository.getOne(Long.parseLong(id)); 
	}

	public void updateInterest(String id, Interest interest) {
		// TODO Auto-generated method stub
		Interest toUpdate = getInterestById(id);
		toUpdate.setTitle(interest.getTitle());
		toUpdate.setDescription(interest.getDescription());		
		interestRepository.save(toUpdate);
	}	

}
