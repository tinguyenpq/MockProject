package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customer_type database table.
 * 
 */
@Entity
@Table(name="customer_type")
@NamedQuery(name="CustomerType.findAll", query="SELECT c FROM CustomerType c")
public class CustomerType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int customerTypeId;
	private String customerTypeName;
	private List<RFONumber> RFONumbers;

	public CustomerType() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_type_id", unique=true, nullable=false)
	public int getCustomerTypeId() {
		return this.customerTypeId;
	}

	public void setCustomerTypeId(int customerTypeId) {
		this.customerTypeId = customerTypeId;
	}


	@Column(name="customer_type_name", nullable=false, length=45)
	public String getCustomerTypeName() {
		return this.customerTypeName;
	}

	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}


	//bi-directional many-to-one association to RFONumber
	@OneToMany(mappedBy="customerType")
	public List<RFONumber> getRFONumbers() {
		return this.RFONumbers;
	}

	public void setRFONumbers(List<RFONumber> RFONumbers) {
		this.RFONumbers = RFONumbers;
	}

	public RFONumber addRFONumber(RFONumber RFONumber) {
		getRFONumbers().add(RFONumber);
		RFONumber.setCustomerType(this);

		return RFONumber;
	}

	public RFONumber removeRFONumber(RFONumber RFONumber) {
		getRFONumbers().remove(RFONumber);
		RFONumber.setCustomerType(null);

		return RFONumber;
	}

}