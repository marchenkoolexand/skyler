package com.skyler.smarthome.server.controller.homecontroller;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.data.ModuleDao;
import com.skyler.smarthome.server.data.UserDao;
import com.skyler.smarthome.server.model.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    final static Logger logger = Logger.getLogger(HomeController.class);

    @Autowired(required = true)
    ModuleDao moduleDaoImpl;
    @Autowired(required = true)
    GatewayDao gatewayDAO;
    @Autowired(required = true)
    UserDao userDaoImpl;

    @Autowired
    private SessionFactory sessionFactory;


    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "index";
    };

    @RequestMapping(value = "/test/",method = RequestMethod.GET)
    public String test() {
        addTestData();
        return "index";
    };


  void addTestData() {
      Session session = sessionFactory.openSession();

      List<Sensor> sensorList = new ArrayList();
      Sensor sensor = new Sensor("Sensor 1");
      Sensor sensor1 = new Sensor("Sensor 2");
      Sensor sensor2 = new Sensor("Sensor 3");
      Sensor sensor3 = new Sensor("Sensor 4");
      Sensor sensor4 = new Sensor("Sensor 5");
      sensorList.add(sensor);
      sensorList.add(sensor1);
      sensorList.add(sensor2);
      sensorList.add(sensor3);
      sensorList.add(sensor4);
      System.out.println("SENSOR LIST " + sensorList);

      List <Actuator>actuatorList = new ArrayList();
      Actuator actuator = new Actuator("Actuator 1");
      Actuator actuator1 = new Actuator("Actuator 2");
      Actuator actuator2 = new Actuator("Actuator 3");
      Actuator actuator3 = new Actuator("Actuator 4");
      Actuator actuator4 = new Actuator("Actuator 5");
      actuatorList.add(actuator);
      actuatorList.add(actuator1);
      actuatorList.add(actuator2);
      actuatorList.add(actuator3);
      actuatorList.add(actuator4);
      System.out.println("ACTUATOR LIST " + actuatorList);

      Device device = new Device("device 1");
      device.addSensorListToDevice(sensorList);
      device.addActuatorListToDevice(actuatorList);
      System.out.println("DEVICE " + device);

      Gateway gateway = new Gateway("gwname","192.168.1.1");
      gateway.addDeviceToGateway(device);

      System.out.println("GATEWAY  " + gateway);


      System.out.println("");

      gatewayDAO.createGateway(gateway);
      userDaoImpl.createNewUser(new User( "firstName",  "lastName",  "email",  "recoveryEmail",  "password","phoneNumber"));

  }
}
