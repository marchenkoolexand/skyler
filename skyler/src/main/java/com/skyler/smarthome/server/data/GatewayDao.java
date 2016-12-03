package com.skyler.smarthome.server.data;

import java.util.List;

import com.skyler.smarthome.server.model.Gateway;

public interface GatewayDao {

	List<Gateway> getAllGateways();

	Gateway getGatewayById(int id);

	boolean deleteGateway(int id);

	boolean updateGatewayByField(int gatewayId, String gatewayField, String newParam);
	
	boolean updateGateway(Gateway gateway);

	boolean createGateway(Gateway gateway);

}
