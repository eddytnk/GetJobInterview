package edu.mum.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.company.entity.Company;
import edu.mum.login.repository.UserCompanyDAO;
import edu.mum.login.entity.User;
@Service
public class UserCompanyService {
	@Autowired
	private UserCompanyDAO usercompanyDAO;
	@Autowired
	private UserService userService;
	
	public Company getCompanyByUser(User user) {
		// TODO Auto-generated method stub
		return usercompanyDAO.findByUserId(user.getId());
	}
	
	public Company getCompanyByUserName(String userName) {
		User user = userService.findByUsername(userName);		
		return getCompanyByUser(user);
	}
	
}
