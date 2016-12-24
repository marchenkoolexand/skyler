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
 * Main internal Gateway GET controller which use to provide ability
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
public class GatewayInternalGetController {

	final static Logger logger = Logger.getLogger(GatewayInternalGetController.class);
	
	@Autowired(required=true)
	GatewayDao gatewayDAO;
	@Autowired(required=true)
	ModuleDao moduleDao;

	//Delete GateWay
	@RequestMapping(value = "/gateways/{gatewayid}", method = RequestMethod.DELETE)
	public void deleteGateway(@PathVariable int gatewayid) {
		boolean result = gatewayDAO.deleteGateway(gatewayid);
	}

	//Update GateWay info
	@RequestMapping(value = "/gateways/{gatewayid}", method = RequestMethod.PATCH)
	public void updateGateway(@PathVariable int gatewayid, @RequestParam String gatewayField,
			@RequestParam String newParam) {
		boolean result = gatewayDAO.updateGatewayByField(gatewayid, gatewayField, newParam);
	}

	//Register new GateWay
	@RequestMapping(value = "/gateways/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean newGateway() {
		//TODO
		return true;
	}

	//Get Sensor Events
	@RequestMapping(value = "/gateways/{gatewayid}/sensor/{sensor_id}/events/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean sensorEvent(@PathVariable int gatewayid, @RequestParam int sensor_id) {
		//TODO
		return true;
	}

	//Get Sensor Events
	@RequestMapping(value = "/gateways/{gatewayid}/actuator/{actuator_id}/events/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean actuatorEvent(@PathVariable int gatewayid, @RequestParam int actuator_id) {
		//TODO
		return true;
	}



}
