package io._10a.academy.security.controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import io._10a.academy.security.entity.User;

@Stateless
public class UserController {

	@PersistenceContext EntityManager entityManager;

	public List<User> getAllUsers() {
		return entityManager.createNamedQuery("Users.findAll").getResultList();
	}

}
