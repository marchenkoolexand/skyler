package com.skyler.smarthome.server.uicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skyler.smarthome.server.data.SensorDao;
import com.skyler.smarthome.server.enums.SensorStatus;
import com.skyler.smarthome.server.model.Sensor;

@Controller
@RequestMapping("/sensor")
public class UISensorController {

	@Autowired
	private SensorDao sensorDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<Sensor> allSensors() {
		List<Sensor> allSensorsList = sensorDao.getAllSensors();
		return allSensorsList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Sensor getSensorById(@PathVariable int id) {
		Sensor sensor = sensorDao.getSensorById(id);
		return sensor;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET, produces = "application/json")
	public List<Sensor> newSensors() {
		List<Sensor> newSensorsList = sensorDao.getSensorByStatus(SensorStatus.NEW);
		return newSensorsList;
	}

	@RequestMapping(value = "/missing", method = RequestMethod.GET, produces = "application/json")
	public List<Sensor> missingSensors() {
		List<Sensor> missingSensorsList = sensorDao.getSensorByStatus(SensorStatus.MISSING);
		return missingSensorsList;
	}

	@RequestMapping(value = "/deleted", method = RequestMethod.GET, produces = "application/json")
	public List<Sensor> deletedSensors() {
		List<Sensor> deletedSensorsList = sensorDao.getSensorByStatus(SensorStatus.DELETED);
		return deletedSensorsList;
	}

}
