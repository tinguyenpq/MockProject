package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the agreement_r_f_o database table.
 * 
 */
@Embeddable
public class AgreementRFOPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String rFONumber;
	private int agreementNumber;

	public AgreementRFOPK() {
	}

	@Column(name="r_f_o_number", insertable=false, updatable=false, unique=true, nullable=false, length=45)
	public String getRFONumber() {
		return this.rFONumber;
	}
	public void setRFONumber(String rFONumber) {
		this.rFONumber = rFONumber;
	}

	@Column(name="agreement_number", insertable=false, updatable=false, unique=true, nullable=false)
	public int getAgreementNumber() {
		return this.agreementNumber;
	}
	public void setAgreementNumber(int agreementNumber) {
		this.agreementNumber = agreementNumber;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AgreementRFOPK)) {
			return false;
		}
		AgreementRFOPK castOther = (AgreementRFOPK)other;
		return 
			this.rFONumber.equals(castOther.rFONumber)
			&& (this.agreementNumber == castOther.agreementNumber);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.rFONumber.hashCode();
		hash = hash * prime + this.agreementNumber;
		
		return hash;
	}
}