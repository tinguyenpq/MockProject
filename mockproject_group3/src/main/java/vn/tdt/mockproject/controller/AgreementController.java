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
	public String search(@RequestParam(value = "cusTypeId") String cusTypeIdStr,
			@RequestParam(value = "cusName") String cusName,
			@RequestParam(value = "cusPostcode") String cusPostcode,
			@RequestParam(value = "agrStatusId") String agrStatusIdStr,
			@RequestParam(value = "startDate") String startDate,
			@RequestParam(value = "endDate") String endDate,
			@RequestParam(value = "agrNumber") String agrNumberStr, Model model) {

		int agrNumberInt = 0;
		int cusTypeIdInt = 0;
		int agrStatusIdInt = 0;
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
		
		if (!"".equals(cusTypeIdStr) && cusTypeIdStr != null) {
			cusTypeIdInt = Integer.parseInt(cusTypeIdStr);
		}
		
		if (!"".equals(agrStatusIdStr) && agrStatusIdStr != null) {
			agrStatusIdInt = Integer.parseInt(agrStatusIdStr);
		}
		
		

		// System.out.println("Customer type id: " + cusTypeId);
		// System.out.println("Customer name: " + cusName);
		// System.out.println("Customer postcode: " + cusPostcode);
		// System.out.println("status: " + agrStatusId);
		// System.out.println("start: " + startDate);
		// System.out.println("end: " + endDate);
		// System.out.println("agr number: " + agrNumber);

		List<AgreementInfo> lst = iAgreementService
				.findAll(cusTypeIdInt, cusName,
						cusPostcode, agrStatusIdInt,
						start, end, agrNumberInt);
		// for (AgreementInfo agr : lst) {
		//
		// System.out.println("Customer: " + agr.getCompanyName());
		// System.out.println("Postcode: " + agr.getPostCode());
		// System.out.println("Startdate: " + agr.getStartDate());
		// System.out.println("Enddate: " + agr.getEndDate());
		// System.out.println("Agreement: " + agr.getAgreementNumber() + "\\" +
		// agr.getVariantNumber());
		// System.out.println("Status: " + agr.getAgreementStatusName());
		//
		// }

		model.addAttribute("agreementList", lst);
		model.addAttribute("cusTypes", iCustomerTyperService.findAll());
		model.addAttribute("agrStatuses", iAgreementStatusService.findAll());

		return ViewConstants.AGREEMENT_SEARCH;
	}
	
	private String formatDate(String dateStr) {
		String dateArr[] = dateStr.split("/");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		return year + "-" + month + "-" + day;
	}
	
	

}
