package com.skyler.smarthome.server.beanpostprocessor;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

	final static Logger logger = Logger.getLogger(InstantiationTracingBeanPostProcessor.class);

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (logger.isDebugEnabled()) {
			logger.debug("Bean '" + beanName + "' created : " + bean.toString());
		}
		return bean;
	}
}
