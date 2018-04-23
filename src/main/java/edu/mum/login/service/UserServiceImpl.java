package edu.mum.login.service;
/**
 * @author: ChauKy
 * @Date: Apr 22, 2018
 * Reference: https://www.ashtpoint.com/spring-boot/spring-boot-login-example.html
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.login.entity.User;
import edu.mum.login.repository.RoleRepository;
import edu.mum.login.repository.UserRepository;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@SuppressWarnings("unchecked")
	public void save(User user) {
		user.setPassword(user.getPassword());
		user.setRoles(new HashSet(roleRepository.findAll()));
		userRepository.save(user);
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}