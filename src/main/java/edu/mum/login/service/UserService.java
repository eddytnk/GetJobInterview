package edu.mum.login.service;
/**
 * @author: ChauKy
 * @Date: Apr 22, 2018
 * Reference: https://www.ashtpoint.com/spring-boot/spring-boot-login-example.html
 */
import edu.mum.login.entity.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);
}
