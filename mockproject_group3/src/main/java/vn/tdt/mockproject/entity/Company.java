package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Table(name="company")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;
	private int companyId;
	private String businessArea;
	private String companyName;
	private String companyType;
	private Date createdDate;
	private String emailAddress;
	private String faxNumber;
	private String phoneNumber;
	private String sector;
	private String status;
	private Date updatedDate;
	private List<Address> addresses;
	private List<RFONumber> RFONumbers;

	public Company() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="company_id", unique=true, nullable=false)
	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}


	@Column(name="business_area", nullable=false, length=45)
	public String getBusinessArea() {
		return this.businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}


	@Column(name="company_name", nullable=false, length=45)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	@Column(name="company_type", length=45)
	public String getCompanyType() {
		return this.companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date", nullable=false)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	@Column(name="email_address", length=45)
	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	@Column(name="fax_number", length=45)
	public String getFaxNumber() {
		return this.faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}


	@Column(name="phone_number", length=45)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Column(length=45)
	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}


	@Column(length=45)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date", nullable=false)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="company")
	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setCompany(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setCompany(null);

		return address;
	}


	//bi-directional many-to-one association to RFONumber
	@OneToMany(mappedBy="company")
	public List<RFONumber> getRFONumbers() {
		return this.RFONumbers;
	}

	public void setRFONumbers(List<RFONumber> RFONumbers) {
		this.RFONumbers = RFONumbers;
	}

	public RFONumber addRFONumber(RFONumber RFONumber) {
		getRFONumbers().add(RFONumber);
		RFONumber.setCompany(this);

		return RFONumber;
	}

	public RFONumber removeRFONumber(RFONumber RFONumber) {
		getRFONumbers().remove(RFONumber);
		RFONumber.setCompany(null);

		return RFONumber;
	}

}