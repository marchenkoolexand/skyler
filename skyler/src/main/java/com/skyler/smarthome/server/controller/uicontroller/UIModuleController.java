package com.skyler.smarthome.server.controller.uicontroller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyler.smarthome.server.data.ModuleDao;
import com.skyler.smarthome.server.enums.ModuleStatus;
import com.skyler.smarthome.server.model.Module;

@Controller
@RequestMapping("/module")
public class UIModuleController {

	final static Logger logger = Logger.getLogger(UIModuleController.class);

	@Autowired
	private ModuleDao moduleDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Module> allModules() {
		List<Module> allModulesList = moduleDao.getAllModules();
		return allModulesList;
	}

	@RequestMapping(value = "/{moduleid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Module getModuleById(@PathVariable int moduleid) {
		if (moduleid > 0) {
			Module module = moduleDao.getModuleById(moduleid);
			return module;
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/newmoduls", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Module> newModules() {
		List<Module> newModulesList = moduleDao.getModuleByStatus(ModuleStatus.NEW);
		return newModulesList;
	}

	@RequestMapping(value = "/missing", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Module> missingModules() {
		List<Module> missingModulsList = moduleDao.getModuleByStatus(ModuleStatus.MISSING);
		return missingModulsList;
	}

	@RequestMapping(value = "/deleted", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Module> deletedModules() {
		List<Module> deletedModulesList = moduleDao.getModuleByStatus(ModuleStatus.DELETED);
		return deletedModulesList;
	}

	@RequestMapping(value = "/working", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Module> workingModules() {
		List<Module> deletedModulesList = moduleDao.getModuleByStatus(ModuleStatus.WORKING);
		return deletedModulesList;
	}
}
