package com.skyler.smarthome.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.skyler.smarthome.server.enums.SensorStatus;
import com.skyler.smarthome.server.enums.SensorType;

@Entity
@Table(name = "s_sensors")
public class Sensor implements Serializable {

	@Transient
	private static final long serialVersionUID = 1943078891998676989L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@Column(name = "s_device_id")
	private int deviceId;

	@Column(name = "s_sensore_stat")
	@Enumerated(EnumType.STRING)
	private SensorStatus sensorStatus;

	@Column(name = "s_sensore_type")
	@Enumerated(EnumType.STRING)
	private SensorType sensorType;

	@Column(name = "s_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;

	public Sensor() {
	}

	public Sensor(int deviceId, SensorStatus sensorStatus, SensorType sensorType, Date timeStamp) {
		this.deviceId = deviceId;
		this.sensorStatus = sensorStatus;
		this.sensorType = sensorType;
		this.timeStamp = timeStamp;
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

	public SensorStatus getSensorStatus() {
		return sensorStatus;
	}

	public void setSensorStatus(SensorStatus sensorStatus) {
		this.sensorStatus = sensorStatus;
	}

	public SensorType getSensorType() {
		return sensorType;
	}

	public void setSensorType(SensorType sensorType) {
		this.sensorType = sensorType;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "Sensor [id=" + id + ", deviceId=" + deviceId + ", sensorStatus=" + sensorStatus + ", sensorType="
				+ sensorType + ", timeStamp=" + timeStamp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deviceId;
		result = prime * result + id;
		result = prime * result + ((sensorStatus == null) ? 0 : sensorStatus.hashCode());
		result = prime * result + ((sensorType == null) ? 0 : sensorType.hashCode());
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
		Sensor other = (Sensor) obj;
		if (deviceId != other.deviceId)
			return false;
		if (id != other.id)
			return false;
		if (sensorStatus != other.sensorStatus)
			return false;
		if (sensorType != other.sensorType)
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		return true;
	}

}
