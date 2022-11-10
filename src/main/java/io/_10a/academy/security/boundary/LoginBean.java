package io._10a.academy.security.boundary;

import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ViewScoped
@Named
public class LoginBean implements Serializable {


	private final Logger logger = LoggerFactory.getLogger(getClass());

	private String login;
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String doLogin() {
		logger.info("Credentials: login: {}, password: {}", login, password);

		final FacesContext facesContext = FacesContext.getCurrentInstance();
		final ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

		try {
			request.login(login, password);
			return "secure/user";
		} catch (ServletException e) {
			logger.error("Error loggin in", e);
			return null;
		}

	}

}
