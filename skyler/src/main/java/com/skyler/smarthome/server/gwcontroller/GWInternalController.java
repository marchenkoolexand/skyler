package com.skyler.smarthome.server.gwcontroller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skyler.smarthome.server.data.GateWayDao;
import com.skyler.smarthome.server.model.GateWay;

@Controller
@RequestMapping("/gateways")
public class GWInternalController {

	private GateWayDao gateWayDao;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<GateWay> allGateWays() {
		List<GateWay> allGateWaysList = gateWayDao.getAllGateWays();
		return allGateWaysList;
	}

}
