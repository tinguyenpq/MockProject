/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.common.validator.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * CustomerSelectForm.java
 * 
 * @author ThanhTien
 * @since 09-08-2015
 */
public class DealerSearchForm {

	
	private String dealerCode;
	
	private String dealerName;

	/**
	 * @return the dealerCode
	 */
	public String getDealerCode() {
		return dealerCode;
	}

	/**
	 * @param dealerCode the dealerCode to set
	 */
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	/**
	 * @return the dealerName
	 */
	public String getDealerName() {
		return dealerName;
	}

	/**
	 * @param dealerName the dealerName to set
	 */
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	
	public DealerSearchForm() {
		super();
		this.dealerCode = "";
		this.dealerName = "";
	}
	

	
	public DealerSearchForm(String dealerCode, String dealerName) {
		super();
		this.dealerCode = dealerCode;
		this.dealerName = dealerName;
	}
	



	
}
