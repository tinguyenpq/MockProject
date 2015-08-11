package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the credit_node_text database table.
 * 
 */
@Entity
@Table(name="credit_node_text")
@NamedQuery(name="CreditNodeText.findAll", query="SELECT c FROM CreditNodeText c")
public class CreditNodeText implements Serializable {
	private static final long serialVersionUID = 1L;
	private int creditNodeTextId;
	private String creditNote;
	private Date dateTime;
	private String justification;
	private int variantNumber;
	private Agreement agreement;

	public CreditNodeText() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="credit_node_text_id", unique=true, nullable=false)
	public int getCreditNodeTextId() {
		return this.creditNodeTextId;
	}

	public void setCreditNodeTextId(int creditNodeTextId) {
		this.creditNodeTextId = creditNodeTextId;
	}


	@Column(name="credit_note", length=255)
	public String getCreditNote() {
		return this.creditNote;
	}

	public void setCreditNote(String creditNote) {
		this.creditNote = creditNote;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_time", nullable=false)
	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}


	@Column(nullable=false, length=255)
	public String getJustification() {
		return this.justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
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

}