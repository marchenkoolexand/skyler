package com.skyler.smarthome.server.data;

import java.util.List;

import com.skyler.smarthome.server.model.Gateway;

public interface GatewayDao {

	List<Gateway> getAllGateways();

	Gateway getGatewayById(int id);

	void deleteGateway(int id);

	void updateGateway(Gateway gateway);

	void createGateway(Gateway gateway);

}
