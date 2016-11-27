package com.skyler.smarthome.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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

	@Column(name = "s_gw_id")
	private int gwId;

	@Column(name = "s_device_id")
	private int deviceId;
	
	private SensorStatus status;

	private SensorType sensorType;
	// @NotNull
	// @Column(name = "s_timestamp")
	// private long timeStamp;

	private Date creationDate;
}
