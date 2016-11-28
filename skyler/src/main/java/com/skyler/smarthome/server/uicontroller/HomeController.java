package com.skyler.smarthome.server.uicontroller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.data.SensorDao;
import com.skyler.smarthome.server.data.UserDao;
import com.skyler.smarthome.server.enums.SensorStatus;
import com.skyler.smarthome.server.model.Gateway;
import com.skyler.smarthome.server.model.Sensor;
import com.skyler.smarthome.server.model.User;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	UserDao userDao;
	@Autowired
	GatewayDao gatewayDao;
	@Autowired
	SensorDao sensorDao;

	@RequestMapping(method = RequestMethod.GET)
	public String home() {

		userDao.createNewUser(new User("Sasha", "Marchenko", "Email", "recovery@email", "password", "phoneNumber"));

		Sensor sensor = new Sensor(3434, SensorStatus.NEW, null, new Date());
		Sensor sensor2 = new Sensor(3435, SensorStatus.DELETED, null, new Date());
		Sensor sensor3 = new Sensor(3436, SensorStatus.MISSING, null, new Date());

		List<Sensor> list = new ArrayList<Sensor>();
		list.add(sensor);
		list.add(sensor2);
		list.add(sensor3);

		Gateway gateway = new Gateway("First gateway", "localhost", list);

		gatewayDao.createGateway(gateway);

		return "index";
	};

}
