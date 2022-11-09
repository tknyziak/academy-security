package io._10a.academy.security;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io._10a.academy.security.controller.UserController;

@Singleton
@Startup
public class StartupBean {

	@EJB UserController userController;

	private Logger logger = LoggerFactory.getLogger(getClass());

	@PostConstruct
	public void init() {
		logger.info("All users: {}", userController.getAllUsers());
	}

}
