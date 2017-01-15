package com.skyler.smarthome.server.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "s_device")
public class Device implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "s_device_name")
    private String deviceName;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "s_joined_device_sensors", joinColumns = @JoinColumn(name = "s_gateway_fk"), inverseJoinColumns = @JoinColumn(name = "s_sensor_fk"))
    private List<Sensor> sensorList = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "s_joined_device_actuators", joinColumns = @JoinColumn(name = "s_gateway_fk"), inverseJoinColumns = @JoinColumn(name = "s_actuator_fk"))
    private List<Actuator> actuatorList = new ArrayList<>();

    public Device() {
    }

    public Device(String deviceName) {
        this.deviceName = deviceName;
    }

    public void addModuleToDevice(Module module) {
        if (module instanceof Sensor) {
            sensorList.add((Sensor) module);
        } else if (module instanceof Actuator) {
            actuatorList.add((Actuator) module);
        }
    }

    public void addSensorListToDevice(List<Sensor> sensorList) {
        this.sensorList.addAll(sensorList);
    }

    public void addActuatorListToDevice(List<Actuator> actuatorList) {
        this.actuatorList.addAll(actuatorList);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(List<Sensor> sensorList) {
        this.sensorList = sensorList;
    }

    public List<Actuator> getActuatorList() {
        return actuatorList;
    }

    public void setActuatorList(List<Actuator> actuatorList) {
        this.actuatorList = actuatorList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        if (id != device.id) return false;
        if (deviceName != null ? !deviceName.equals(device.deviceName) : device.deviceName != null) return false;
        if (sensorList != null ? !sensorList.equals(device.sensorList) : device.sensorList != null) return false;
        return actuatorList != null ? actuatorList.equals(device.actuatorList) : device.actuatorList == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (sensorList != null ? sensorList.hashCode() : 0);
        result = 31 * result + (actuatorList != null ? actuatorList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", deviceName='" + deviceName + '\'' +
                ", sensorList=" + sensorList +
                ", actuatorList=" + actuatorList +
                '}';
    }
}
