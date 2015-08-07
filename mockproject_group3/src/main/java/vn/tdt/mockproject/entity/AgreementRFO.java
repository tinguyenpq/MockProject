package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the agreement_r_f_o database table.
 * 
 */
@Entity
@Table(name="agreement_r_f_o")
@NamedQuery(name="AgreementRFO.findAll", query="SELECT a FROM AgreementRFO a")
public class AgreementRFO implements Serializable {
	private static final long serialVersionUID = 1L;
	private AgreementRFOPK id;
	private int variantNumber;
	private Agreement agreement;
	private RFONumber RFONumber;

	public AgreementRFO() {
	}


	@EmbeddedId
	public AgreementRFOPK getId() {
		return this.id;
	}

	public void setId(AgreementRFOPK id) {
		this.id = id;
	}


	@Column(name="variant_number", nullable=false)
	public int getVariantNumber() {
		return this.variantNumber;
	}

	public void setVariantNumber(int variantNumber) {
		this.variantNumber = variantNumber;
	}


	//bi-directional many-to-one association to Agreement
	@ManyToOne
	@JoinColumn(name="agreement_number", nullable=false, insertable=false, updatable=false)
	public Agreement getAgreement() {
		return this.agreement;
	}

	public void setAgreement(Agreement agreement) {
		this.agreement = agreement;
	}


	//bi-directional many-to-one association to RFONumber
	@ManyToOne
	@JoinColumn(name="r_f_o_number", nullable=false, insertable=false, updatable=false)
	public RFONumber getRFONumber() {
		return this.RFONumber;
	}

	public void setRFONumber(RFONumber RFONumber) {
		this.RFONumber = RFONumber;
	}

}