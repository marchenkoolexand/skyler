package com.skyler.smarthome.server.model.gateway;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "s_server_info")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MainServerInfo {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "s_protocol_version_major")
    private String protocolVersionMajor;
    @Column(name = "s_protocol_version_minor")
    private String protocolVersionMinor;

    public MainServerInfo() {
    }

    public MainServerInfo(String protocolVersionMajor, String protocolVersionMinor) {
        this.protocolVersionMajor = protocolVersionMajor;
        this.protocolVersionMinor = protocolVersionMinor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProtocolVersionMajor() {
        return protocolVersionMajor;
    }

    public void setProtocolVersionMajor(String protocolVersionMajor) {
        this.protocolVersionMajor = protocolVersionMajor;
    }

    public String getProtocolVersionMinor() {
        return protocolVersionMinor;
    }

    public void setProtocolVersionMinor(String protocolVersionMinor) {
        this.protocolVersionMinor = protocolVersionMinor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainServerInfo that = (MainServerInfo) o;
        if (id != that.id) return false;
        if (protocolVersionMajor != null ? !protocolVersionMajor.equals(that.protocolVersionMajor) : that.protocolVersionMajor != null)
            return false;
        return protocolVersionMinor != null ? protocolVersionMinor.equals(that.protocolVersionMinor) : that.protocolVersionMinor == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (protocolVersionMajor != null ? protocolVersionMajor.hashCode() : 0);
        result = 31 * result + (protocolVersionMinor != null ? protocolVersionMinor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MainServerInfo{" +
                "id=" + id +
                ", protocolVersionMajor='" + protocolVersionMajor + '\'' +
                ", protocolVersionMinor='" + protocolVersionMinor + '\'' +
                '}';
    }
}
