package com.skyler.smarthome.server.controller.gwcontroller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.data.ModuleDao;
import com.skyler.smarthome.server.enums.ModuleStatus;
import com.skyler.smarthome.server.model.Gateway;
import com.skyler.smarthome.server.model.Module;

/**
 * Main internal Gateway GET controller which use to provide ability
 * register,delete,update Gateway and Modules, or change their status.
 * 
 * @see Gateway
 * @see Module
 * 
 * @author Oleksandr Marchenko
 * @version %I%, %G%
 */
@Controller
@RequestMapping("/internal")
public class GatewayInternalGetController {

	final static Logger logger = Logger.getLogger(GatewayInternalGetController.class);
	
	@Autowired(required=true)
	GatewayDao gatewayDAO;
	@Autowired(required=true)
	ModuleDao moduleDao;

	@RequestMapping(value = "/registergateway", method = RequestMethod.POST)
	public void registerGateway(@RequestBody Gateway gateway) {
		boolean result = gatewayDAO.createGateway(gateway);
	}

	@RequestMapping(value = "/registermodule/{gatewayId}", method = RequestMethod.POST)
	public void registerModule(@RequestBody Module module, @PathVariable int gatewayId) {
		module.setTimeStamp(new Date());
		module.setModuleStatus(ModuleStatus.NEW);
		boolean result = moduleDao.addModuleToGateway(gatewayId, module);
	}

	@RequestMapping(value = "/gateway/delete/{gatewayid}", method = RequestMethod.POST)
	public void deleteGateway(@PathVariable int gatewayid) {
		boolean result = gatewayDAO.deleteGateway(gatewayid);
	}

	@RequestMapping(value = "/gateway/update/{gatewayid}", method = RequestMethod.POST)
	public void updateGateway(@PathVariable int gatewayid, @RequestParam String gatewayField,
			@RequestParam String newParam) {
		boolean result = gatewayDAO.updateGatewayByField(gatewayid, gatewayField, newParam);
	}

	@RequestMapping(value = "/gateway/{gatewayid}", method = RequestMethod.GET)
	public @ResponseBody Gateway getGatewayById(@PathVariable int gatewayid) {
		Gateway gateway = gatewayDAO.getGatewayById(gatewayid);
		return gateway;
	}

	@RequestMapping(value = "/gateway/all", method = RequestMethod.GET)
	public @ResponseBody List<Gateway> getAllGateway() {
		List<Gateway> gateways = gatewayDAO.getAllGateways();
		return gateways;
	}

	@RequestMapping(value = "/mark/module/{moduleId}/missing/", method = RequestMethod.POST)
	public void markModuleMissing(@PathVariable int moduleId) {
		boolean result = moduleDao.setModuleStatus(moduleId, ModuleStatus.MISSING);
	}

	@RequestMapping(value = "/mark/module/{moduleId}/deleted/", method = RequestMethod.POST)
	public void markModuleDeleted(@PathVariable int moduleId) {
		boolean result = moduleDao.setModuleStatus(moduleId, ModuleStatus.DELETED);
	}

	@RequestMapping(value = "/mark/module/{moduleId}/working/", method = RequestMethod.POST)
	public void markModuleWorking(@PathVariable int moduleId) {
		boolean result = moduleDao.setModuleStatus(moduleId, ModuleStatus.WORKING);
	}
}
