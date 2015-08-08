package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the agreement_status database table.
 * 
 */
@Entity
@Table(name="agreement_status")
@NamedQuery(name="AgreementStatus.findAll", query="SELECT a FROM AgreementStatus a")
public class AgreementStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	private int agreementStatusId;
	private String agreementStatusName;
	private List<Agreement> agreements;

	public AgreementStatus() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="agreement_status_id", unique=true, nullable=false)
	public int getAgreementStatusId() {
		return this.agreementStatusId;
	}

	public void setAgreementStatusId(int agreementStatusId) {
		this.agreementStatusId = agreementStatusId;
	}


	@Column(name="agreement_status_name", nullable=false, length=45)
	public String getAgreementStatusName() {
		return this.agreementStatusName;
	}

	public void setAgreementStatusName(String agreementStatusName) {
		this.agreementStatusName = agreementStatusName;
	}


	//bi-directional many-to-one association to Agreement
	@OneToMany(mappedBy="agreementStatus")
	public List<Agreement> getAgreements() {
		return this.agreements;
	}

	public void setAgreements(List<Agreement> agreements) {
		this.agreements = agreements;
	}

	public Agreement addAgreement(Agreement agreement) {
		getAgreements().add(agreement);
		agreement.setAgreementStatus(this);

		return agreement;
	}

	public Agreement removeAgreement(Agreement agreement) {
		getAgreements().remove(agreement);
		agreement.setAgreementStatus(null);

		return agreement;
	}

}