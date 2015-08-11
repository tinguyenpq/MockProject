/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.entity.common;

import java.util.Date;

/**
 * AgreementInfo.java
 * 
 * @author PhatVT
 * @since Aug 9, 2015
 */
public class AgreementInfo {

	private String rFONumber;
	private String companyName;
	private String postCode;
	private Date startDate;
	private Date endDate;
	private int agreementNumber;
	private int variantNumber;
	private String agreementStatusName;

	public String getrFONumber() {
		return rFONumber;
	}

	public void setrFONumber(String rFONumber) {
		this.rFONumber = rFONumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getAgreementNumber() {
		return agreementNumber;
	}

	public void setAgreementNumber(int agreementNumber) {
		this.agreementNumber = agreementNumber;
	}

	public int getVariantNumber() {
		return variantNumber;
	}

	public void setVariantNumber(int variantNumber) {
		this.variantNumber = variantNumber;
	}

	public String getAgreementStatusName() {
		return agreementStatusName;
	}

	public void setAgreementStatusName(String agreementStatusName) {
		this.agreementStatusName = agreementStatusName;
	}

}
