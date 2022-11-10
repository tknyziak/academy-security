package io._10a.academy.security.controller;

import java.security.Principal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import io._10a.academy.security.entity.User;

@Stateless
public class UserController {

	@Inject Principal principal;

	@PersistenceContext EntityManager entityManager;

	public List<User> getAllUsers() {
		return entityManager.createNamedQuery("Users.findAll").getResultList();
	}

	public User getUserByPrincipal() {
		if (principal == null || principal.getName() == null) {
			return null;
		}
		return entityManager.createNamedQuery("Users.findByUsername", User.class).setParameter("username", principal.getName()).getSingleResult();
	}

}
