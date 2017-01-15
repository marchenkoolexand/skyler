package com.skyler.smarthome.server.controller.mainhomecontroller;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.data.ModuleDao;
import com.skyler.smarthome.server.data.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired(required = true)
    ModuleDao moduleDaoImpl;
    @Autowired(required = true)
    GatewayDao gatewayDAO;
    @Autowired(required = true)
    UserDao userDaoImpl;
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/test/",method = RequestMethod.GET)
    public String test() {
        return "redirect:index";
    };

    @RequestMapping(value = "/test/exception",method = RequestMethod.GET)
    public String testException() {
        throw new IndexOutOfBoundsException("Exception");
    };

//    void addTestData() {
//        Session session = sessionFactory.openSession();
//        List<Sensor> sensorList = new ArrayList();
//        Sensor sensor = new Sensor("Sensor 1");
//        Sensor sensor1 = new Sensor("Sensor 2");
//        Sensor sensor2 = new Sensor("Sensor 3");
//        Sensor sensor3 = new Sensor("Sensor 4");
//        Sensor sensor4 = new Sensor("Sensor 5");
//        sensorList.add(sensor);
//        sensorList.add(sensor1);
//        sensorList.add(sensor2);
//        sensorList.add(sensor3);
//        sensorList.add(sensor4);
//        List <Actuator>actuatorList = new ArrayList();
//        Actuator actuator = new Actuator("Actuator 1");
//        Actuator actuator1 = new Actuator("Actuator 2");
//        Actuator actuator2 = new Actuator("Actuator 3");
//        Actuator actuator3 = new Actuator("Actuator 4");
//        Actuator actuator4 = new Actuator("Actuator 5");
//        actuatorList.add(actuator);
//        actuatorList.add(actuator1);
//        actuatorList.add(actuator2);
//        actuatorList.add(actuator3);
//        actuatorList.add(actuator4);
//        Device device = new Device("device 1");
//        device.addSensorListToDevice(sensorList);
//        device.addActuatorListToDevice(actuatorList);
//        Gateway gateway = new Gateway("gwname","192.168.1.1");
//        gateway.addDeviceToGateway(device);
//        gatewayDAO.createGateway(gateway);
//
//        User user = new User( "Skyler",  "Smart Home",  "skyler@i.ua",  "skelerrecovery@i.ua",  "skyler","+380668888888",true);
//        User user2 = new User( "Gateway",  "Gateway",  "gateway@i.ua",  "gatewayrecovery@i.ua",  "gateway","+380668888888",true);
//        Set<UserRole> userRoleSet = new HashSet<UserRole>();
//
//        userRoleSet.add(new UserRole("ROLE_ADMIN"));
//        userRoleSet.add(new UserRole("ROLE_GATEWAY"));
//        user.setUserRole(userRoleSet);
//        user2.setUserRole(userRoleSet);
//        userDaoImpl.createNewUser(user);
//        userDaoImpl.createNewUser(user2);
//
//    }
}
