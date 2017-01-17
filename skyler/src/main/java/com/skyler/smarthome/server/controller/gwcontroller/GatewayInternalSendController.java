package com.skyler.smarthome.server.controller.gwcontroller;

import com.skyler.smarthome.server.model.gateway.ActuatorInfo;
import com.skyler.smarthome.server.model.gateway.GatewayInfo;
import com.skyler.smarthome.server.model.gateway.SensorInfo;
import com.skyler.smarthome.server.model.gateway.TimestampObj;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class GatewayInternalSendController {

	final static Logger logger = Logger.getLogger(GatewayInternalSendController.class);

	//SmartHome Gateway Info
	//GET Path :<host>/info
	public GatewayInfo getGWInfo(String gwIp){
		GatewayInfo gatewayInfo = null;
		if (gwIp != null ) {
			RestTemplate restTemplate = new RestTemplate();
			gatewayInfo = restTemplate.getForObject("http://" + gwIp + "/info", GatewayInfo.class, 200);
		}
		return gatewayInfo;
	}

	//GET Path :<host>/check
	public HttpStatus checkGatewayConnection(String gwIp) {
		RestTemplate restTemplate = new RestTemplate();
		//TODO
		return null;
	}

	//Get current timestamp, 0 if not set yet by SmartHome Main Server
	//Path :<host>/timestamp
	public TimestampObj getTimestamp(String gwIp) {
		TimestampObj timestampObj = null;
		if (gwIp != null ) {
			RestTemplate restTemplate = new RestTemplate();
			timestampObj = restTemplate.getForObject("http://" + gwIp + "/timestamp", TimestampObj.class, 200);
		}
		return timestampObj;
	}

	//Set timestamp (SH Main Server shall call this end point periodically to keep time on Gateway(s) more accurate and to initialize it after system restart)
	//POST Path :<host>/timestamp
    //Responce should be 200
	public void setTimestamp(String gwIp) {
		TimestampObj timestampObj;
		if (gwIp != null ) {
			RestTemplate restTemplate = new RestTemplate();
			timestampObj = new TimestampObj();
			timestampObj.setTimestamp(new Date().getTime());
            restTemplate.postForObject( "http://" + gwIp + "/timestamp", timestampObj, TimestampObj.class);
		}
	}

	//Return list of registered Actuators for this Gateway (with current states and configurations)
	//GET Path :<host>/actuators
	public List<ActuatorInfo> getActuatorListFromGateway(String gwIp) {
        ActuatorInfo[] response;
        if (gwIp != null ) {
            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.getForObject("http://" + gwIp + "/actuators", ActuatorInfo[].class);
            if (response != null){
                return Arrays.asList(response);
            }
        }
        return null;
    }

    //Return Actuator info from Gateway
    //GET Path :<host>/actuators/{actuator_id}
    public ActuatorInfo getActuatorInfoByIdFromGateway(String gwIp, int actuatorId) {
        ActuatorInfo actuatorInfo;
        if (gwIp != null && actuatorId > 0) {
            RestTemplate restTemplate = new RestTemplate();
            actuatorInfo = restTemplate.getForObject("http://" + gwIp + "/actuators/"+actuatorId, ActuatorInfo.class, 200);
            return actuatorInfo;
        }
        return null;
    }


    //Set new configuration for Actuator
    //POST <host>/actuators/{actuatorId}/conf
    public void setActuatorConfig(ActuatorInfo actuatorInfo,int actuatorId,String gwIp){
        if (gwIp != null && actuatorInfo != null && actuatorId > 0 ) {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject( "http://" + gwIp + "/actuators/"+actuatorId+"/conf", actuatorInfo, ActuatorInfo.class);
        }
    }

    //Return list of registered Sensors for this Gateway (with current states and configurations)
	//GET Path :<host>/sensors
	public List<SensorInfo> getSensorListFromGateway(String gwIp) {
        SensorInfo[] response;
        if (gwIp != null ) {
            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.getForObject("http://" + gwIp + "/sensors", SensorInfo[].class);
            if (response != null){
                return Arrays.asList(response);
            }
        }
        return null;


	}

    //Get Sensor Info with current state and configuration
    //GET Path :<host>/sensors/{sensor_id}
    public SensorInfo getSensorInfoByIdFromGateway(int sensorId,String gwIp) {
        SensorInfo sensorInfo;
        if (gwIp != null && sensorId > 0) {
            RestTemplate restTemplate = new RestTemplate();
            sensorInfo = restTemplate.getForObject("http://" + gwIp + "/actuators/"+sensorId, SensorInfo.class, 200);
            return sensorInfo;
        }
        return null;
    }

    //Set new configuration for Sensor
    //POST <host>/sensors/{sensorId}/conf
    public void setSensorConfig(SensorInfo sensorInfo,int sensorId,String gwIp){
        if (gwIp != null && sensorInfo != null && sensorId > 0 ) {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject( "http://" + gwIp + "/actuators/"+sensorId+"/conf", sensorInfo, ActuatorInfo.class);
        }
    }
}
