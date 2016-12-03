package com.skyler.smarthome.server.gwcontroller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.data.SensorDao;
import com.skyler.smarthome.server.enums.SensorStatus;
import com.skyler.smarthome.server.model.Gateway;
import com.skyler.smarthome.server.model.Sensor;

@Controller
@RequestMapping("/internal")
public class GatewayInternalGetController {

	final static Logger logger = Logger.getLogger(GatewayInternalGetController.class);
	@Autowired
	GatewayDao gatewayDAO;
	@Autowired
	SensorDao sensorDao;

	@RequestMapping(value = "/registergateway", method = RequestMethod.GET)
	public void registerGateway(@RequestBody Gateway gateway) {
		boolean result = gatewayDAO.createGateway(gateway);
	}

	@RequestMapping(value = "/registersensor/{gatewayId}", method = RequestMethod.POST)
	public void registerSensor(@RequestBody Sensor sensor, @PathVariable int gatewayId) {
		sensor.setTimeStamp(new Date());
		sensor.setSensorStatus(SensorStatus.NEW);
		boolean result = sensorDao.addSensorToGateway(gatewayId, sensor);
	}

	@RequestMapping(value = "/gateway/delete/{id}", method = RequestMethod.POST)
	public void deleteGateway(@PathVariable int id) {
		boolean result = gatewayDAO.deleteGateway(id);
	}

	@RequestMapping(value = "/gateway/update/{id}", method = RequestMethod.POST)
	public void updateGateway(@PathVariable int id, @RequestParam String gatewayField, @RequestParam String newParam) {
		boolean result = gatewayDAO.updateGatewayByField(id, gatewayField, newParam);
	}

	@RequestMapping(value = "/gateway/{id}", method = RequestMethod.GET)
	public @ResponseBody Gateway getGatewayById(@PathVariable int id) {
		Gateway gateway = gatewayDAO.getGatewayById(id);
		return gateway;
	}

	@RequestMapping(value = "/gateway/all", method = RequestMethod.GET)
	public @ResponseBody List<Gateway> getAllGateway() {
		List<Gateway> gateways = gatewayDAO.getAllGateways();
		return gateways;
	}

	@RequestMapping(value = "/mark/sensor/{sensorId}/missing/", method = RequestMethod.POST)
	public void markSensorMissing(@PathVariable int sensorId) {
		boolean result = sensorDao.setSensorStatus(sensorId, SensorStatus.MISSING);
	}

	@RequestMapping(value = "/mark/sensor/{sensorId}/deleted/", method = RequestMethod.POST)
	public void markSensorDeleted(@PathVariable int sensorId) {
		boolean result = sensorDao.setSensorStatus(sensorId, SensorStatus.DELETED);
	}

	@RequestMapping(value = "/mark/sensor/{sensorId}/working/", method = RequestMethod.POST)
	public void markSensorWorking(@PathVariable int sensorId) {
		boolean result = sensorDao.setSensorStatus(sensorId, SensorStatus.WORKING);
	}
}
