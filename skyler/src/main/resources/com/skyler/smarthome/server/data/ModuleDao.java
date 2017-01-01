package com.skyler.smarthome.server.data;

import com.skyler.smarthome.server.model.Actuator;
import com.skyler.smarthome.server.model.Module;
import com.skyler.smarthome.server.model.Sensor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleDao {

	public List<Module> getAllModules();

    public List<Sensor> getAllSensor();

    public List<Actuator> getAllActuator();

	public Sensor getSensorById(int sensorId);

    public Actuator getActuatorById(int actuatorId);

	public boolean addModuleToDevice(int deviceId, Module module);

	public boolean addSensorListToDevice(int deviceId, List<Sensor> sensorList);

	public boolean addActuatorListToDevice(int deviceId, List<Actuator> actuatorList);

}
