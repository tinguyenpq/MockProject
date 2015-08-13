/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ValueConstants;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.tdt.mockproject.common.constant.PathConstants;
import vn.tdt.mockproject.common.constant.ViewConstants;
import vn.tdt.mockproject.common.validator.form.AgreementSearchForm;
import vn.tdt.mockproject.common.validator.form.CustomerSearchForm;
import vn.tdt.mockproject.common.validator.form.CustomerSelectForm;
import vn.tdt.mockproject.entity.Agreement;
import vn.tdt.mockproject.entity.RFOUser;
import vn.tdt.mockproject.service.IAgreementStatusService;
import vn.tdt.mockproject.service.ICustomerTyperService;
import vn.tdt.mockproject.service.IRFONumberService;
import vn.tdt.mockproject.service.IRFOUserService;
import vn.tdt.mockproject.service.ISystemConfigValueService;

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

	@Autowired
	private ICustomerTyperService iCustomerTyperService;

	@Autowired
	private ISystemConfigValueService iSystemValueService;

	@Autowired
	private IRFOUserService iRFOUserService;

	/**
	 * Search customer function /post
	 * 
	 * @author ThanhTien
	 * @since 10-08-2015
	 */
	@RequestMapping(value = PathConstants.AGREEMENT_SEARCH_CUSTOMER, method = RequestMethod.POST)
	public String postSearchCustomer(Model model, @Valid CustomerSearchForm customerSearchForm,
			BindingResult bindingResult, @ModelAttribute("customerSelectForm") CustomerSelectForm customerSelectForm) {
		
		LOGGER.info("Post Search customer is executed!");

		if (bindingResult.hasErrors()) {
			LOGGER.info("LOGGER: Search Customer ERROR");
			return ViewConstants.AGREEMENT_SELECT_CUSTOMER;
		}
		model.addAttribute("listCustomerType", iCustomerTyperService.findAll());
		model.addAttribute("listBusinessArea", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_BUSINESS_AREA));

		model.addAttribute("customerSearchForm", customerSearchForm);
		model.addAttribute("customerSelectForm", customerSelectForm);
		model.addAttribute("listRFONumber", iRFONumberService.findAll(customerSearchForm));
		return ViewConstants.AGREEMENT_SELECT_CUSTOMER;
	}

	/**
	 * Select customer function /get
	 * 
	 * @author ThanhTien
	 * @since 08-08-2015
	 */
	@RequestMapping(value = PathConstants.AGREEMENT_ADD_AGREEMENT, method = RequestMethod.GET)
	public String getSelectCustomer(Model model) {
		// logs debug message

		LOGGER.info("Get Select customer is executed!");

		model.addAttribute("listCustomerType", iCustomerTyperService.findAll());
		model.addAttribute("listBusinessArea", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_BUSINESS_AREA));

		model.addAttribute("customerSearchForm", new CustomerSearchForm());
		model.addAttribute("customerSelectForm", new CustomerSelectForm());
		model.addAttribute("listRFONumber", iRFONumberService.findAll());

		return ViewConstants.AGREEMENT_SELECT_CUSTOMER;
	}

	@RequestMapping(value = PathConstants.AGREEMENT_SELECT_CUSTOMER, method = RequestMethod.POST)
	public String postSelectCustomer(Model model, @Valid CustomerSelectForm customerSelectForm,
			BindingResult bindingResult, @ModelAttribute("customerSearchForm") CustomerSearchForm customerSearchForm,
			RedirectAttributes redirectAttrs) {

		LOGGER.info("Post Select customer is executed!");

		model.addAttribute("listCustomerType", iCustomerTyperService.findAll());
		model.addAttribute("listBusinessArea", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_BUSINESS_AREA));
		if (bindingResult.hasErrors()) {
			LOGGER.info("LOGGER: Select customer Empty ERROR");
			return ViewConstants.AGREEMENT_SELECT_CUSTOMER;
		}

		model.addAttribute("customerSearchForm", new CustomerSearchForm());
		model.addAttribute("customerSelectForm", new CustomerSelectForm());
		model.addAttribute("listRFONumber", iRFONumberService.findAll());

		redirectAttrs.addFlashAttribute("rFONumber", iRFONumberService.findOne(customerSelectForm.getCustomer()));
		return "redirect:" + PathConstants.AGREEMENT_DETAIL;
	}

}
