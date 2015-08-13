package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the agreements database table.
 * 
 */
@Entity
@Table(name = "agreements")
@NamedQuery(name = "Agreement.findAll", query = "SELECT a FROM Agreement a")
public class Agreement implements Serializable {
	private static final long serialVersionUID = 1L;
	private int agreementNumber;
	@Size(max = 45)
	private String agendaPayment;
	@Size(max = 45)
	@NotEmpty
	private String agreementName;
	private String authorisedBy;
	@Size(max = 45)
	private String combinability;
	private String createdBy;
	private Date createdDate;
	@Size(max = 45)
	private String dealerVisibility;
	@Size(max = 1000)
	@NotEmpty
	private String description;
	@Size(max = 45)
	private String discountUnit;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date endDate;
	@Size(max = 45)
	private String fundingMethod;
	@Min(value = 0)
	private double handlingCharge;
	private boolean isSignReceived;
	private boolean isSignRequired;
	private Date lastUpdatedDate;
	private int numberOfRegistrations;
	@Size(max = 45)
	private String paymentTo;
	private Date signReceivedDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date startDate;
	private Date updatedDate;
	private int variantNumber;
	@Size(max = 45)
	private String volumeDiscountType;
	private List<AgreementDealer> agreementDealers;
	private List<AgreementRFO> agreementRFOs;
	private AgreementStatus agreementStatus;
	private RFOUser RFOUser;
	private List<CreditNodeText> creditNodeTexts;
	private Volume volume;

	public Agreement() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "agreement_number", unique = true, nullable = false)
	public int getAgreementNumber() {
		return this.agreementNumber;
	}

	public void setAgreementNumber(int agreementNumber) {
		this.agreementNumber = agreementNumber;
	}

	@Column(name = "agenda_payment", nullable = false, length = 45)
	public String getAgendaPayment() {
		return this.agendaPayment;
	}

	public void setAgendaPayment(String agendaPayment) {
		this.agendaPayment = agendaPayment;
	}

	@Column(name = "agreement_name", nullable = false, length = 100)
	public String getAgreementName() {
		return this.agreementName;
	}

	public void setAgreementName(String agreementName) {
		this.agreementName = agreementName;
	}

	@Column(name = "authorised_by", length = 45)
	public String getAuthorisedBy() {
		return this.authorisedBy;
	}

	public void setAuthorisedBy(String authorisedBy) {
		this.authorisedBy = authorisedBy;
	}

	@Column(nullable = false, length = 45)
	public String getCombinability() {
		return this.combinability;
	}

	public void setCombinability(String combinability) {
		this.combinability = combinability;
	}

	@Column(name = "created_by", length = 45)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "dealer_visibility", nullable = false, length = 45)
	public String getDealerVisibility() {
		return this.dealerVisibility;
	}

	public void setDealerVisibility(String dealerVisibility) {
		this.dealerVisibility = dealerVisibility;
	}

	@Column(nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "discount_unit", nullable = false, length = 45)
	public String getDiscountUnit() {
		return this.discountUnit;
	}

	public void setDiscountUnit(String discountUnit) {
		this.discountUnit = discountUnit;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", nullable = false)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "funding_method", nullable = false, length = 45)
	public String getFundingMethod() {
		return this.fundingMethod;
	}

	public void setFundingMethod(String fundingMethod) {
		this.fundingMethod = fundingMethod;
	}

	@Column(name = "handling_charge", nullable = false)
	public double getHandlingCharge() {
		return this.handlingCharge;
	}

	public void setHandlingCharge(double handlingCharge) {
		this.handlingCharge = handlingCharge;
	}

	@Column(name = "is_sign_received")
	public boolean getIsSignReceived() {
		return this.isSignReceived;
	}

	public void setIsSignReceived(boolean isSignReceived) {
		this.isSignReceived = isSignReceived;
	}

	@Column(name = "is_sign_required", nullable = false)
	public boolean getIsSignRequired() {
		return this.isSignRequired;
	}

	public void setIsSignRequired(boolean isSignRequired) {
		this.isSignRequired = isSignRequired;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated_date")
	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Column(name = "number_of_registrations")
	public int getNumberOfRegistrations() {
		return this.numberOfRegistrations;
	}

	public void setNumberOfRegistrations(int numberOfRegistrations) {
		this.numberOfRegistrations = numberOfRegistrations;
	}

	@Column(name = "payment_to", nullable = false, length = 45)
	public String getPaymentTo() {
		return this.paymentTo;
	}

	public void setPaymentTo(String paymentTo) {
		this.paymentTo = paymentTo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sign_received_date")
	public Date getSignReceivedDate() {
		return this.signReceivedDate;
	}

	public void setSignReceivedDate(Date signReceivedDate) {
		this.signReceivedDate = signReceivedDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", nullable = false)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "variant_number", nullable = false)
	public int getVariantNumber() {
		return this.variantNumber;
	}

	public void setVariantNumber(int variantNumber) {
		this.variantNumber = variantNumber;
	}

	@Column(name = "volume_discount_type", nullable = false, length = 45)
	public String getVolumeDiscountType() {
		return this.volumeDiscountType;
	}

	public void setVolumeDiscountType(String volumeDiscountType) {
		this.volumeDiscountType = volumeDiscountType;
	}

	// bi-directional many-to-one association to AgreementDealer
	@OneToMany(mappedBy = "agreement")
	public List<AgreementDealer> getAgreementDealers() {
		return this.agreementDealers;
	}

	public void setAgreementDealers(List<AgreementDealer> agreementDealers) {
		this.agreementDealers = agreementDealers;
	}

	public AgreementDealer addAgreementDealer(AgreementDealer agreementDealer) {
		getAgreementDealers().add(agreementDealer);
		agreementDealer.setAgreement(this);

		return agreementDealer;
	}

	public AgreementDealer removeAgreementDealer(AgreementDealer agreementDealer) {
		getAgreementDealers().remove(agreementDealer);
		agreementDealer.setAgreement(null);

		return agreementDealer;
	}

	// bi-directional many-to-one association to AgreementRFO
	@OneToMany(mappedBy = "agreement")
	public List<AgreementRFO> getAgreementRFOs() {
		return this.agreementRFOs;
	}

	public void setAgreementRFOs(List<AgreementRFO> agreementRFOs) {
		this.agreementRFOs = agreementRFOs;
	}

	public AgreementRFO addAgreementRFO(AgreementRFO agreementRFO) {
		getAgreementRFOs().add(agreementRFO);
		agreementRFO.setAgreement(this);

		return agreementRFO;
	}

	public AgreementRFO removeAgreementRFO(AgreementRFO agreementRFO) {
		getAgreementRFOs().remove(agreementRFO);
		agreementRFO.setAgreement(null);

		return agreementRFO;
	}

	// bi-directional many-to-one association to AgreementStatus
	@ManyToOne
	@JoinColumn(name = "status_id", nullable = false)
	public AgreementStatus getAgreementStatus() {
		return this.agreementStatus;
	}

	public void setAgreementStatus(AgreementStatus agreementStatus) {
		this.agreementStatus = agreementStatus;
	}

	// bi-directional many-to-one association to RFOUser
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	public RFOUser getRFOUser() {
		return this.RFOUser;
	}

	public void setRFOUser(RFOUser RFOUser) {
		this.RFOUser = RFOUser;
	}

	// bi-directional many-to-one association to CreditNodeText
	@OneToMany(mappedBy = "agreement")
	public List<CreditNodeText> getCreditNodeTexts() {
		return this.creditNodeTexts;
	}

	public void setCreditNodeTexts(List<CreditNodeText> creditNodeTexts) {
		this.creditNodeTexts = creditNodeTexts;
	}

	public CreditNodeText addCreditNodeText(CreditNodeText creditNodeText) {
		getCreditNodeTexts().add(creditNodeText);
		creditNodeText.setAgreement(this);

		return creditNodeText;
	}

	public CreditNodeText removeCreditNodeText(CreditNodeText creditNodeText) {
		getCreditNodeTexts().remove(creditNodeText);
		creditNodeText.setAgreement(null);

		return creditNodeText;
	}

	// bi-directional one-to-one association to Volume
	@OneToOne(mappedBy = "agreement")
	public Volume getVolume() {
		return this.volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}
	
	
	
	/*@NotNull
	@Transient
	private String strEndDate;
	
	
	
	@NotNull
	@Transient
	private String strStartDate;

	*//**
	 * @return the strEndDate
	 *//*
	public String getStrEndDate() {
		return strEndDate;
	}

	*//**
	 * @param strEndDate the strEndDate to set
	 *//*
	public void setStrEndDate(String strEndDate) {
		this.strEndDate = strEndDate;
	}

	*//**
	 * @return the strStartDate
	 *//*
	public String getStrStartDate() {
		return strStartDate;
	}

	*//**
	 * @param strStartDate the strStartDate to set
	 *//*
	public void setStrStartDate(String strStartDate) {
		this.strStartDate = strStartDate;
	}
	
	
	*/
}