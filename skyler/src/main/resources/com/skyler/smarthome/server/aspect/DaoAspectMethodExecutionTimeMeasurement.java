package com.skyler.smarthome.server.aspect;

import com.skyler.smarthome.server.data.GatewayDao;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * The <code>DaoAspectMethodExecutionTimeMeasurement</code> class contains
 * methods, which provide ability to measure time of all DAO methods.
 * 
 * @author Oleksandr Marchenko
 * @version  %I%, %G%
 */

@Aspect
@Component
final public class DaoAspectMethodExecutionTimeMeasurement {
	
	final static Logger logger = Logger.getLogger(GatewayDao.class);

	long startTime = 0L;
	long elapsedTime = 0L;

	/**
	 * Separated methods used, because DAO methods does not return value to
	 * controller if used @Around annotation.
	 * 
	 * @param joinPoint
	 */
	@Before("execution(* com.skyler.smarthome.server.data..*(..))")
	public void timeMeasurementBefore(JoinPoint joinPoint) {
		startTime = System.currentTimeMillis();
	}

	@After("execution(* com.skyler.smarthome.server.data..*(..))")
	public void timeMeasurementAfter(JoinPoint joinPoint) {
		elapsedTime = System.currentTimeMillis() - startTime;
		if (logger.isDebugEnabled()) {
			logger.debug("Execute: " + joinPoint.getSignature() + ", Time elapsed: " + elapsedTime + " Millis");
		}
	}
}
