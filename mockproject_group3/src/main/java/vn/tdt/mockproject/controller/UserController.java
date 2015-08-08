/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.tdt.mockproject.common.constant.PathConstants;
import vn.tdt.mockproject.common.constant.ViewConstants;

/**
 * UserController.java
 * 
 * @author ThanhTien
 * @since 08-08-2015
 */
@Controller
public class UserController {
	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	@RequestMapping(value = PathConstants.COMMON_USER_PROFILE, method = RequestMethod.GET)
	public String getUserProfile(Model model) {
		// logs debug message
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("User is executed!");
		}
		
		return ViewConstants.COMMON_USER_PROFILE;
	}
	
	
}
