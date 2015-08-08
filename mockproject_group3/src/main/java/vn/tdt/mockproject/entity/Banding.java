package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the banding database table.
 * 
 */
@Entity
@Table(name="banding")
@NamedQuery(name="Banding.findAll", query="SELECT b FROM Banding b")
public class Banding implements Serializable {
	private static final long serialVersionUID = 1L;
	private int bandingId;
	private int max;
	private int min;
	private Volume volume;

	public Banding() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="banding_id", unique=true, nullable=false)
	public int getBandingId() {
		return this.bandingId;
	}

	public void setBandingId(int bandingId) {
		this.bandingId = bandingId;
	}


	@Column(nullable=false)
	public int getMax() {
		return this.max;
	}

	public void setMax(int max) {
		this.max = max;
	}


	@Column(nullable=false)
	public int getMin() {
		return this.min;
	}

	public void setMin(int min) {
		this.min = min;
	}


	//bi-directional many-to-one association to Volume
	@ManyToOne
	@JoinColumn(name="volume_id", nullable=false)
	public Volume getVolume() {
		return this.volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

}