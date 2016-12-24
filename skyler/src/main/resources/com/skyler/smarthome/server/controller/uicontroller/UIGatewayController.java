package com.skyler.smarthome.server.controller.uicontroller;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.model.Gateway;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gateway")
public class UIGatewayController {

	final static Logger logger = Logger.getLogger(UIGatewayController.class);

	@Autowired(required=true)
	GatewayDao gatewayDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  List<Gateway> getAllGateways() {
		List<Gateway> gatewayList = gatewayDao.getAllGateways();
		return gatewayList;
	};

	@RequestMapping(value = "/{gatewayid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  Gateway getGatewayById(@PathVariable int gatewayid) {
		if (gatewayid > 0) {
			Gateway gateway = gatewayDao.getGatewayById(gatewayid);
			return gateway;
		} else {
			return null;
		}
	};

	@RequestMapping(value = "/update/{gatewayid}", method = RequestMethod.POST)
	public void updateGateway(@PathVariable int gatewayid, @RequestParam String gatewayField, @RequestParam String newParam) {
		if (gatewayid > 0 && gatewayField != null && newParam != null) {
			boolean result = gatewayDao.updateGatewayByField(gatewayid, gatewayField, newParam);
		}
	};

}
