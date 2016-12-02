package com.skyler.smarthome.server.gwcontroller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.model.Gateway;
import com.skyler.smarthome.server.model.Sensor;

public class GatewayInternalPushController {
	
	final static Logger logger = Logger.getLogger(GatewayInternalPushController.class);

	@Autowired
	GatewayDao gatewayDAO;
	
	public Gateway getGateway() {
		return null;
	}

	public List<Gateway> getAllGateway() {
		return null;

	}
	
	public void pushAction(){
	}
	
	public boolean onSensor(Sensor sensor) {
		return false;
	}

	public boolean offSensor(Sensor sensor) {
		return false;
	}
}
