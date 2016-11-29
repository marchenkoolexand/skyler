package com.skyler.smarthome.server.gwcontroller;

import org.apache.log4j.Logger;

import com.skyler.smarthome.server.model.Sensor;

public class SensorInternalPushController {

	final static Logger logger = Logger.getLogger(SensorInternalPushController.class);

	public boolean onSensor(Sensor sensor) {
		return false;

	}

	public boolean offSensor(Sensor sensor) {
		return false;

	}
}
