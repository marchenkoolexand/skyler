package com.skyler.smarthome.server.controller.homecontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.data.ModuleDao;
import com.skyler.smarthome.server.data.UserDao;
import com.skyler.smarthome.server.enums.ModuleAction;
import com.skyler.smarthome.server.enums.ModuleStatus;
import com.skyler.smarthome.server.enums.ModuleType;
import com.skyler.smarthome.server.model.Gateway;
import com.skyler.smarthome.server.model.Module;
import com.skyler.smarthome.server.model.User;

@Controller
@RequestMapping("/")
public class HomeController {

	final static Logger logger = Logger.getLogger(HomeController.class);

	@Autowired(required=true)
	ModuleDao moduleDAO;
	@Autowired(required=true)
	GatewayDao gatewayDAO;
	@Autowired(required=true)
	UserDao userDAO;
	

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		//addTestData();
		return "index";
	};

	
	void addTestData(){
		
		List<Module> moduleList = new ArrayList<Module>();
		Set<ModuleAction> suported = new TreeSet<ModuleAction>();
		suported.add(ModuleAction.ACTION1);
		suported.add(ModuleAction.ACTION2);
		suported.add(ModuleAction.ACTION3);
		Module module = new Module(21, ModuleStatus.NEW, ModuleType.TESTTYPE1, suported);
		Module module2 = new Module(22, ModuleStatus.DELETED, ModuleType.TESTTYPE2, suported);
		Module module3 = new Module(23, ModuleStatus.MISSING, ModuleType.TESTTYPE1, suported);
		Module module4 = new Module(24, ModuleStatus.WORKING, ModuleType.TESTTYPE2, suported);
		Module module5 = new Module(25, ModuleStatus.NEW, ModuleType.TESTTYPE1, suported);
		Module module6 = new Module(26, ModuleStatus.NEW, ModuleType.TESTTYPE2, suported);
		moduleList.add(module);
		moduleList.add(module2);
		moduleList.add(module3);
		moduleList.add(module4);
		moduleList.add(module5);
		moduleList.add(module6);
		Gateway gateway = new Gateway("New Gate Way name", "new GW URL", moduleList);
		gateway.setModuleList(moduleList);
		gatewayDAO.createGateway(gateway);
		User user = new User("OLEH", "IVANCUK", "ivanchuk@mail.com", "ivanchukrec@mail.com", "seCrEtPassword",
				"+380660000008");
		userDAO.createNewUser(user);
	}

}
