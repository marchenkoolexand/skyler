package com.skyler.smarthome.server.timer;

import java.util.Timer;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class TimerTaskExecutor {
	
	final static Logger logger = Logger.getLogger(TimerTaskExecutor.class);
	
	Timer timer;
	
	public TimerTaskExecutor() {
	
		timer = new Timer(true);
		
	}
}
