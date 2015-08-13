/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.tdt.mockproject.common.constant.PathConstants;
import vn.tdt.mockproject.common.constant.ViewConstants;
import vn.tdt.mockproject.common.validator.form.AgreementSearchForm;
import vn.tdt.mockproject.common.validator.form.CustomerSearchForm;
import vn.tdt.mockproject.common.validator.form.CustomerSelectForm;
import vn.tdt.mockproject.common.validator.form.DealerSearchForm;
import vn.tdt.mockproject.entity.Address;
import vn.tdt.mockproject.entity.Agreement;
import vn.tdt.mockproject.entity.AgreementRFO;
import vn.tdt.mockproject.entity.AgreementStatus;
import vn.tdt.mockproject.entity.Company;
import vn.tdt.mockproject.entity.CreditNodeText;
import vn.tdt.mockproject.entity.Dealer;
import vn.tdt.mockproject.entity.RFONumber;
import vn.tdt.mockproject.entity.RFOUser;
import vn.tdt.mockproject.entity.Volume;
import vn.tdt.mockproject.entity.common.AgreementInfo;
import vn.tdt.mockproject.entity.common.PrintCommon;
import vn.tdt.mockproject.entity.common.Templates;
import vn.tdt.mockproject.service.IAddressService;
import vn.tdt.mockproject.service.IAgreementService;
import vn.tdt.mockproject.service.IAgreementStatusService;
import vn.tdt.mockproject.service.ICompanyService;
import vn.tdt.mockproject.service.ICreditNodeTextService;
import vn.tdt.mockproject.service.ICustomerTyperService;
import vn.tdt.mockproject.service.IDealerService;
import vn.tdt.mockproject.service.IRFONumberService;
import vn.tdt.mockproject.service.IRFOUserService;
import vn.tdt.mockproject.service.ISystemConfigValueService;
import vn.tdt.mockproject.service.IVolumeService;

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
	private IRFOUserService iRFOUserService;

	@Autowired
	private IAgreementService iAgreementService;

	@Autowired
	private IRFONumberService iRFONumberService;

	@Autowired
	private ICustomerTyperService iCustomerTyperService;

	@Autowired
	private IAgreementStatusService iAgreementStatusService;

	@Autowired
	private ICreditNodeTextService iCreditNodeTextService;

	@Autowired
	private IDealerService iDealerSerivce;

	@Autowired
	private IVolumeService iVolumeService;

	@Autowired
	private ICompanyService iCompanyService;

	@Autowired
	private IAddressService iAddressService;

	@Autowired
	private ISystemConfigValueService iSystemValueService;

	/**
	 * Search dealer function /post
	 * 
	 * @author ThanhTien
	 * @since 10-08-2015
	 */
	@RequestMapping(value = PathConstants.AGREEMENT_SEARCH_DEALER, method = RequestMethod.POST)
	public String postSearchDealer(Model model, @ModelAttribute("agreement") Agreement agreement,
			@Valid DealerSearchForm dealerSearchForm, BindingResult bindingResult) {

		LOGGER.info("Post Search dealer is executed!");

		if (bindingResult.hasErrors()) {
			LOGGER.info("LOGGER: Search dealer ERROR");
			return ViewConstants.AGREEMENT_SELECT_DEALER;
		}
		model.addAttribute("dealerSearchForm", dealerSearchForm);
		model.addAttribute("agreement", agreement);
		model.addAttribute("listDealers", iDealerSerivce.findAll(dealerSearchForm));
		return ViewConstants.AGREEMENT_SELECT_DEALER;
	}

	/**
	 * add agreement function /post
	 * 
	 * @author ThanhTien
	 * @since 10-08-2015
	 */
	@RequestMapping(value = PathConstants.AGREEMENT_SELECT_DEALER, method = RequestMethod.GET)
	public String getSelectDealer(Model model, @ModelAttribute("agreement") Agreement agreement) {
		// logs debug message
		LOGGER.info("Get select dealer is executed!");

		model.addAttribute("dealerSearchForm", new DealerSearchForm());
		model.addAttribute("agreement", agreement);
		model.addAttribute("listDealers", iDealerSerivce.findAll());
		return ViewConstants.AGREEMENT_SELECT_DEALER;
	}

	/**
	 * add agreement function /post
	 * 
	 * @author ThanhTien
	 * @since 10-08-2015
	 */
	@RequestMapping(value = PathConstants.AGREEMENT_DETAIL, method = RequestMethod.GET)
	public String getAgreementDetail(Model model, @ModelAttribute("rFONumber") RFONumber rFONumber) {
		// logs debug message
		LOGGER.info("Get agreement detail is executed!");

		model.addAttribute("rFONumber", rFONumber);

		Agreement agreement = new Agreement();
		model.addAttribute("agreement", agreement);

		model.addAttribute("listFundingMethod", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_FUNDING_TYPE));
		model.addAttribute("listPaymentTo", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_PAYMENT_TO));
		model.addAttribute("listAgendaPayment", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_ORDER_TYPE));

		model.addAttribute("listDealerVisibility", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_DEALER_VISIBILITY));
		model.addAttribute("listVolumeDiscountType", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_VOLUME_DISCOUNT_TYPE));
		model.addAttribute("listDiscountUnit", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_DISCOUNT_UNIT));
		model.addAttribute("listCombinability", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_COMBINABILITY));

		return ViewConstants.AGREEMENT_DETAIL;
	}

	/**
	 * add agreement function /post
	 * 
	 * @author ThanhTien
	 * @since 10-08-2015
	 */
	@RequestMapping(value = PathConstants.AGREEMENT_DETAIL, method = RequestMethod.POST)
	public String postAddAgreementDetail(Model model, @Valid Agreement agreement, BindingResult bindingResult,
			@ModelAttribute RFONumber rFONumber, HttpServletRequest request, RedirectAttributes redirectAttrs) {

		request.getSession().setAttribute("rFONumber", rFONumber);
		// logs debug message
		LOGGER.info("Post agreement detail is executed!");
		if (!bindingResult.hasErrors()) {
			LOGGER.info("No error agreement detail is executed!");
			redirectAttrs.addFlashAttribute("rFONumber", rFONumber);
			redirectAttrs.addFlashAttribute("agreement", agreement);
			return "redirect:" + PathConstants.AGREEMENT_SELECT_DEALER;
		}

		model.addAttribute("rFONumber", rFONumber);
		model.addAttribute("listFundingMethod", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_FUNDING_TYPE));
		model.addAttribute("listPaymentTo", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_PAYMENT_TO));
		model.addAttribute("listAgendaPayment", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_ORDER_TYPE));

		model.addAttribute("listDealerVisibility", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_DEALER_VISIBILITY));
		model.addAttribute("listVolumeDiscountType", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_VOLUME_DISCOUNT_TYPE));
		model.addAttribute("listDiscountUnit", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_DISCOUNT_UNIT));
		model.addAttribute("listCombinability", iSystemValueService
				.findAll(vn.tdt.mockproject.common.constant.ValueConstants.SYSTEM_CONFIG_COMBINABILITY));
		/*if ("".equals(agreement.getStrStartDate()) || "".equals(agreement.getStrEndDate())) {
			LOGGER.info("LOGGER: ADD Agreement ERROR");
			model.addAttribute("error", "Error. Please complete exact start date and end date.");
			return ViewConstants.AGREEMENT_DETAIL;
		}*/
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
			//agreement.setStartDate(format.parse(agreement.getStrStartDate()));
			//agreement.setEndDate(format.parse(agreement.getStrEndDate()));
			
			agreement.setStartDate(format.parse(agreement.getStartDate().toString()));
			agreement.setEndDate(format.parse(agreement.getEndDate().toString()));
			
			if (agreement.getStartDate().after(agreement.getEndDate())) {
				LOGGER.info("Start date is after end Date");
				model.addAttribute("error", "Error. Start date is after end Date.");
				return ViewConstants.AGREEMENT_DETAIL;
			}
			LOGGER.info("LOGGER: Format DayInCage success " + agreement.getStartDate().toString());
			LOGGER.info("LOGGER: Format DayInCage success " + agreement.getEndDate().toString());
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.info("LOGGER: Format DayInCage ERROR " + agreement.getStartDate().toString());
			LOGGER.info("LOGGER: Format DayInCage ERROR " + agreement.getEndDate().toString());
		}

		return ViewConstants.AGREEMENT_DETAIL;
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
	public String search(@ModelAttribute("agrSearchForm") AgreementSearchForm agrSearchForm, Model model) {

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

		List<AgreementInfo> lst = iAgreementService.findAll(cusTypeIdInt, cusName, cusPostcode, agrStatusIdInt, start,
				end, agrNumberInt);

		if (lst == null || lst.size() == 0) {
			model.addAttribute("message", "Result does not exist.");
		}

		model.addAttribute("agreementList", lst);
		model.addAttribute("cusTypes", iCustomerTyperService.findAll());
		model.addAttribute("agrStatuses", iAgreementStatusService.findAll());

		return ViewConstants.AGREEMENT_SEARCH;
	}

	/**
	 * view an agreement function
	 * 
	 * @author PhatVT
	 * @param String
	 */
	@Transactional
	@RequestMapping(value = PathConstants.AGREEMENT_VIEW, method = RequestMethod.POST)
	public String view(@RequestParam(value = "selected", defaultValue = "") String selected,
			@RequestParam(value = "backURI", defaultValue = "") String backURI,
			HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		
		if ("".equals(selected) || selected == null) {
			selected = (String) session.getAttribute("param");
		} else {
			session.setAttribute("param", selected);
		}

		String agrInfo[] = selected.split("///");

		if (agrInfo.length != 5) {
			model.addAttribute("message", "Agreement does not exist.");
			return ViewConstants.AGREEMENT_VIEW;
		}

		int agrNumber = Integer.parseInt(agrInfo[3]);
		int volumeId = 0;
		Volume vol = null;

		CreditNodeText creNoteText = iCreditNodeTextService.findOneLatest(agrNumber);
		List<Dealer> dealerList = iDealerSerivce.findAllByAgreementId(agrNumber);
		Agreement agr = iAgreementService.findOne(agrNumber);

		try {
			volumeId = agr.getVolume().getVolumeId();
		} catch (Exception e) {

		}

		if (volumeId != 0) {
			vol = iVolumeService.findOne(volumeId);
			Hibernate.initialize(vol.getBandings());
		}

		Company com = iCompanyService.findOne(Integer.parseInt(agrInfo[1]));
		Address address = iAddressService.findOne(Integer.parseInt(agrInfo[2]));

		model.addAttribute("agr", agr);
		model.addAttribute("creNoteText", creNoteText);
		model.addAttribute("dealerList", dealerList);
		model.addAttribute("com", com);
		model.addAttribute("address", address);
		model.addAttribute("vol", vol);
		model.addAttribute("bandings", vol.getBandings());
		model.addAttribute("rfonumber", agrInfo[0]);
		model.addAttribute("backURI", backURI);
		model.addAttribute("paramAgr", selected);

		return ViewConstants.AGREEMENT_VIEW;
	}

	/**
	 * @author PhatVT
	 * @param String
	 */

	@RequestMapping(value = PathConstants.AGREEMENT_SUBMIT, method = RequestMethod.POST)
	public String submit(@RequestParam("agrNumber") String agrNumberStr) {

		int agrNumberInt = 0;

		if (!"".equals(agrNumberStr) && agrNumberStr != null) {
			try {
				agrNumberInt = Integer.parseInt(agrNumberStr);
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}

		Agreement agreement = iAgreementService.findOne(agrNumberInt);

		if (agreement != null) {
			AgreementStatus agrStatus = iAgreementStatusService.findOne(2);
			agreement.setAgreementStatus(agrStatus);
			agreement.setLastUpdatedDate(new Date());
			iAgreementService.update(agreement);
		}

		return ViewConstants.AGREEMENT_COMPLETE;
	}

	@RequestMapping(value = PathConstants.AGREEMENT_SAVE_AS_DRAFT, method = RequestMethod.POST)
	public String saveAsDraft(@RequestParam("param") String param, Model model) {

		model.addAttribute("param", param);
		return ViewConstants.AGREEMENT_COMPLETE;
	}

	/**
	 * 
	 * @author PhatVT
	 * @param String
	 */
	@Transactional
	@RequestMapping(value = PathConstants.AGREEMENT_DOCUMENT, method = RequestMethod.POST)
	public String viewDocument(HttpServletRequest request, Model model) {

		// get session
		HttpSession session = request.getSession();

		String param = (String) session.getAttribute("param");

		String agrInfo[] = param.split("///");

		if (agrInfo.length != 5) {
			model.addAttribute("message", "Agreement does not exist.");
			return ViewConstants.AGREEMENT_VIEW;
		}

		int agrNumber = Integer.parseInt(agrInfo[3]);

		Agreement agr = iAgreementService.findOne(agrNumber);

		Company com = iCompanyService.findOne(Integer.parseInt(agrInfo[1]));

		model.addAttribute("agr", agr);
		model.addAttribute("com", com);
		model.addAttribute("rfonumber", agrInfo[0]);
		// model.addAttribute("paramAgr", param);

		// PrintCommon.build(agrInfo[0], agr, com, address);
		return ViewConstants.AGREEMENT_DOCUMENT;
	}

	/**
	 * @author PhatVT
	 * @param String
	 * 
	 */
	@Transactional
	@RequestMapping(value = PathConstants.AGREEMENT_GENERATE_DOCUMENT, method = RequestMethod.POST)
	public String generateDocument(HttpServletRequest request, Model model) {

		// get session
		HttpSession session = request.getSession();

		String param = (String) session.getAttribute("param");

		String agrInfo[] = param.split("///");

		if (agrInfo.length != 5) {
			model.addAttribute("message", "Agreement does not exist.");
			return ViewConstants.AGREEMENT_VIEW;
		}

		int agrNumber = Integer.parseInt(agrInfo[3]);

		Agreement agr = iAgreementService.findOne(agrNumber);

		Company com = iCompanyService.findOne(Integer.parseInt(agrInfo[1]));
		Address address = iAddressService.findOne(Integer.parseInt(agrInfo[2]));

		PrintCommon.build(agrInfo[0], agr, com, address);

		return ViewConstants.AGREEMENT_DOCUMENT_SUCCESS;
	}

	/**
	 * @author Trung
	 * @param String
	 * @since
	 */
	@RequestMapping(value = PathConstants.AGREEMENT_APPROVE, method = RequestMethod.POST)
	public String approveAgreement(@RequestParam("agrNumber") String agrNumberStr) {

		int agrNumberInt = 0;

		if (!"".equals(agrNumberStr) && agrNumberStr != null) {
			try {
				agrNumberInt = Integer.parseInt(agrNumberStr);
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}

		Agreement agreement = iAgreementService.findOne(agrNumberInt);

		if (agreement != null) {
			AgreementStatus agrStatus = iAgreementStatusService.findOne(4);
			agreement.setAgreementStatus(agrStatus);
			agreement.setLastUpdatedDate(new Date());
			iAgreementService.update(agreement);
		}

		return ViewConstants.AGREEMENT_COMPLETE;
	}

	/**
	 * @author Trung
	 * @param String
	 */
	@RequestMapping(value = PathConstants.AGREEMENT_TERMINATE, method = RequestMethod.POST)
	public String terminateAgreement(@RequestParam("agrNumber") String agrNumberStr) {

		int agrNumberInt = 0;

		if (!"".equals(agrNumberStr) && agrNumberStr != null) {
			try {
				agrNumberInt = Integer.parseInt(agrNumberStr);
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}

		Agreement agreement = iAgreementService.findOne(agrNumberInt);

		if (agreement != null) {
			AgreementStatus agrStatus = iAgreementStatusService.findOne(6);
			agreement.setAgreementStatus(agrStatus);
			agreement.setLastUpdatedDate(new Date());
			iAgreementService.update(agreement);
		}

		return ViewConstants.AGREEMENT_COMPLETE;
	}

	/**
	 * @author PhatVT
	 * @param String
	 */
	@RequestMapping(value = PathConstants.AGREEMENT_REJECT, method = RequestMethod.GET)
	public String rejectAgreement(HttpServletRequest request, Model model) {

		// get session
		HttpSession session = request.getSession();

		String param = (String) session.getAttribute("param");

		String agrInfo[] = param.split("///");

		if (agrInfo.length != 5) {
			model.addAttribute("message", "Agreement does not exist.");
			return ViewConstants.AGREEMENT_VIEW;
		}

		int agrNumber = Integer.parseInt(agrInfo[3]);

		Agreement agr = iAgreementService.findOne(agrNumber);

		Company com = iCompanyService.findOne(Integer.parseInt(agrInfo[1]));

		model.addAttribute("agr", agr);
		model.addAttribute("com", com);
		model.addAttribute("rfonumber", agrInfo[0]);

		return ViewConstants.AGREEMENT_REJECT;
	}
	
	/**
	 * @author Trung
	 * @param String
	 */
	@RequestMapping(value = PathConstants.AGREEMENT_REJECT, method = RequestMethod.POST)
	public String rejectAgreement(@RequestParam("agrNumber") String agrNumberStr) {

		int agrNumberInt = 0;

		if (!"".equals(agrNumberStr) && agrNumberStr != null) {
			try {
				agrNumberInt = Integer.parseInt(agrNumberStr);
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}

		Agreement agreement = iAgreementService.findOne(agrNumberInt);

		if (agreement != null) {
			AgreementStatus agrStatus = iAgreementStatusService.findOne(5);
			agreement.setAgreementStatus(agrStatus);
			agreement.setLastUpdatedDate(new Date());
			iAgreementService.update(agreement);
		}

		return ViewConstants.AGREEMENT_COMPLETE;
	}

	/**
	 * @ @author PhatVT
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
