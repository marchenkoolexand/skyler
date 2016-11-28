package com.skyler.smarthome.server.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "s_gateways")
public class Gateway implements Serializable {

	@Transient
	private static final long serialVersionUID = 1189530690619771645L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	@Column(name = "s_gateway_name")
	private String gwName;
	@Column(name = "s_gateway_url")
	private String gwUrl;
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "s_joined_gateway_sensors", joinColumns = @JoinColumn(name = "s_gateway_fk"), inverseJoinColumns = @JoinColumn(name = "s_sensor_fk"))
	private List<Sensor> sensorList;

	public Gateway() {
	}

	public Gateway(String gwName, String gwUrl, List<Sensor> sensorList) {
		this.gwName = gwName;
		this.gwUrl = gwUrl;
		this.sensorList = sensorList;
	}

	public String getGwName() {
		return gwName;
	}

	public void setGwName(String gwName) {
		this.gwName = gwName;
	}

	public String getGwUrl() {
		return gwUrl;
	}

	public void setGwUrl(String gwUrl) {
		this.gwUrl = gwUrl;
	}

	public List<Sensor> getSensorList() {
		return sensorList;
	}

	public void setSensorList(List<Sensor> sensorList) {
		this.sensorList = sensorList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gwName == null) ? 0 : gwName.hashCode());
		result = prime * result + ((gwUrl == null) ? 0 : gwUrl.hashCode());
		result = prime * result + id;
		result = prime * result + ((sensorList == null) ? 0 : sensorList.hashCode());
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
		Gateway other = (Gateway) obj;
		if (gwName == null) {
			if (other.gwName != null)
				return false;
		} else if (!gwName.equals(other.gwName))
			return false;
		if (gwUrl == null) {
			if (other.gwUrl != null)
				return false;
		} else if (!gwUrl.equals(other.gwUrl))
			return false;
		if (id != other.id)
			return false;
		if (sensorList == null) {
			if (other.sensorList != null)
				return false;
		} else if (!sensorList.equals(other.sensorList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gateway [id=" + id + ", gwName=" + gwName + ", gwUrl=" + gwUrl + ", sensorList=" + sensorList + "]";
	}

}
