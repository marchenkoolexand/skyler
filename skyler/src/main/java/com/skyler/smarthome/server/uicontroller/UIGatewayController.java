package com.skyler.smarthome.server.uicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.model.Gateway;

@Controller
@RequestMapping("/gateway")
public class UIGatewayController {

	@Autowired
	GatewayDao gatewayDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<Gateway> getAllGateways() {

		List<Gateway> gatewayList = gatewayDao.getAllGateways();

		return gatewayList;
	};

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Gateway getGatewayById(@PathVariable int id) {

		Gateway gateway = gatewayDao.getGatewayById(id);

		return gateway;
	};

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateGateway(Gateway gateway) {

		gatewayDao.updateGateway(gateway);

	};

}
