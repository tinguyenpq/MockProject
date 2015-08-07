/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.tdt.mockproject.common.constant.PathConstants;
import vn.tdt.mockproject.common.constant.ViewConstants;

/**
 * AccessController.java
 * 
 * @author ThanhTien
 * @since 07-08-2015
 */
@Controller
public class AccessController {
	private static final Logger LOGGER = Logger.getLogger(AccessController.class);

	@RequestMapping(value = { PathConstants.COMMON_LOGIN, PathConstants.COMMON_LOGIN_HOME }, method = RequestMethod.GET)
	public String login(Model model) {
		// logs debug message
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Login is executed!");
		}
		// /Get user current Comment
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// get logged in username
		String username = auth.getName();
		LOGGER.info("Username: " + username);
		if ("anonymousUser".equals(username) == false)
			return ViewConstants.COMMON_HOME;

		return ViewConstants.COMMON_LOGIN;
	}
}
