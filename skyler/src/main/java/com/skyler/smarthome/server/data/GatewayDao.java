package com.skyler.smarthome.server.data;

import java.util.List;

import com.skyler.smarthome.server.model.GateWay;

public interface GateWayDao {

	List<GateWay> getAllGateWays();

	GateWay getGateWayById(int id);

	void deleteGateWay(int id);

	void updateGateWay(GateWay gateWay);

	void createGateWay(GateWay gateway);

}
