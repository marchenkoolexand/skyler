package com.skyler.smarthome.server.uicontroller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
	
	final static Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "index";
	};

}
