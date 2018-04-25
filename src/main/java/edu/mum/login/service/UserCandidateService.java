package edu.mum.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.candidate.entity.Candidate;
import edu.mum.login.repository.UserCandidateDAO;
import edu.mum.login.entity.User;
@Service
public class UserCandidateService {
	@Autowired
	private UserCandidateDAO usercandidateDAO;
	
	public Candidate getCandidateByUser(User user) {
		// TODO Auto-generated method stub
		return usercandidateDAO.findUserId(user.getId());
	}
}
