package com.skyler.smarthome.server.service;

import org.apache.log4j.Logger;

import com.skyler.smarthome.server.constants.GatewayFields;
import com.skyler.smarthome.server.model.Gateway;

public class GatewayService {

	final static Logger logger = Logger.getLogger(GatewayService.class);
	
	public static Gateway updateGatewayByField(Gateway gateway, String gatewayField, String newParam) {

		switch (gatewayField.toLowerCase()) {
		case GatewayFields.GATEWAY_NAME:
			gateway.setGwName(newParam);
			break;
		case GatewayFields.GATEWAY_URL:
			gateway.setGwUrl(newParam);
			break;
		}
		return gateway;
	}
}
