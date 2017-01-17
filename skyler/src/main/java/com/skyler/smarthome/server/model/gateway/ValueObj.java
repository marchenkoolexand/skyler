package com.skyler.smarthome.server.model.gateway;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "s_value_obj")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValueObj {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "s_value", nullable = false)
    @Lob
    private byte[]value;

    public ValueObj() {
    }

    public ValueObj(byte[] value) {
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
        ValueObj valueObj = (ValueObj) o;
        if (id != valueObj.id) return false;
        return Arrays.equals(value, valueObj.value);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(value);
        return result;
    }

    @Override
    public String toString() {
        return "ValueObj{" +
                "id=" + id +
                ", value=" + Arrays.toString(value) +
                '}';
    }
}
