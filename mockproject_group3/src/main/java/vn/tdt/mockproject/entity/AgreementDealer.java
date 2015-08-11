package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the agreement_dealer database table.
 * 
 */
@Entity
@Table(name="agreement_dealer")
@NamedQuery(name="AgreementDealer.findAll", query="SELECT a FROM AgreementDealer a")
public class AgreementDealer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int agreementDealer;
	private int variantNumber;
	private Agreement agreement;
	private Dealer dealer;

	public AgreementDealer() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="agreement_dealer", unique=true, nullable=false)
	public int getAgreementDealer() {
		return this.agreementDealer;
	}

	public void setAgreementDealer(int agreementDealer) {
		this.agreementDealer = agreementDealer;
	}


	@Column(name="variant_number")
	public int getVariantNumber() {
		return this.variantNumber;
	}

	public void setVariantNumber(int variantNumber) {
		this.variantNumber = variantNumber;
	}


	//bi-directional many-to-one association to Agreement
	@ManyToOne
	@JoinColumn(name="agreement_number", nullable=false)
	public Agreement getAgreement() {
		return this.agreement;
	}

	public void setAgreement(Agreement agreement) {
		this.agreement = agreement;
	}


	//bi-directional many-to-one association to Dealer
	@ManyToOne
	@JoinColumn(name="dealer_id", nullable=false)
	public Dealer getDealer() {
		return this.dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

}