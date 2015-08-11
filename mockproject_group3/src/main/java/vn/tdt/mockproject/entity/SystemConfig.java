package vn.tdt.mockproject.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the system_config database table.
 * 
 */
@Entity
@Table(name="system_config")
@NamedQuery(name="SystemConfig.findAll", query="SELECT s FROM SystemConfig s")
public class SystemConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	private int systemConfigId;
	private String configName;
	private List<SystemConfigValue> systemConfigValues;

	public SystemConfig() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="system_config_id", unique=true, nullable=false)
	public int getSystemConfigId() {
		return this.systemConfigId;
	}

	public void setSystemConfigId(int systemConfigId) {
		this.systemConfigId = systemConfigId;
	}


	@Column(name="config_name", nullable=false, length=45)
	public String getConfigName() {
		return this.configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}


	//bi-directional many-to-one association to SystemConfigValue
	@OneToMany(mappedBy="systemConfig")
	public List<SystemConfigValue> getSystemConfigValues() {
		return this.systemConfigValues;
	}

	public void setSystemConfigValues(List<SystemConfigValue> systemConfigValues) {
		this.systemConfigValues = systemConfigValues;
	}

	public SystemConfigValue addSystemConfigValue(SystemConfigValue systemConfigValue) {
		getSystemConfigValues().add(systemConfigValue);
		systemConfigValue.setSystemConfig(this);

		return systemConfigValue;
	}

	public SystemConfigValue removeSystemConfigValue(SystemConfigValue systemConfigValue) {
		getSystemConfigValues().remove(systemConfigValue);
		systemConfigValue.setSystemConfig(null);

		return systemConfigValue;
	}

}