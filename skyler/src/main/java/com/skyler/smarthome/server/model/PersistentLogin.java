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

    public PersistentLogin() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersistentLogin that = (PersistentLogin) o;
        if (series != null ? !series.equals(that.series) : that.series != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        return s_last_used != null ? s_last_used.equals(that.s_last_used) : that.s_last_used == null;

    }

    @Override
    public int hashCode() {
        int result = series != null ? series.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (s_last_used != null ? s_last_used.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersistentLogin{" +
                "series='" + series + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", s_last_used=" + s_last_used +
                '}';
    }
}
