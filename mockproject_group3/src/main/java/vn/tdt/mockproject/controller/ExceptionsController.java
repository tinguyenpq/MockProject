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
 * ExceptionsController.java
 * @author ThanhTien
 * @since 08-08-2015
 */
@Controller
public class ExceptionsController {
	private static final Logger LOGGER = Logger.getLogger(ExceptionsController.class);


	/**
	 * 403 status code
	 * 
	 * @param model model
	 * @return view
	 */
	@RequestMapping(method = RequestMethod.GET, value = PathConstants.HTML_EXCEPTION_403)
	public String exception403(Model model) {
		LOGGER.debug("Error 403 is executed!");
		return ViewConstants.HTML_EXCEPTION_403;
	}

	/**
	 * 404 status code
	 * 
	 * @param model model
	 * @return view
	 */
	@RequestMapping(method = RequestMethod.GET, value = PathConstants.HTML_EXCEPTION_404)
	public String exception404(Model model) {
		LOGGER.debug("Error 404 is executed!");
		model.addAttribute("denied", "You can not access this page");
		return ViewConstants.HTML_EXCEPTION_404;
	}

	/**
	 * 500 status code
	 * 
	 * @param model model
	 * @return view
	 */
	@RequestMapping(method = RequestMethod.GET, value = PathConstants.HTML_EXCEPTION_500)
	public String exception500(Model model) {
		LOGGER.debug("Error 500 is executed!");
		return ViewConstants.HTML_EXCEPTION_500;
	}

}
