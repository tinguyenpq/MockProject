/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.tdt.mockproject.common.constant.PathConstants;
import vn.tdt.mockproject.common.constant.ViewConstants;
import vn.tdt.mockproject.common.validator.form.CustomerSearchForm;
import vn.tdt.mockproject.common.validator.form.CustomerSelectForm;
import vn.tdt.mockproject.service.IRFONumberService;

/**
 * CustomerController.java
 * 
 * @author ThanhTien
 * @since 10-08-2015
 */
@Controller
public class CustomerController {

	private static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	@Autowired
	private IRFONumberService iRFONumberService;

	/**
	 * Search customer function /post
	 * 
	 * @author ThanhTien
	 * @since 10-08-2015
	 */
	@RequestMapping(value = PathConstants.AGREEMENT_SEARCH_CUSTOMER, method = RequestMethod.POST)
	public String postSearchSelectCustomer(Model model, @Valid CustomerSearchForm customerSearchForm,
			BindingResult bindingResult) {
		// logs debug message
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Search customer is executed!");
		}

		if (bindingResult.hasErrors()) {
			LOGGER.info("LOGGER: Search Customer ERROR");
			return ViewConstants.AGREEMENT_SELECT_CUSTOMER;
		}
		model.addAttribute("customerSelectForm", customerSearchForm);
		model.addAttribute("listRFONumber", iRFONumberService.findAll(customerSearchForm));
		return ViewConstants.AGREEMENT_SELECT_CUSTOMER;
	}
}
