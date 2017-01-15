package com.skyler.smarthome.server.model.gateway;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "s_timestamp_obj")
public class TimestampObj {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "s_timestamp", unique = true, nullable = false)
    private Date timestamp;

    public TimestampObj() {
    }

    public TimestampObj(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        TimestampObj that = (TimestampObj) o;
        if (id != that.id) return false;
        return timestamp != null ? timestamp.equals(that.timestamp) : that.timestamp == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TimestampObj{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                '}';
    }
}
