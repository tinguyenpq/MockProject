/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.common.validator.form;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import vn.tdt.mockproject.entity.AgreementRFO;
import vn.tdt.mockproject.entity.Company;
import vn.tdt.mockproject.entity.CustomerType;

/**
 * CustomerSelectForm.java
 * 
 * @author ThanhTien
 * @since 09-08-2015
 */
public class CustomerSearchForm {

	
	private String rFONumber;
	
	private String customerType;
	
	private String rFOName;
	
	private String postCode;
	
	private String businessArea;
	
	private String region;
	

	/**
	 * @return the rFONumber
	 */
	public String getrFONumber() {
		return rFONumber;
	}

	/**
	 * @param rFONumber the rFONumber to set
	 */
	public void setrFONumber(String rFONumber) {
		this.rFONumber = rFONumber;
	}

	/**
	 * @return the customerType
	 */
	public String getCustomerType() {
		return customerType;
	}

	/**
	 * @param customerType the customerType to set
	 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	/**
	 * @return the rFOName
	 */
	public String getrFOName() {
		return rFOName;
	}

	/**
	 * @param rFOName the rFOName to set
	 */
	public void setrFOName(String rFOName) {
		this.rFOName = rFOName;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return the businessArea
	 */
	public String getBusinessArea() {
		return businessArea;
	}

	/**
	 * @param businessArea the businessArea to set
	 */
	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}



	public CustomerSearchForm() {
	}

	
}
