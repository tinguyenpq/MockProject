package vn.tdt.mockproject.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.tdt.mockproject.common.constant.PathConstants;
import vn.tdt.mockproject.common.constant.ViewConstants;
import vn.tdt.mockproject.service.IAgreementStatusService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger LOGGER = Logger.getLogger(HomeController.class);
	@Autowired
	private IAgreementStatusService iAgreementStatusService;
	
	@RequestMapping(value = PathConstants.COMMON_HOME, method = RequestMethod.GET)
	public String home(Model model) {
		// logs debug message
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Home is executed!");
		}
	
		model.addAttribute("listCountStatusAgreement", iAgreementStatusService.countAll());
		
		return ViewConstants.COMMON_HOME;
	}

}
