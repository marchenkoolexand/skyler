package com.skyler.smarthome.server.model.gateway;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name="s_actuator_state")
public class ActuatorState {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "s_value", nullable = false)
    @Lob
    private byte[] value;

    public ActuatorState() {
    }

    public ActuatorState(byte[] value) {
        this.value = value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActuatorState that = (ActuatorState) o;
        if (id != that.id) return false;
        return Arrays.equals(value, that.value);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(value);
        return result;
    }

    @Override
    public String toString() {
        return "ActuatorState{" +
                "id=" + id +
                ", value=" + Arrays.toString(value) +
                '}';
    }
}
