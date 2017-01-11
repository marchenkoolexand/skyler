package com.skyler.smarthome.server.controller.gwcontroller;

import com.skyler.smarthome.server.data.DeviceDao;
import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.data.ModuleDao;
import com.skyler.smarthome.server.model.Gateway;
import com.skyler.smarthome.server.model.Module;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Main internal Gateway Push controller which use to provide ability
 * register,delete,update Gateway and Modules, or change their status.
 * 
 * @see Gateway
 * @see Module
 * 
 * @author Oleksandr Marchenko
 * @version %I%, %G%
 */
@Controller
@RequestMapping("/internal")
public class GatewayInternalReceiveController {

	final static Logger logger = Logger.getLogger(GatewayInternalSendController.class);
	
	@Autowired(required=true)
	GatewayDao gatewayDAO;
	@Autowired(required=true)
	ModuleDao moduleDao;
	@Autowired(required=true)
	DeviceDao deviceDao;

	//Get Main Server Info
	@RequestMapping(value = "/info/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean serverInfo() {
		return true;
	}

	//Register new GateWay
	@RequestMapping(value = "/gateway/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean newGateway() {
		return true;
	}

	//Delete GateWay
	@RequestMapping(value = "/gateway/{gateway_id}", method = RequestMethod.DELETE)
	public void deleteGateway(@PathVariable int gateway_id) {
		if(gateway_id > 0) {
			boolean result = gatewayDAO.deleteGateway(gateway_id);
		}
	}

	//Update GateWay info
	@RequestMapping(value = "/gateway/{gateway_id}", method = RequestMethod.PATCH)
	public void updateGateway(@PathVariable int gateway_id, @RequestParam String gatewayField,
			@RequestParam String newParam) {
		if (gateway_id > 0&& gatewayField != null && newParam != null) {
			boolean result = gatewayDAO.updateGatewayByField(gateway_id, gatewayField, newParam);
		}
	}

	//Register sensor event
	@RequestMapping(value = "/gateway/{gateway_id}/sensors/{sensor_id}/sys-event/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean registerSensorEvent(@PathVariable int gateway_id, @RequestParam int sensor_id) {
		//TODO
		return true;
	}

	//Register actuator event
	@RequestMapping(value = "/gateway/{gateway_id}/actuators/{actuator_id}/sys-event/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean registerActuatorEvent(@PathVariable int gateway_id, @RequestParam int actuator_id) {
		//TODO
		return true;
	}

	//Register new sensor
	@RequestMapping(value = "/gateway/{gateway_id}/sensors/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean registerNewSensor(@PathVariable int gateway_id) {
		//moduleDao.addModuleToDevice(gateway_id,);
		return true;
	}
	//Register new actuator
	@RequestMapping(value = "/gateway/{gateway_id}/actuators/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean registerNewActuator(@PathVariable int gateway_id) {
		//TODO
		return true;
	}

	//Update sensor
	@RequestMapping(value = "/update/sensors/{sensor_id}", method = RequestMethod.PATCH)
	public @ResponseBody boolean updateSensor(@PathVariable int sensor_id) {
		//TODO
		return true;
	}

	//Update actuator
	@RequestMapping(value = "/update/actuators/{actuator_id}", method = RequestMethod.PATCH)
	public @ResponseBody boolean updateActuator(@PathVariable int sensor_id) {
		//TODO
		return true;
	}

}
