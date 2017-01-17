package com.skyler.smarthome.server.model.gateway;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "s_sensor_event")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SensorEvent  {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "s_value", nullable = false)
    @Lob
    private byte[]value;
    @Temporal(TemporalType.DATE)
    @Column(name = "s_timestamp", unique = true, nullable = false)
    private Date timestamp;

    public SensorEvent() {
    }

    public SensorEvent(byte[] value, Date timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getValue() {
        return value;
    }

    public void setValue(byte[] value) {
        this.value = value;
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
        SensorEvent that = (SensorEvent) o;
        if (id != that.id) return false;
        if (!Arrays.equals(value, that.value)) return false;
        return timestamp != null ? timestamp.equals(that.timestamp) : that.timestamp == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(value);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "id=" + id +
                ", value=" + Arrays.toString(value) +
                ", timestamp=" + timestamp +
                '}';
    }
}
