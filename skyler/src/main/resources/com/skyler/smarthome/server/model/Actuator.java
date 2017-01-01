package com.skyler.smarthome.server.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@DiscriminatorValue(value="A")
@Table(name="s_actuator")
public class Actuator extends Module implements Serializable {

    @Column(name = "s_actuator_name")
    private String actuatorName;

    public Actuator() {
    }

    public Actuator(String actuatorName) {
        this.actuatorName = actuatorName;
    }

    public String getActuatorName() {
        return actuatorName;
    }

    public void setActuatorName(String actuatorName) {
        this.actuatorName = actuatorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actuator actuator = (Actuator) o;

        return actuatorName != null ? actuatorName.equals(actuator.actuatorName) : actuator.actuatorName == null;

    }

    @Override
    public int hashCode() {
        return actuatorName != null ? actuatorName.hashCode() : 0;
    }
}
