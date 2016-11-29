package com.skyler.smarthome.server.gwcontroller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.model.Gateway;

@Controller
@RequestMapping("/internal/gateway")
public class GatewayInternalGetController {

	final static Logger logger = Logger.getLogger(GatewayInternalGetController.class);

	@Autowired
	GatewayDao gatewayDAO;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public void registerGateway(Gateway gateway) {

		gatewayDAO.createGateway(gateway);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public void deleteGateway(@PathVariable int id) {

		gatewayDAO.deleteGateway(id);

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public void updateGateway(@PathVariable int id) {

		Gateway gateway = gatewayDAO.getGatewayById(id);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Gateway getGatewayById(@PathVariable int id) {

		Gateway gateway = gatewayDAO.getGatewayById(id);

		return gateway;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Gateway> getAllGateway() {

		List<Gateway> gateways = gatewayDAO.getAllGateways();

		return gateways;

	}
}
