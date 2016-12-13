package com.skyler.smarthome.server.controller.gwcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.skyler.smarthome.server.data.GatewayDao;

public class GatewayInternalPushController {

	final static Logger logger = Logger.getLogger(GatewayInternalPushController.class);

	@Autowired(required=true)
	GatewayDao gatewayDAO;
	
	
}
