package com.skyler.smarthome.server.data;

import com.skyler.smarthome.server.model.Device;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceDao {

    public List<Device> getAllDevices();

    public List<Device> getAllDevicesFromGateway(int gwId);

    public Device getDeviceById(int id);

    public boolean addDeviceToGateway(int gateway, Device device);

    public boolean addDeviceListToGateway(int gateway, List<Device> devicesList);
}
