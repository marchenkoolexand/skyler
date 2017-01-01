package com.skyler.smarthome.server.controller.gwcontroller;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.model.Gateway;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.List;

public class GatewayInternalPostController {

	final static Logger logger = Logger.getLogger(GatewayInternalPostController.class);

	@Autowired(required=true)
	GatewayDao gatewayDAO;

	public HttpStatus checkGatewayConnection(int gatewayId, URL url) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}

	public HttpStatus postCommandToSensor(int gatewayId, URL url) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}

	public HttpStatus postCommandToActuator(int gatewayId, URL url) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}

	public HttpStatus getSensorListFromGateway(int gatewayId, URL url) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}

	public HttpStatus getActuatorListFromGateway(int gatewayId, URL url) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}

	public List<Gateway> getGatewayList(URL url) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}


}
