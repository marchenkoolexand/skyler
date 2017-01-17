package com.skyler.smarthome.server.model;

import com.skyler.smarthome.server.model.gateway.GatewayInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "s_gateways")
public class Gateway implements Serializable {

	@Transient
	private static final long serialVersionUID = 1189530690619771645L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	@Column(name = "s_gateway_name")
	private String gwName;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private GatewayInfo gatewayInfo;
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "s_joined_gateway_devices", joinColumns = @JoinColumn(name = "s_gateway_fk"), inverseJoinColumns = @JoinColumn(name = "s_device_fk"))
	private List<Device> deviceList = new ArrayList<>();

	public Gateway() {
	}
	public Gateway(String gwName) {
		this.gwName = gwName;
	}

	public Gateway(String gwName, List<Device> deviceList) {
		this.gwName = gwName;
		this.deviceList = deviceList;
	}

    public Gateway(String gwName, GatewayInfo gatewayInfo, List<Device> deviceList) {
        this.gwName = gwName;
        this.gatewayInfo = gatewayInfo;
        this.deviceList = deviceList;
    }

    public void addDeviceToGateway(Device device){
		deviceList.add(device);
	}

	public void addDeviceListToGateway(List<Device> deviceList){
		deviceList.addAll(deviceList);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGwName() {
		return gwName;
	}

	public void setGwName(String gwName) {
		this.gwName = gwName;
	}

	public List<Device> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<Device> deviceList) {
		this.deviceList = deviceList;
	}

    public GatewayInfo getGatewayInfo() {
        return gatewayInfo;
    }

    public void setGatewayInfo(GatewayInfo gatewayInfo) {
        this.gatewayInfo = gatewayInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gateway gateway = (Gateway) o;
        if (id != gateway.id) return false;
        if (gwName != null ? !gwName.equals(gateway.gwName) : gateway.gwName != null) return false;
        if (gatewayInfo != null ? !gatewayInfo.equals(gateway.gatewayInfo) : gateway.gatewayInfo != null) return false;
        return deviceList != null ? deviceList.equals(gateway.deviceList) : gateway.deviceList == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (gwName != null ? gwName.hashCode() : 0);
        result = 31 * result + (gatewayInfo != null ? gatewayInfo.hashCode() : 0);
        result = 31 * result + (deviceList != null ? deviceList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Gateway{" +
                "id=" + id +
                ", gwName='" + gwName + '\'' +
                ", gatewayInfo=" + gatewayInfo +
                ", deviceList=" + deviceList +
                '}';
    }
}
