package com.skyler.smarthome.server.gwcontroller;

import java.util.List;

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

	@Autowired
	GatewayDao gatewayDAO;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public void registerGateway() {

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public void deleteGateway(@PathVariable int id) {

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public void updateGateway(@PathVariable int id) {

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Gateway getGatewayById(@PathVariable int id) {

		return null;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Gateway> getAllGateway() {

		return null;

	}
}
