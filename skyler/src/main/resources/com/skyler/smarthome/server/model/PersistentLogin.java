package com.skyler.smarthome.server.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="s_persistent_logins")
public class PersistentLogin implements Serializable {

    @Id
    private String series;

    @Column(name="s_email", unique=true, nullable=false)
    private String email;

    @Column(name="s_token", unique=true, nullable=false)
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    private Date s_last_used;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getS_last_used() {
        return s_last_used;
    }

    public void setS_last_used(Date s_last_used) {
        this.s_last_used = s_last_used;
    }
}
