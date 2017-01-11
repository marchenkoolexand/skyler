package com.skyler.smarthome.server.model;

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
	@Column(name = "s_gateway_ip")
	private String gwIp;
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "s_joined_gateway_devices", joinColumns = @JoinColumn(name = "s_gateway_fk"), inverseJoinColumns = @JoinColumn(name = "s_device_fk"))
	private List<Device> deviceList = new ArrayList<>();

	public Gateway() {
	}
	public Gateway(String gwName, String gwIp) {
		this.gwName = gwName;
		this.gwIp = gwIp;
	}

	public Gateway(String gwName, String gwIp, List<Device> deviceList) {
		this.gwName = gwName;
		this.gwIp = gwIp;
		this.deviceList = deviceList;
	}

	public void addDeviceToGateway(Device device){
		deviceList.add(device);
	}

	public void addDeviceListToGateway(List<Device> deviceList){
		deviceList.addAll(deviceList);
	}

	public String getGwName() {
		return gwName;
	}

	public void setGwName(String gwName) {
		this.gwName = gwName;
	}

	public String getGwIp() {
		return gwIp;
	}

	public void setGwIp(String gwIp) {
		this.gwIp = gwIp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Device> getDeviceList() {
		return deviceList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Gateway gateway = (Gateway) o;

		if (id != gateway.id) return false;
		if (gwName != null ? !gwName.equals(gateway.gwName) : gateway.gwName != null) return false;
		if (gwIp != null ? !gwIp.equals(gateway.gwIp) : gateway.gwIp != null) return false;
		return deviceList != null ? deviceList.equals(gateway.deviceList) : gateway.deviceList == null;

	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (gwName != null ? gwName.hashCode() : 0);
		result = 31 * result + (gwIp != null ? gwIp.hashCode() : 0);
		result = 31 * result + (deviceList != null ? deviceList.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Gateway{" +
				"id=" + id +
				", gwName='" + gwName + '\'' +
				", gwIp='" + gwIp + '\'' +
				", deviceList=" + deviceList +
				'}';
	}
}
