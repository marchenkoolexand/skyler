package com.skyler.smarthome.server.controller.gwcontroller;

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
public class GatewayInternalPushController {

	final static Logger logger = Logger.getLogger(GatewayInternalPostController.class);
	
	@Autowired(required=true)
	GatewayDao gatewayDAO;
	@Autowired(required=true)
	ModuleDao moduleDao;

	//Register new GateWay
	@RequestMapping(value = "/gateways/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean newGateway() {
		//TODO
		return true;
	}

	//Delete GateWay
	@RequestMapping(value = "/gateways/{gateway_id}", method = RequestMethod.DELETE)
	public void deleteGateway(@PathVariable int gateway_id) {
		boolean result = gatewayDAO.deleteGateway(gateway_id);
	}

	//Update GateWay info
	@RequestMapping(value = "/gateways/{gateway_id}", method = RequestMethod.PATCH)
	public void updateGateway(@PathVariable int gateway_id, @RequestParam String gatewayField,
			@RequestParam String newParam) {
		boolean result = gatewayDAO.updateGatewayByField(gateway_id, gatewayField, newParam);
	}

	//Register sensor event
	@RequestMapping(value = "/gateways/{gateway_id}/sensor/{sensor_id}/events/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean registerSensorEvent(@PathVariable int gateway_id, @RequestParam int sensor_id) {
		//TODO
		return true;
	}

	//Register actuator event
	@RequestMapping(value = "/gateways/{gateway_id}/actuator/{actuator_id}/events/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean registerActuatorEvent(@PathVariable int gateway_id, @RequestParam int actuator_id) {
		//TODO
		return true;
	}

	//Register new sensor
	@RequestMapping(value = "/gateways/{gateway_id}/sensor/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean registerNewSensor(@PathVariable int gateway_id) {
		//TODO
		return true;
	}
	//Register new actuator
	@RequestMapping(value = "/gateways/{gateway_id}/actuator/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean registerNewActuator(@PathVariable int gateway_id) {
		//TODO
		return true;
	}

	//Update sensor
	@RequestMapping(value = "/update/sensor/{sensor_id}", method = RequestMethod.POST)
	public @ResponseBody boolean updateSensor(@PathVariable int sensor_id) {
		//TODO
		return true;
	}

	//Update actuator
	@RequestMapping(value = "/update/actuator/{actuator_id}", method = RequestMethod.POST)
	public @ResponseBody boolean updateActuator(@PathVariable int sensor_id) {
		//TODO
		return true;
	}

}
