package com.skyler.smarthome.server.model;

import com.skyler.smarthome.server.model.gateway.ActuatorInfo;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@DiscriminatorValue(value="A")
@Table(name="s_actuator")
public class Actuator extends Module implements Serializable {

    @Column(name = "s_actuator_name")
    private String actuatorName;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private ActuatorInfo actuatorInfo;

    public Actuator(String actuatorName, ActuatorInfo actuatorInfo) {
        this.actuatorName = actuatorName;
        this.actuatorInfo = actuatorInfo;
    }

    public String getActuatorName() {
        return actuatorName;
    }

    public void setActuatorName(String actuatorName) {
        this.actuatorName = actuatorName;
    }

    public ActuatorInfo getActuatorInfo() {
        return actuatorInfo;
    }

    public void setActuatorInfo(ActuatorInfo actuatorInfo) {
        this.actuatorInfo = actuatorInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actuator actuator = (Actuator) o;
        if (actuatorName != null ? !actuatorName.equals(actuator.actuatorName) : actuator.actuatorName != null)
            return false;
        return actuatorInfo != null ? actuatorInfo.equals(actuator.actuatorInfo) : actuator.actuatorInfo == null;

    }

    @Override
    public int hashCode() {
        int result = actuatorName != null ? actuatorName.hashCode() : 0;
        result = 31 * result + (actuatorInfo != null ? actuatorInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Actuator{" +
                "actuatorName='" + actuatorName + '\'' +
                ", actuatorInfo=" + actuatorInfo +
                '}';
    }
}
