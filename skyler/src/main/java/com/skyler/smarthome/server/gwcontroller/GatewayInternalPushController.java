package com.skyler.smarthome.server.gwcontroller;

import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.enums.ModuleAction;
import com.skyler.smarthome.server.enums.ModuleStatus;
import com.skyler.smarthome.server.model.Gateway;
import com.skyler.smarthome.server.model.Module;

public class GatewayInternalPushController {
	
	final static Logger logger = Logger.getLogger(GatewayInternalPushController.class);

	@Autowired
	GatewayDao gatewayDAO;

	public List<Gateway> pingForGateways(URL baseGatewayUrl) {
		
		return null;
	}
	
	public List<Module> pingForModules(int gatewayId, URL url){
		
		return null;
	}
	
	public boolean postActionToModule(int gatewayId,int moduleId, URL url,ModuleAction moduleAction){
		
		return false;
	}
	
	public ModuleStatus pingForModuleStatus(int gatewayId,int moduleId, URL url){
		
		return null;
	}
}
