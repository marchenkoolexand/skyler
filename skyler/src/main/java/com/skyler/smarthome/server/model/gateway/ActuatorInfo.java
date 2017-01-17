package com.skyler.smarthome.server.model.gateway;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name="s_actuator_info")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActuatorInfo {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private ActuatorState state;
    @Column(name = "s_hardware_id")
    private String hardwareId;
    @Column(name = "s_hardware_type")
    private String hardwareType;
    @Column(name = "s_hardware_spec", nullable = false)
    @Lob
    private byte[] hardwareSpec;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private SensorActuatorConfiguration configuration;

    public ActuatorInfo() {
    }

    public ActuatorInfo(ActuatorState state, String hardwareId, String hardwareType, byte[] hardwareSpec, SensorActuatorConfiguration configuration) {
        this.state = state;
        this.hardwareId = hardwareId;
        this.hardwareType = hardwareType;
        this.hardwareSpec = hardwareSpec;
        this.configuration = configuration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ActuatorState getState() {
        return state;
    }

    public void setState(ActuatorState state) {
        this.state = state;
    }

    public String getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(String hardwareId) {
        this.hardwareId = hardwareId;
    }

    public String getHardwareType() {
        return hardwareType;
    }

    public void setHardwareType(String hardwareType) {
        this.hardwareType = hardwareType;
    }

    public byte[] getHardwareSpec() {
        return hardwareSpec;
    }

    public void setHardwareSpec(byte[] hardwareSpec) {
        this.hardwareSpec = hardwareSpec;
    }

    public SensorActuatorConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(SensorActuatorConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActuatorInfo that = (ActuatorInfo) o;
        if (id != that.id) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (hardwareId != null ? !hardwareId.equals(that.hardwareId) : that.hardwareId != null) return false;
        if (hardwareType != null ? !hardwareType.equals(that.hardwareType) : that.hardwareType != null) return false;
        if (!Arrays.equals(hardwareSpec, that.hardwareSpec)) return false;
        return configuration != null ? configuration.equals(that.configuration) : that.configuration == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (hardwareId != null ? hardwareId.hashCode() : 0);
        result = 31 * result + (hardwareType != null ? hardwareType.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(hardwareSpec);
        result = 31 * result + (configuration != null ? configuration.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ActuatorInfo{" +
                "id=" + id +
                ", state=" + state +
                ", hardwareId='" + hardwareId + '\'' +
                ", hardwareType='" + hardwareType + '\'' +
                ", hardwareSpec=" + Arrays.toString(hardwareSpec) +
                ", configuration=" + configuration +
                '}';
    }
}
