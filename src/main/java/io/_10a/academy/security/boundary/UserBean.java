package io._10a.academy.security.boundary;

import java.io.Serializable;
import java.security.Principal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import io._10a.academy.security.controller.UserController;
import io._10a.academy.security.entity.User;

@Named
@SessionScoped
public class UserBean implements Serializable {

	User user;

	@EJB UserController userController;

	@PostConstruct
	public void init() {
		user = userController.getUserByPrincipal();
	}

	public User getUser() {
		return user;
	}
}
