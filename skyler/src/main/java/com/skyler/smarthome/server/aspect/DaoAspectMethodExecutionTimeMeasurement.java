package com.skyler.smarthome.server.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.skyler.smarthome.server.data.GatewayDao;

@Aspect
@Component
public class DaoAspectMethodExecutionTimeMeasurement {
	final static Logger logger = Logger.getLogger(GatewayDao.class);

	long startTime = 0L;
	long elapsedTime = 0L;

	@Before("execution(* com.skyler.smarthome.server.data..*(..))")
	public void timeMeasurementBefore(JoinPoint joinPoint) {
		startTime = System.currentTimeMillis();
	}

	@After("execution(* com.skyler.smarthome.server.data..*(..))")
	public void timeMeasurementAfter(JoinPoint joinPoint) {
		elapsedTime = System.currentTimeMillis() - startTime;
		if (logger.isDebugEnabled()) {
			logger.debug("Execute: " + joinPoint.getSignature() + ", Time elapsed:" + elapsedTime + " Millis");
		}
	}
}
