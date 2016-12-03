package com.skyler.smarthome.server.gwcontroller;

import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.enums.SensorAction;
import com.skyler.smarthome.server.enums.SensorStatus;
import com.skyler.smarthome.server.model.Gateway;
import com.skyler.smarthome.server.model.Sensor;

public class GatewayInternalPushController {
	
	final static Logger logger = Logger.getLogger(GatewayInternalPushController.class);

	@Autowired
	GatewayDao gatewayDAO;

	public List<Gateway> pingForGateways(URL baseGatewayUrl) {
		
		return null;
	}
	
	public List<Sensor> pingForSensors(int gatewayId, URL url){
		
		return null;
	}
	
	public boolean postActionToSensor(int gatewayId,int sensorId, URL url,SensorAction sensorAction){
		
		return false;
	}
	
	public SensorStatus pingForSensorStatus(int gatewayId,int sensorId, URL url){
		
		return null;
	}
}
