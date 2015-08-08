/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.tdt.mockproject.common.constant.PathConstants;
import vn.tdt.mockproject.common.constant.ViewConstants;
import vn.tdt.mockproject.service.IRFONumberService;
import vn.tdt.mockproject.service.IAgreementStatusService;
import vn.tdt.mockproject.service.ICustomerTyperService;

/**
 * AgreementController.java
 * 
 * @author ThanhTien
 * @since 08-08-2015
 */
@Controller
public class AgreementController {
	private static final Logger LOGGER = Logger.getLogger(AgreementController.class);

	@Autowired
	private IRFONumberService iRFONumberService;
	
	@Autowired
	private ICustomerTyperService cusTypeService;
	
	@Autowired
	private IAgreementStatusService agrStatusService;
	
	@RequestMapping(value = { PathConstants.AGREEMENT_ADD_AGREEMENT,
			PathConstants.AGREEMENT_SELECT_CUSTOMER }, method = RequestMethod.GET)
	public String selectCustomer(Model model) {
		// logs debug message
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Select customer is executed!");
		}
		
		model.addAttribute("listRFONumber", iRFONumberService.findAll());
		return ViewConstants.AGREEMENT_SELECT_CUSTOMER;
	}

	@RequestMapping(value = PathConstants.AGREEMENT_COPY, method = RequestMethod.GET)
	public String copyAgreement(Model model) {
		// logs debug message
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Copy agreement is executed!");
		}

		return ViewConstants.AGREEMENT_COPY;
	}
	
	@RequestMapping(value = PathConstants.AGREEMENT_SEARCH, method = RequestMethod.GET)
	public String search(Model model) {
		// logs debug message
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Search agreement is executed!");
		}
		
		model.addAttribute("cusTypes", cusTypeService.findAll());
		model.addAttribute("agrStatuses", agrStatusService.findAll());
		
		return ViewConstants.AGREEMENT_SEARCH;
	}
	
	
	
}

