package com.skyler.smarthome.server.scheduling;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Timer;

@Component
public class TimerTaskExecutor {
	
	final static Logger logger = Logger.getLogger(TimerTaskExecutor.class);
	
	Timer timer;
	
	public TimerTaskExecutor() {
	
		timer = new Timer(true);
		
	}
}
