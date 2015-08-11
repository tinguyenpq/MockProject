/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.tdt.mockproject.common.constant.PathConstants;
import vn.tdt.mockproject.common.constant.ViewConstants;
import vn.tdt.mockproject.common.validator.form.AgreementSearchForm;
import vn.tdt.mockproject.common.validator.form.CustomerSearchForm;
import vn.tdt.mockproject.common.validator.form.CustomerSelectForm;
import vn.tdt.mockproject.entity.Agreement;
import vn.tdt.mockproject.entity.AgreementInfo;
import vn.tdt.mockproject.entity.RFONumber;
import vn.tdt.mockproject.service.IAgreementService;
import vn.tdt.mockproject.service.IAgreementStatusService;
import vn.tdt.mockproject.service.ICustomerTyperService;
import vn.tdt.mockproject.service.IRFONumberService;

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
	private IAgreementService iAgreementService;

	@Autowired
	private IRFONumberService iRFONumberService;

	@Autowired
	private ICustomerTyperService iCustomerTyperService;

	@Autowired
	private IAgreementStatusService iAgreementStatusService;

	/**
	 * Select customer function /get
	 * 
	 * @author ThanhTien
	 * @since 08-08-2015
	 */
	@RequestMapping(value = { PathConstants.AGREEMENT_ADD_AGREEMENT,
			PathConstants.AGREEMENT_SELECT_CUSTOMER }, method = RequestMethod.GET)
	public String getSelectCustomer(Model model) {
		// logs debug message
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Select customer is executed!");
		}
		model.addAttribute("customerSearchForm", new CustomerSearchForm());
		model.addAttribute("customerSelectForm", new CustomerSelectForm());
		model.addAttribute("listRFONumber", iRFONumberService.findAll());
		return ViewConstants.AGREEMENT_SELECT_CUSTOMER;
	}

	/**
	 * Select customer function /post
	 * 
	 * @author ThanhTien
	 * @since 10-08-2015
	 */
	@RequestMapping(value = PathConstants.AGREEMENT_SELECT_CUSTOMER, method = RequestMethod.POST)
	public String postSelectCustomer(Model model) {
		// logs debug message
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Post Select customer is executed!");
		}
		
		return ViewConstants.AGREEMENT_SELECT_CUSTOMER;
	}

	

	/**
	 * copy agreement function /post
	 * 
	 * @author ThanhTien
	 * @since 10-08-2015
	 */
	
	@RequestMapping(value = PathConstants.AGREEMENT_COPY, method = RequestMethod.GET)
	public String copyAgreement(Model model) {
		// logs debug message
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Copy agreement is executed!");
		}

		return ViewConstants.AGREEMENT_COPY;
	}

	/**
	 * agreement search function
	 * 
	 * @author PhatVT
	 * @since 09-08-2015
	 */
	@RequestMapping(value = PathConstants.AGREEMENT_SEARCH, method = RequestMethod.GET)
	public String search(Model model) {
		// logs debug message
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Search agreement is executed!");
		}

		model.addAttribute("agrSearchForm", new AgreementSearchForm());
		model.addAttribute("cusTypes", iCustomerTyperService.findAll());
		model.addAttribute("agrStatuses", iAgreementStatusService.findAll());

		return ViewConstants.AGREEMENT_SEARCH;
	}

	/**
	 * agreement search function
	 * 
	 * @author PhatVT
	 * @since 09-08-2015
	 */
	@RequestMapping(value = PathConstants.AGREEMENT_SEARCH, method = RequestMethod.POST)
	public String search(@ModelAttribute("agrSearchForm") AgreementSearchForm agrSearchForm,
			Model model) {

		int agrNumberInt = 0;
		String agrNumberStr = agrSearchForm.getAgrNumber();
		int cusTypeIdInt = agrSearchForm.getCusTypeId();
		int agrStatusIdInt = agrSearchForm.getAgrStatusId();
		String startDate = agrSearchForm.getStartDate();
		String endDate = agrSearchForm.getEndDate();
		String cusName = agrSearchForm.getCusName();
		String cusPostcode = agrSearchForm.getCusPostcode();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = null;
		Date end = null;
		
		try {
			
			if (!"".equals(startDate) && startDate != null) {
				start = sdf.parse(formatDate(startDate));
			}
			
			if (!"".equals(endDate) && endDate != null) {
				end = sdf.parse(formatDate(endDate));
			}
				
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (!"".equals(agrNumberStr) && agrNumberStr != null) {
			agrNumberInt = Integer.parseInt(agrNumberStr);
		}

		List<AgreementInfo> lst = iAgreementService
				.findAll(cusTypeIdInt, cusName,
						cusPostcode, agrStatusIdInt,
						start, end, agrNumberInt);

		if (lst == null || lst.size() == 0) {
			model.addAttribute("message", "Result does not exist.");
		}
		
		model.addAttribute("agreementList", lst);
		model.addAttribute("cusTypes", iCustomerTyperService.findAll());
		model.addAttribute("agrStatuses", iAgreementStatusService.findAll());

		return ViewConstants.AGREEMENT_SEARCH;
	}
	
	/** view an agreement function
	 * @author PhatVT
	 * @param String
	 */
	@RequestMapping(value = PathConstants.AGREEMENT_VIEW, method = RequestMethod.POST)
	public String view(@RequestParam("selected") String selected, Model model) {
		
		System.out.println(selected);
		String agrInfo[] = selected.split("///");
		
		for (String str : agrInfo) {
			System.out.println(str);
		}
		

		return ViewConstants.AGREEMENT_VIEW;
	}
	
	/**@
	 * @author PhatVT
	 * @param String
	 */
	private String formatDate(String dateStr) {
		String dateArr[] = dateStr.split("/");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		return year + "-" + month + "-" + day;
	}
	
	

}
