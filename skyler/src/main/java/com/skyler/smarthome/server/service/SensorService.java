package com.skyler.smarthome.server.service;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.skyler.smarthome.server.enums.SensorStatus;

public class SensorService {

	final static Logger logger = Logger.getLogger(SensorService.class);
	
	public static Query setSensorStatusForQuery(Query query, SensorStatus status) {

		if (query != null) {
			switch (status) {
			case NEW:
				query.setParameter("status", "NEW");
				return query;
			case DELETED:
				query.setParameter("status", "DELETED");
				return query;
			case MISSING:
				query.setParameter("status", "MISSING");
				return query;
			case WORKING:
				query.setParameter("status", "WORKING");
				return query;
			default:
				break;
			}
		}
		return null;
	}

}
