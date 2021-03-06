package com.skyler.smarthome.server.controller.gwcontroller;

import com.skyler.smarthome.server.core.CoreSystemHandler;
import com.skyler.smarthome.server.model.Gateway;
import com.skyler.smarthome.server.model.Module;
import com.skyler.smarthome.server.model.gateway.GatewayInfo;
import com.skyler.smarthome.server.model.gateway.MainServerInfo;
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

    @Autowired
	CoreSystemHandler coreSystemHandler;


	//Get Main Server Info
	@RequestMapping(value = "/info/", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody MainServerInfo serverInfo()
	{
		MainServerInfo mainServerInfo = new MainServerInfo();
        //TODO
		mainServerInfo.setId(1);
		mainServerInfo.setProtocolVersionMajor("1212");

        return mainServerInfo;
	}

    //Register new Gateway (or initialize after system restart)
	@RequestMapping(value = "/gateways/{unique_gateway_id}", method = RequestMethod.POST)
	public void newGateway(@PathVariable int unique_gateway_id,@RequestBody GatewayInfo gatewayInfo) {
		if(unique_gateway_id > 0) {

		}
	}

	//Delete GateWay
	@RequestMapping(value = "/gateways/{unique_gateway_id}", method = RequestMethod.DELETE)
	public void deleteGateway(@PathVariable int unique_gateway_id) {
		if(unique_gateway_id > 0) {
			//TODO
		}
	}

	//Update GateWay info
	@RequestMapping(value = "/gateways/{unique_gateway_id}", method = RequestMethod.PATCH)
	public void updateGateway(@PathVariable int unique_gateway_id, @RequestParam String gatewayField,
			@RequestParam String newParam) {
		if (unique_gateway_id > 0&& gatewayField != null && newParam != null) {
			//TODO
		}
	}

	//Register system event happened with some of the Sensors (new added, communication lost, missing, poor communication, etc)
	@RequestMapping(value = "/gateways/{unique_gateway_id}/sensors/sys-event/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean registerSensorSystemEvent(@PathVariable int unique_gateway_id) {
		//TODO
		return true;
	}

	//Register event happened on Sensor
	@RequestMapping(value = "/gateways/{unique_gateway_id}/sensors/{sensor_id}/event/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean registerSensorEvent(@PathVariable int unique_gateway_id, @RequestParam int sensor_id) {
		//TODO
		return true;
	}

	//Register system event happened with some of the Actuators (new added, communication lost, missing, poor communication, etc)
	@RequestMapping(value = "/gateways/{unique_gateway_id}/actuators/sys-event/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean registerActuatorSystemEvent(@PathVariable int unique_gateway_id) {
		//TODO
		return true;
	}

	//Register new sensor
	@RequestMapping(value = "/gateways/{unique_gateway_id}/sensors/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean registerNewSensor(@PathVariable int unique_gateway_id) {
		//TODO
		return true;
	}
	//Register new actuator
	@RequestMapping(value = "/gateways/{unique_gateway_id}/actuators/", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody boolean registerNewActuator(@PathVariable int unique_gateway_id) {
		//TODO
		return true;
	}

}
