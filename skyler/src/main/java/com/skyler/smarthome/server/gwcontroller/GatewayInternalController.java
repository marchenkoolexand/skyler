package com.skyler.smarthome.server.gwcontroller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.model.Gateway;

@Controller
@RequestMapping("/gateways")
public class GatewayInternalController {

	private GatewayDao gatewayDao;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Gateway> allGateWays() {
		List<Gateway> allGatewaysList = gatewayDao.getAllGateways();
		return allGatewaysList;
	}

}
