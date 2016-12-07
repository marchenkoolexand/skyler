package com.skyler.smarthome.server.uicontroller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyler.smarthome.server.data.SensorDao;
import com.skyler.smarthome.server.enums.SensorStatus;
import com.skyler.smarthome.server.model.Sensor;

@Controller
@RequestMapping("/sensor")
public class UISensorController {

	final static Logger logger = Logger.getLogger(UISensorController.class);

	@Autowired
	private SensorDao sensorDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Sensor> allSensors() {
		List<Sensor> allSensorsList = sensorDao.getAllSensors();
		return allSensorsList;
	}

	@RequestMapping(value = "/{sensorid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Sensor getSensorById(@PathVariable int sensorid) {
		if (sensorid > 0) {
			Sensor sensor = sensorDao.getSensorById(sensorid);
			return sensor;
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/newsensors", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Sensor> newSensors() {
		List<Sensor> newSensorsList = sensorDao.getSensorByStatus(SensorStatus.NEW);
		return newSensorsList;
	}

	@RequestMapping(value = "/missing", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Sensor> missingSensors() {
		List<Sensor> missingSensorsList = sensorDao.getSensorByStatus(SensorStatus.MISSING);
		return missingSensorsList;
	}

	@RequestMapping(value = "/deleted", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Sensor> deletedSensors() {
		List<Sensor> deletedSensorsList = sensorDao.getSensorByStatus(SensorStatus.DELETED);
		return deletedSensorsList;
	}

	@RequestMapping(value = "/working", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Sensor> workingSensors() {
		List<Sensor> deletedSensorsList = sensorDao.getSensorByStatus(SensorStatus.WORKING);
		return deletedSensorsList;
	}
}
