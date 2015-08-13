/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.entity.common;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.ComponentColumnBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import vn.tdt.mockproject.entity.Address;
import vn.tdt.mockproject.entity.Agreement;
import vn.tdt.mockproject.entity.Company;

/**
 * PrintCommon.java
 * @author PhatVT
 * @since Aug 12, 2015
 */
public class PrintCommon {
	
	/**create source for print component
	 * @author PhatVT
	 * @param JRDataSource
	 */
	public static JRDataSource createDataSource(String rfoNumber,
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
	
	/**
	 * @author PhatVT
	 * @param void
	 */
	public static void build(String rfoNumber, Agreement agr, Company com, Address address) {
		
		Random random = new Random();
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
					.toPdf(new FileOutputStream("d:/report" + random.nextInt(10000) + ".pdf"));
		} catch (DRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
