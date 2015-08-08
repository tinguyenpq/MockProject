package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dealer database table.
 * 
 */
@Entity
@Table(name="dealer")
@NamedQuery(name="Dealer.findAll", query="SELECT d FROM Dealer d")
public class Dealer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int dealerId;
	private String country;
	private String dealerCode;
	private String dealerName;
	private String town;
	private List<AgreementDealer> agreementDealers;

	public Dealer() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="dealer_id", unique=true, nullable=false)
	public int getDealerId() {
		return this.dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}


	@Column(nullable=false, length=45)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Column(name="dealer_code", nullable=false, length=45)
	public String getDealerCode() {
		return this.dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}


	@Column(name="dealer_name", nullable=false, length=45)
	public String getDealerName() {
		return this.dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}


	@Column(nullable=false, length=45)
	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}


	//bi-directional many-to-one association to AgreementDealer
	@OneToMany(mappedBy="dealer")
	public List<AgreementDealer> getAgreementDealers() {
		return this.agreementDealers;
	}

	public void setAgreementDealers(List<AgreementDealer> agreementDealers) {
		this.agreementDealers = agreementDealers;
	}

	public AgreementDealer addAgreementDealer(AgreementDealer agreementDealer) {
		getAgreementDealers().add(agreementDealer);
		agreementDealer.setDealer(this);

		return agreementDealer;
	}

	public AgreementDealer removeAgreementDealer(AgreementDealer agreementDealer) {
		getAgreementDealers().remove(agreementDealer);
		agreementDealer.setDealer(null);

		return agreementDealer;
	}

}