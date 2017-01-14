package com.skyler.smarthome.server.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@DiscriminatorValue(value="S")
@Table(name="s_sensor")
public class Sensor  extends Module implements Serializable {

    @Column(name = "s_sensor_name")
    private String sensorName;

    public Sensor() {
    }

    public Sensor(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return sensorName != null ? sensorName.equals(sensor.sensorName) : sensor.sensorName == null;
    }

    @Override
    public int hashCode() {
        return sensorName != null ? sensorName.hashCode() : 0;
    }
}
