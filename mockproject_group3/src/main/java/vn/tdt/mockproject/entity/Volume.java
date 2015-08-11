package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the volume database table.
 * 
 */
@Entity
@Table(name="volume")
@NamedQuery(name="Volume.findAll", query="SELECT v FROM Volume v")
public class Volume implements Serializable {
	private static final long serialVersionUID = 1L;
	private int volumeId;
	private String paymentTo;
	private String triggerCredit;
	private int variantNumber;
	private List<Banding> bandings;
	private Agreement agreement;

	public Volume() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="volume_id", unique=true, nullable=false)
	public int getVolumeId() {
		return this.volumeId;
	}

	public void setVolumeId(int volumeId) {
		this.volumeId = volumeId;
	}


	@Column(name="payment_to", nullable=false, length=45)
	public String getPaymentTo() {
		return this.paymentTo;
	}

	public void setPaymentTo(String paymentTo) {
		this.paymentTo = paymentTo;
	}


	@Column(name="trigger_credit", nullable=false, length=45)
	public String getTriggerCredit() {
		return this.triggerCredit;
	}

	public void setTriggerCredit(String triggerCredit) {
		this.triggerCredit = triggerCredit;
	}


	@Column(name="variant_number")
	public int getVariantNumber() {
		return this.variantNumber;
	}

	public void setVariantNumber(int variantNumber) {
		this.variantNumber = variantNumber;
	}


	//bi-directional many-to-one association to Banding
	@OneToMany(mappedBy="volume")
	public List<Banding> getBandings() {
		return this.bandings;
	}

	public void setBandings(List<Banding> bandings) {
		this.bandings = bandings;
	}

	public Banding addBanding(Banding banding) {
		getBandings().add(banding);
		banding.setVolume(this);

		return banding;
	}

	public Banding removeBanding(Banding banding) {
		getBandings().remove(banding);
		banding.setVolume(null);

		return banding;
	}


	//bi-directional one-to-one association to Agreement
	@OneToOne
	@JoinColumn(name="volume_id", nullable=false, insertable=false, updatable=false)
	public Agreement getAgreement() {
		return this.agreement;
	}

	public void setAgreement(Agreement agreement) {
		this.agreement = agreement;
	}

}