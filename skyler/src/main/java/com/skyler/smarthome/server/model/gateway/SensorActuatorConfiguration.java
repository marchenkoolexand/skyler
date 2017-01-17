package com.skyler.smarthome.server.model.gateway;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "s_sa_configuration")
public class SensorActuatorConfiguration {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "s_configuration_value", nullable = false)
    @Lob
    private byte[] configuration;

    public SensorActuatorConfiguration() {
    }

    public SensorActuatorConfiguration(byte[] configuration) {
        this.configuration = configuration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getConfiguration() {
        return configuration;
    }

    public void setConfiguration(byte[] configuration) {
        this.configuration = configuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorActuatorConfiguration that = (SensorActuatorConfiguration) o;
        if (id != that.id) return false;
        return Arrays.equals(configuration, that.configuration);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(configuration);
        return result;
    }

    @Override
    public String toString() {
        return "SensorActuatorConfiguration{" +
                "id=" + id +
                ", configuration=" + Arrays.toString(configuration) +
                '}';
    }
}
