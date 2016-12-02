package com.skyler.smarthome.server.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.skyler.smarthome.server.data.GatewayDao;

@Aspect
@Component
public class DaoAspectLogging {

	final static Logger logger = Logger.getLogger(GatewayDao.class);

	@Before("execution(* com.skyler.smarthome.server.data..*(..))")
	public void logBefore(JoinPoint joinPoint) throws Throwable {
		if(logger.isDebugEnabled()){
			logger.debug("Execute: " + joinPoint.getSignature());
		}
		
	}
}
