package com.skyler.smarthome.server.util;

import com.skyler.smarthome.server.constants.GatewayFields;
import com.skyler.smarthome.server.model.Gateway;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class GatewayUtil {

	final static Logger logger = Logger.getLogger(GatewayUtil.class);

	public static Gateway updateGatewayByField(Gateway gateway, String gatewayField, String newParam) {

		switch (gatewayField.toLowerCase()) {
		case GatewayFields.GATEWAY_NAME:
			gateway.setGwName(newParam);
			break;
		}
		return gateway;
	}
}
