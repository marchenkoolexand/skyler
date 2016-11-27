package com.skyler.smarthome.server.uicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skyler.smarthome.server.data.GateWayDao;
import com.skyler.smarthome.server.model.GateWay;

@Controller
@RequestMapping("/gateway")
public class UIGateWayController {

	@Autowired
	GateWayDao gateWayDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<GateWay> getAllGateWays() {

		List<GateWay> gateWayList = gateWayDao.getAllGateWays();

		return gateWayList;
	};

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public GateWay getGateWayById(@PathVariable int id) {

		GateWay gateWay = gateWayDao.getGateWayById(id);

		return gateWay;
	};

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String deleteGateWayById(@PathVariable int id) {

		gateWayDao.deleteGateWay(id);

		return "result";
	};

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateGateWay(GateWay gateWay) {

		gateWayDao.updateGateWay(gateWay);

	};

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createGateWay(GateWay gateWay) {

		gateWayDao.createGateWay(gateWay);

	};
}
