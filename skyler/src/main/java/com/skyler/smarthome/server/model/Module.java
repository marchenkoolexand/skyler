package com.skyler.smarthome.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "s_modules")
public abstract class Module implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    public Module() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
