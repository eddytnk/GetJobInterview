package edu.mum.candidate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.candidate.entity.Skill;
import edu.mum.candidate.repository.SkillRepository;

@Service
public class SkillService {
	@Autowired
	private SkillRepository skillRepository;
	
	public Skill getSkillById(String id) {
		// TODO Auto-generated method stub
		return skillRepository.getOne(Long.parseLong(id)); 
	}

	public void updateSkill(String id, Skill skill) {
		// TODO Auto-generated method stub
		Skill toUpdate = getSkillById(id);
		toUpdate.setTitle(skill.getTitle());
		toUpdate.setDescription(skill.getDescription());		
		skillRepository.save(toUpdate);
	}	

}
