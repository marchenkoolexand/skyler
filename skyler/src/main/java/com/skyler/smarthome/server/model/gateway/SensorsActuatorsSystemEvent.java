package com.skyler.smarthome.server.model.gateway;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "s_sa_system_event")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SensorsActuatorsSystemEvent {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "s_state")
    private String state;
    @Temporal(TemporalType.DATE)
    @Column(name = "s_timestamp", unique = true, nullable = false)
    private Date timestamp;

    public SensorsActuatorsSystemEvent() {
    }

    public SensorsActuatorsSystemEvent(String state, Date timestamp) {
        this.state = state;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorsActuatorsSystemEvent that = (SensorsActuatorsSystemEvent) o;
        if (id != that.id) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        return timestamp != null ? timestamp.equals(that.timestamp) : that.timestamp == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SensorsActuatorsSystemEvent{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
