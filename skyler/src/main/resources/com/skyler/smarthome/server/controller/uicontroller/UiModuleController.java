package com.skyler.smarthome.server.controller.uicontroller;

import com.skyler.smarthome.server.data.ModuleDao;
import com.skyler.smarthome.server.model.Module;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/module")
public class UiModuleController {

	final static Logger logger = Logger.getLogger(UiModuleController.class);

	@Autowired(required=true)
	private ModuleDao moduleDao;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  List<Module> allModules() {

		return null;
	}

	@RequestMapping(value = "/{moduleid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Module getModuleById(@PathVariable int moduleid) {
		if (moduleid > 0) {
			return null;
		} else {
			return null;
		}
	}


}
