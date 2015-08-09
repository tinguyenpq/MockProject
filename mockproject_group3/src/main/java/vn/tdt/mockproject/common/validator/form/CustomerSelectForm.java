/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.common.validator.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * CustomerSelectForm.java
 * 
 * @author ThanhTien
 * @since 09-08-2015
 */
public class CustomerSelectForm {

	/**
	 * Select customer
	 */
	@Size(min = 1, max = 254, message = "{customer.rfonumber.size}")
	@NotEmpty(message = "{customer.rfonumber.empty}")
	private String customer;

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	/**
	 * 
	 */
	public CustomerSelectForm() {
		// TODO Auto-generated constructor stub
	}

}
