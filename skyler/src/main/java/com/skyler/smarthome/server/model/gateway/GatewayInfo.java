package com.skyler.smarthome.server.model.gateway;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "s_gateway_info")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GatewayInfo {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "s_unique_id")
    private String uid;
    @Column(name = "s_gateway_ip")
    private String ipAddress;
    @Column(name = "s_firmware_version")
    private String firmwareVersion;

    public GatewayInfo() {
    }

    public GatewayInfo(String uid, String ipAddress, String firmwareVersion) {
        this.uid = uid;
        this.ipAddress = ipAddress;
        this.firmwareVersion = firmwareVersion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GatewayInfo that = (GatewayInfo) o;
        if (id != that.id) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (ipAddress != null ? !ipAddress.equals(that.ipAddress) : that.ipAddress != null) return false;
        return firmwareVersion != null ? firmwareVersion.equals(that.firmwareVersion) : that.firmwareVersion == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
        result = 31 * result + (firmwareVersion != null ? firmwareVersion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GatewayInfo{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", firmwareVersion='" + firmwareVersion + '\'' +
                '}';
    }
}
