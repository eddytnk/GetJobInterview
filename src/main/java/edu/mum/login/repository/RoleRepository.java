package edu.mum.login.repository;
/**
 * @author: ChauKy
 * @Date: Apr 22, 2018
 * Reference: https://www.ashtpoint.com/spring-boot/spring-boot-login-example.html
 */
import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.login.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}