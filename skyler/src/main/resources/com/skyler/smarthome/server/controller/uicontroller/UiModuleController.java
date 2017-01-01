package com.skyler.smarthome.server.controller.uicontroller;

import com.skyler.smarthome.server.data.ModuleDao;
import com.skyler.smarthome.server.model.Actuator;
import com.skyler.smarthome.server.model.Module;
import com.skyler.smarthome.server.model.Sensor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/module")
public class UiModuleController {

	final static Logger logger = Logger.getLogger(UiModuleController.class);

	@Autowired(required=true)
	private ModuleDao moduleDao;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  List<Module> allModules() {
		moduleDao.getAllModules();
		return null;
	}

	@RequestMapping(value = "/sensors/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  List<Sensor> allSensors() {
		return moduleDao.getAllSensor();
	}

	@RequestMapping(value = "/actuators/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  List<Actuator> allActuators() {
		return moduleDao.getAllActuator();
	}

	@RequestMapping(value = "/sensors/{sensor_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Sensor getSensorById(@PathVariable int sensor_id) {
		if (sensor_id > 0) {
			return moduleDao.getSensorById(sensor_id);
		} else {
			return null;
		}
	}
	@RequestMapping(value = "/sensors/{actuator_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Actuator getActuatorById(@PathVariable int actuator_id) {
		if (actuator_id > 0) {
			return moduleDao.getActuatorById(actuator_id);
		} else {
			return null;
		}
	}
}
