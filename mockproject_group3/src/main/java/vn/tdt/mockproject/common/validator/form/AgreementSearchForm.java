/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.common.validator.form;

/**
 * AgreementSearchForm.java
 * @author PhatVT
 * @since Aug 10, 2015
 */
public class AgreementSearchForm {

	private int cusTypeId;
	
	private String cusName;
	
	private String cusPostcode;
	
	private int agrStatusId;
	
	private String startDate;
	
	private String endDate;
	
	private String agrNumber;

	public int getCusTypeId() {
		return cusTypeId;
	}

	public void setCusTypeId(int cusTypeId) {
		this.cusTypeId = cusTypeId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusPostcode() {
		return cusPostcode;
	}

	public void setCusPostcode(String cusPostcode) {
		this.cusPostcode = cusPostcode;
	}

	public int getAgrStatusId() {
		return agrStatusId;
	}

	public void setAgrStatusId(int agrStatusId) {
		this.agrStatusId = agrStatusId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAgrNumber() {
		return agrNumber;
	}

	public void setAgrNumber(String agrNumber) {
		this.agrNumber = agrNumber;
	}
	
	
}
