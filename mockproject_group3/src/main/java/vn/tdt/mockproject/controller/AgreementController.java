/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Date;

import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.ComponentColumnBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.tdt.mockproject.common.constant.PathConstants;
import vn.tdt.mockproject.common.constant.ViewConstants;
import vn.tdt.mockproject.common.validator.form.AgreementSearchForm;
import vn.tdt.mockproject.common.validator.form.CustomerSearchForm;
import vn.tdt.mockproject.common.validator.form.CustomerSelectForm;
import vn.tdt.mockproject.entity.Address;
import vn.tdt.mockproject.entity.Agreement;
import vn.tdt.mockproject.entity.AgreementStatus;
import vn.tdt.mockproject.entity.Company;
import vn.tdt.mockproject.entity.CreditNodeText;
import vn.tdt.mockproject.entity.Dealer;
import vn.tdt.mockproject.entity.Volume;
import vn.tdt.mockproject.entity.common.AgreementInfo;
import vn.tdt.mockproject.entity.common.Templates;
import vn.tdt.mockproject.service.IAddressService;
import vn.tdt.mockproject.service.IAgreementService;
import vn.tdt.mockproject.service.IAgreementStatusService;
import vn.tdt.mockproject.service.ICompanyService;
import vn.tdt.mockproject.service.ICreditNodeTextService;
import vn.tdt.mockproject.service.ICustomerTyperService;
import vn.tdt.mockproject.service.IDealerService;
import vn.tdt.mockproject.service.IRFONumberService;
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
	public String view(@RequestParam("selected") String selected, @RequestParam("backURI") String backURI,
			Model model) {

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

	@RequestMapping(value = PathConstants.AGREEMENT_SUBMIT, method = RequestMethod.POST)
	public String submit(@RequestParam("param") String param, @RequestParam("agrNumber") String agrNumberStr,
			Model model) {

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

		model.addAttribute("paramAgr", param);
		return ViewConstants.AGREEMENT_COMPLETE;
	}

	@RequestMapping(value = PathConstants.AGREEMENT_SAVE_AS_DRAFT, method = RequestMethod.POST)
	public String saveAsDraft(@RequestParam("param") String param, Model model) {

		model.addAttribute("param", param);
		return ViewConstants.AGREEMENT_COMPLETE;
	}

	@Transactional
	@RequestMapping(value = PathConstants.AGREEMENT_DOCUMENT, method = RequestMethod.POST)
	public String generateDocument(@RequestParam("param") String param, Model model) {
		
		String agrInfo[] = param.split("///");

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
		
		

		build(agrInfo[0], agr, com, address);
		return ViewConstants.AGREEMENT_DOCUMENT;
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

	private void build(String rfoNumber, Agreement agr, Company com, Address address) {
		
		StyleBuilder nameStyle = stl.style().bold();
		StyleBuilder valueStyle = stl.style()
				.setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);

		FieldBuilder<String> agrNameField = field("agrName", type.stringType());
		FieldBuilder<String> rfoNumberField = field("rfoNumber", type.stringType());
		FieldBuilder<String> cusNameField = field("cusName", type.stringType());
		FieldBuilder<String> startDateField = field("startDate", type.stringType());
		FieldBuilder<String> endDateField = field("endDate", type.stringType());
		FieldBuilder<String> businessAreaField = field("businessArea", type.stringType());
		FieldBuilder<String> agrDetailsField = field("agrDetails", type.stringType());
		FieldBuilder<String> paymenToField = field("paymenTo", type.stringType());
		FieldBuilder<String> handlingChargeField = field("handlingCharge", type.stringType());
		FieldBuilder<String> agendaPaymentField = field("agendaPayment", type.stringType());

		VerticalListBuilder nameList = cmp.verticalList(
				cmp.text("Agreement Number:").setStyle(nameStyle),
				cmp.text("RFO Number:").setStyle(nameStyle),
				cmp.text("Customer Name:").setStyle(nameStyle),
				cmp.text("Start Date:").setStyle(nameStyle),
				cmp.text("End Date:").setStyle(nameStyle),
				cmp.text("Business Area:").setStyle(nameStyle),
				cmp.text("Agreement Details:").setStyle(nameStyle),
				cmp.text("Payment To:").setStyle(nameStyle),
				cmp.text("Handling Charge:").setStyle(nameStyle),
				cmp.text("Agenda Payment:").setStyle(nameStyle));
		VerticalListBuilder valueList = cmp.verticalList(
				cmp.text(agrNameField).setStyle(valueStyle),
				cmp.text(rfoNumberField).setStyle(valueStyle),
				cmp.text(cusNameField).setStyle(valueStyle),
				cmp.text(startDateField).setStyle(valueStyle),
				cmp.text(endDateField).setStyle(valueStyle),
				cmp.text(businessAreaField).setStyle(valueStyle),
				cmp.text(agrDetailsField).setStyle(valueStyle),
				cmp.text(paymenToField).setStyle(valueStyle),
				cmp.text(handlingChargeField).setStyle(valueStyle),
				cmp.text(agendaPaymentField).setStyle(valueStyle));

		ComponentColumnBuilder nameColumn = col.componentColumn("", nameList);
		ComponentColumnBuilder valueColumn = col.componentColumn("", valueList);

//		AggregationSubtotalBuilder<BigDecimal> unitPriceSum = sbt.sum(unitPriceField, valueColumn)
//				.setLabel("Unit price sum =");

		try {
			report().setTemplate(Templates.reportTemplate).setPageFormat(PageType.A4)
					.fields(agrNameField, rfoNumberField,
							cusNameField, startDateField,
							endDateField, businessAreaField,
							agrDetailsField, paymenToField,
							handlingChargeField, agendaPaymentField)
					.columns(nameColumn, valueColumn)
					.pageFooter(Templates.footerComponent)
					.title(Templates.createTitleComponent("Group 4"))
					.setDataSource(createDataSource(rfoNumber, agr, com, address))
					.toPdf(new FileOutputStream("d:/report.pdf"));
		} catch (DRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource(String rfoNumber,
			Agreement agr, Company com, Address address) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		
		DRDataSource dataSource = new DRDataSource("agrName", "rfoNumber",
				"cusName", "startDate", "endDate", "businessArea",
				"agrDetails", "paymenTo", "handlingCharge", "agendaPayment");
		dataSource.add(agr.getAgreementName(), rfoNumber,
				com.getCompanyName(),sdf.format(agr.getStartDate()),
				sdf.format(agr.getEndDate()),
				com.getBusinessArea(), agr.getDescription(), agr.getPaymentTo(),
				"£" + agr.getHandlingCharge(), agr.getAgendaPayment());
		return dataSource;
	}

}
