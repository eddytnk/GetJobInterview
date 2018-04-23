package edu.mum.login.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @author: ChauKy
 * @Date: Apr 22, 2018
 * Reference: https://www.ashtpoint.com/spring-boot/spring-boot-login-example.html
 */

@Entity
@Table(name = "role")
public class Role {
	private Long id;
	private String name;
	private Set<User> users;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "roles")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
