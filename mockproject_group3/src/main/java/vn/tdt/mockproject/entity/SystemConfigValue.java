package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the system_config_value database table.
 * 
 */
@Entity
@Table(name="system_config_value")
@NamedQuery(name="SystemConfigValue.findAll", query="SELECT s FROM SystemConfigValue s")
public class SystemConfigValue implements Serializable {
	private static final long serialVersionUID = 1L;
	private int systemConfigValueId;
	private String configValue;
	private String order;
	private SystemConfig systemConfig;

	public SystemConfigValue() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="system_config_value_id", unique=true, nullable=false)
	public int getSystemConfigValueId() {
		return this.systemConfigValueId;
	}

	public void setSystemConfigValueId(int systemConfigValueId) {
		this.systemConfigValueId = systemConfigValueId;
	}


	@Column(name="config_value", nullable=false, length=45)
	public String getConfigValue() {
		return this.configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}


	@Column(nullable=false, length=45)
	public String getOrder() {
		return this.order;
	}

	public void setOrder(String order) {
		this.order = order;
	}


	//bi-directional many-to-one association to SystemConfig
	@ManyToOne
	@JoinColumn(name="system_config_id", nullable=false)
	public SystemConfig getSystemConfig() {
		return this.systemConfig;
	}

	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}

}