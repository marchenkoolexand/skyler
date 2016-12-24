package com.skyler.smarthome.server.controller.gwcontroller;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.enums.ModuleAction;
import com.skyler.smarthome.server.model.Gateway;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.List;

public class GatewayInternalPingController {

	
	final static Logger logger = Logger.getLogger(GatewayInternalPingController.class);

	@Autowired(required=true)
	GatewayDao gatewayDAO;

	public List<Gateway> pingForGateways(URL baseGatewayUrl) {
		RestTemplate restTemplate = new RestTemplate();
		return null;
	}

	public boolean postActionToModule(int gatewayId, int moduleId, URL url, ModuleAction moduleAction) {
		RestTemplate restTemplate = new RestTemplate();
		return false;
	}

	public HttpStatus checkGatewayConnection(int gatewayId,URL url) {
		RestTemplate restTemplate = new RestTemplate();
		return null;
	}
}
