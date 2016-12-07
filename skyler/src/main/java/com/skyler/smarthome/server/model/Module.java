package com.skyler.smarthome.server.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.skyler.smarthome.server.enums.ModuleAction;
import com.skyler.smarthome.server.enums.ModuleStatus;
import com.skyler.smarthome.server.enums.ModuleType;

@Entity
@Table(name = "s_modules")
public class Module implements Serializable {

	@Transient
	private static final long serialVersionUID = 1943078891998676989L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@Column(name = "s_device_id")
	private int deviceId;

	@Column(name = "s_module_stat")
	@Enumerated(EnumType.STRING)
	private ModuleStatus moduleStatus;

	@Column(name = "s_module_type")
	@Enumerated(EnumType.STRING)
	private ModuleType moduleType;

	@ElementCollection(targetClass = ModuleAction.class, fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	@JoinTable(name = "s_module_suported_actions", joinColumns = @JoinColumn(name = "s_module_id"))
	@Column(name = "s_suported_action")
	private Set<ModuleAction> suportedActions;

	@Column(name = "s_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;

	public Module() {
	}

	public Module(int deviceId, ModuleStatus moduleStatus, ModuleType moduleType) {
		this.deviceId = deviceId;
		this.moduleStatus = moduleStatus;
		this.moduleType = moduleType;
	}
	
	public Module(int deviceId, ModuleStatus moduleStatus, ModuleType moduleType, Set<ModuleAction> suportedActions) {
		this.deviceId = deviceId;
		this.moduleStatus = moduleStatus;
		this.moduleType = moduleType;
		this.suportedActions = suportedActions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public ModuleStatus getModuleStatus() {
		return moduleStatus;
	}

	public void setModuleStatus(ModuleStatus moduleStatus) {
		this.moduleStatus = moduleStatus;
	}

	public Set<ModuleAction> getSuportedActions() {
		return suportedActions;
	}

	public void setSuportedActions(Set<ModuleAction> suportedActions) {
		this.suportedActions = suportedActions;
	}

	public ModuleType getModuleType() {
		return moduleType;
	}

	public void setModuleType(ModuleType moduleType) {
		this.moduleType = moduleType;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", deviceId=" + deviceId + ", moduleStatus=" + moduleType + ", moduleType="
				+ moduleType + ", suportedActions=" + suportedActions + ", timeStamp=" + timeStamp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deviceId;
		result = prime * result + id;
		result = prime * result + ((moduleStatus == null) ? 0 : moduleStatus.hashCode());
		result = prime * result + ((moduleType == null) ? 0 : moduleType.hashCode());
		result = prime * result + ((suportedActions == null) ? 0 : suportedActions.hashCode());
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (deviceId != other.deviceId)
			return false;
		if (id != other.id)
			return false;
		if (moduleStatus != other.moduleStatus)
			return false;
		if (moduleType != other.moduleType)
			return false;
		if (suportedActions == null) {
			if (other.suportedActions != null)
				return false;
		} else if (!suportedActions.equals(other.suportedActions))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		return true;
	}
}
