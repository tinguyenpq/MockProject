package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the r_f_o_number database table.
 * 
 */
@Entity
@Table(name="r_f_o_number")
@NamedQuery(name="RFONumber.findAll", query="SELECT r FROM RFONumber r")
public class RFONumber implements Serializable {
	private static final long serialVersionUID = 1L;
	private String rFONumber;
	private Date createdDate;
	private String rFOName;
	private Date updatedDate;
	private List<AgreementRFO> agreementRFOs;
	private Company company;
	private CustomerType customerType;

	public RFONumber() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="r_f_o_number", unique=true, nullable=false, length=45)
	public String getRFONumber() {
		return this.rFONumber;
	}

	public void setRFONumber(String rFONumber) {
		this.rFONumber = rFONumber;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date", nullable=false)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	@Column(name="r_f_o_name", nullable=false, length=45)
	public String getRFOName() {
		return this.rFOName;
	}

	public void setRFOName(String rFOName) {
		this.rFOName = rFOName;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date", nullable=false)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	//bi-directional many-to-one association to AgreementRFO
	@OneToMany(mappedBy="RFONumber")
	public List<AgreementRFO> getAgreementRFOs() {
		return this.agreementRFOs;
	}

	public void setAgreementRFOs(List<AgreementRFO> agreementRFOs) {
		this.agreementRFOs = agreementRFOs;
	}

	public AgreementRFO addAgreementRFO(AgreementRFO agreementRFO) {
		getAgreementRFOs().add(agreementRFO);
		agreementRFO.setRFONumber(this);

		return agreementRFO;
	}

	public AgreementRFO removeAgreementRFO(AgreementRFO agreementRFO) {
		getAgreementRFOs().remove(agreementRFO);
		agreementRFO.setRFONumber(null);

		return agreementRFO;
	}


	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="company_id", nullable=false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


	//bi-directional many-to-one association to CustomerType
	@ManyToOne
	@JoinColumn(name="customer_type_id", nullable=false)
	public CustomerType getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

}