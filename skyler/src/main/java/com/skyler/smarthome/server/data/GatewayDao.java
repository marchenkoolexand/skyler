package com.skyler.smarthome.server.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyler.smarthome.server.model.Gateway;

@Repository
public interface GatewayDao {

	List<Gateway> getAllGateways();

	Gateway getGatewayById(int id);

	boolean deleteGateway(int id);

	boolean updateGatewayByField(int gatewayId, String gatewayField, String newParam);
	
	boolean updateGateway(Gateway gateway);

	boolean createGateway(Gateway gateway);

}
