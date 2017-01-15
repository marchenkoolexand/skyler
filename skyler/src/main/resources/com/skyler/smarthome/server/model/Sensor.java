package com.skyler.smarthome.server.model;

import com.skyler.smarthome.server.model.gateway.SensorInfo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue(value="S")
@Table(name="s_sensor")
public class Sensor  extends Module implements Serializable {

    @Column(name = "s_sensor_name")
    private String sensorName;
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private SensorInfo sensorInfo;

    public Sensor() {
    }

    public Sensor(String sensorName, SensorInfo sensorInfo) {
        this.sensorName = sensorName;
        this.sensorInfo = sensorInfo;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public SensorInfo getSensorInfo() {
        return sensorInfo;
    }

    public void setSensorInfo(SensorInfo sensorInfo) {
        this.sensorInfo = sensorInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        if (sensorName != null ? !sensorName.equals(sensor.sensorName) : sensor.sensorName != null) return false;
        return sensorInfo != null ? sensorInfo.equals(sensor.sensorInfo) : sensor.sensorInfo == null;

    }

    @Override
    public int hashCode() {
        int result = sensorName != null ? sensorName.hashCode() : 0;
        result = 31 * result + (sensorInfo != null ? sensorInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "sensorName='" + sensorName + '\'' +
                ", sensorInfo=" + sensorInfo +
                '}';
    }
}
