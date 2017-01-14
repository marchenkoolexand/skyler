package com.skyler.smarthome.server.controller.gwcontroller;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.model.Gateway;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.List;

public class GatewayInternalSendController {

	final static Logger logger = Logger.getLogger(GatewayInternalSendController.class);

	@Autowired(required=true)
	GatewayDao gatewayDAO;

	//Get SmartHome Gateway Info
	//Path :<host>/info
	public void getGWInfo(){
		//TODO
	}

	//Path :<host>/check
	public HttpStatus checkGatewayConnection(URL url) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}

	//Get current timestamp, 0 if not set yet by SmartHome Main Server
	//Path :<host>/timestamp
	public HttpStatus timestamp(URL url) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}

	//Path :<host>/actuators
	public HttpStatus getActuatorListFromGateway(URL url) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}

	//Path :<host>/sensors
	public HttpStatus getSensorListFromGateway(URL url) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}


	public List<Gateway> getGatewayList(URL url) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}

	public HttpStatus postCommandToSensor(URL url) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}

	public HttpStatus postCommandToActuator(URL url) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}
}
