package com.skyler.smarthome.server.controller.gwcontroller;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.model.gateway.TimestampObj;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

public class GatewayInternalSendController {

	final static Logger logger = Logger.getLogger(GatewayInternalSendController.class);

	@Autowired(required=true)
	GatewayDao gatewayDAO;

	//SmartHome Gateway Info
	//GET Path :<host>/info
	public void getGWInfo(){
		//TODO
	}

	//GET Path :<host>/check
	public HttpStatus checkGatewayConnection(String ip) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}

	//Get current timestamp, 0 if not set yet by SmartHome Main Server
	//Path :<host>/timestamp
	public TimestampObj getTimestamp(String ip) {
		RestTemplate restTemplate = new RestTemplate();
        TimestampObj  timestampObj = restTemplate.getForObject("http://"+ip+"/timestamp",TimestampObj.class,200);
		return timestampObj;
	}

	//Set timestamp (SH Main Server shall call this end point periodically to keep time on Gateway(s) more accurate and to initialize it after system restart)
	//POST Path :<host>/timestamp
    //Responce should be 200
	public HttpStatus setTimestamp(String ip) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}

	//Return list of registered Actuators for this Gateway (with current states and configurations)
	//GET Path :<host>/actuators
	public HttpStatus getActuatorListFromGateway(String ip) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}

    //Return Actuator info from Gateway
    //GET Path :<host>/actuators/{actuator_id}
    public HttpStatus getActuatorInfoByIdFromGateway(String ip) {
        RestTemplate restTemplate = new RestTemplate();
        //TODO
        return null;
    }

    //Set new configuration for Actuator
    //POST <host>/actuators/{actuatorId}/conf
    public void setActuatorConfig(int actuatorId,String ip){

    }

    //Return list of registered Sensors for this Gateway (with current states and configurations)
	//GET Path :<host>/sensors
	public HttpStatus getSensorListFromGateway(String ip) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}

    //Get Sensor Info with current state and configuration
    //GET Path :<host>/sensors/{sensor_id}
    public HttpStatus getSensorInfoByIdFromGateway(int sensorId,String ip) {
        RestTemplate restTemplate = new RestTemplate();
        //TODO
        return null;
    }

    //Set new configuration for Sensor
    //POST <host>/sensors/{sensorId}/conf
    public void setSensorConfig(int sensorId,String ip){

    }
}
