package com.skyler.smarthome.server.uicontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.data.SensorDao;
import com.skyler.smarthome.server.data.UserDao;
import com.skyler.smarthome.server.enums.SensorAction;
import com.skyler.smarthome.server.enums.SensorStatus;
import com.skyler.smarthome.server.enums.SensorType;
import com.skyler.smarthome.server.model.Gateway;
import com.skyler.smarthome.server.model.Sensor;
import com.skyler.smarthome.server.model.User;

@Controller
@RequestMapping("/")
public class HomeController {

	final static Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	SensorDao sensorDAO;
	@Autowired
	GatewayDao gatewayDAO;
	@Autowired
	UserDao userDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "index";
	};

	@RequestMapping(method = RequestMethod.POST)
	public String homeTest() {
		return "index";
	};
	
	
	
	
	
	void addTestData(){
		
		List<Sensor> sensorList = new ArrayList<Sensor>();
		Set<SensorAction> suported = new TreeSet<SensorAction>();
		suported.add(SensorAction.ACTION1);
		suported.add(SensorAction.ACTION2);
		suported.add(SensorAction.ACTION3);
		Sensor sensor = new Sensor(21, SensorStatus.NEW, SensorType.TESTTYPE1, suported);
		Sensor sensor2 = new Sensor(22, SensorStatus.DELETED, SensorType.TESTTYPE2, suported);
		Sensor sensor3 = new Sensor(23, SensorStatus.MISSING, SensorType.TESTTYPE1, suported);
		Sensor sensor4 = new Sensor(24, SensorStatus.WORKING, SensorType.TESTTYPE2, suported);
		Sensor sensor5 = new Sensor(25, SensorStatus.NEW, SensorType.TESTTYPE1, suported);
		Sensor sensor6 = new Sensor(26, SensorStatus.NEW, SensorType.TESTTYPE2, suported);
		sensorList.add(sensor);
		sensorList.add(sensor2);
		sensorList.add(sensor3);
		sensorList.add(sensor4);
		sensorList.add(sensor5);
		sensorList.add(sensor6);
		Gateway gateway = new Gateway("New Gate Way name", "new GW URL", sensorList);
		gateway.setSensorList(sensorList);
		gatewayDAO.createGateway(gateway);
		User user = new User("OLEH", "IVANCUK", "ivanchuk@mail.com", "ivanchukrec@mail.com", "seCrEtPassword",
				"+380660000008");
		userDAO.createNewUser(user);
	}

}
