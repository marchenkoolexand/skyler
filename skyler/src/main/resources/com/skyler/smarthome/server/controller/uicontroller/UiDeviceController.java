package com.skyler.smarthome.server.controller.uicontroller;

import com.skyler.smarthome.server.data.DeviceDao;
import com.skyler.smarthome.server.model.Actuator;
import com.skyler.smarthome.server.model.Device;
import com.skyler.smarthome.server.model.Sensor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/device")
public class UiDeviceController {

    final static Logger logger = Logger.getLogger(UiDeviceController.class);

    @Autowired(required=true)
    DeviceDao deviceDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Device> getAllDevices() {
        return deviceDAO.getAllDevices();
    };

    @RequestMapping(value = "/{gateway_id}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Device> getAllDevicesFromGateway(@PathVariable int gateway_id) {
        return  deviceDAO.getAllDevicesFromGateway(gateway_id);
    };

    @RequestMapping(value = "/{device_id}/sensors/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Sensor> getDeviceSensors(@PathVariable int device_id) {
        return  deviceDAO.getDeviceById(device_id).getSensorList();
    };

    @RequestMapping(value = "/{device_id}/actuators/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Actuator> getDeviceActuators(@PathVariable int device_id) {
        return  deviceDAO.getDeviceById(device_id).getActuatorList();
    };



}
