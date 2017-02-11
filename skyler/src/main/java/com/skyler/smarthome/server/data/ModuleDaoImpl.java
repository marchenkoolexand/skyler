package com.skyler.smarthome.server.data;

import com.skyler.smarthome.server.model.*;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public class ModuleDaoImpl implements ModuleDao {

	final static Logger logger = Logger.getLogger(ModuleDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Module> getAllModules() {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().setTimeout(10);
			session.getTransaction().begin();
			List<Module> moduleList = session.createQuery("from com.skyler.smarthome.server.model.Module").list();
			session.getTransaction().commit();
			return moduleList;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Sensor> getAllSensor() {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().setTimeout(10);
			session.getTransaction().begin();
			List<Sensor> sensorList = session.createQuery("from Sensor").list();
			session.getTransaction().commit();
			return sensorList;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Actuator> getAllActuator() {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().setTimeout(10);
			session.getTransaction().begin();
			List<Actuator> actuatorList = session.createQuery("from Actuator").list();
			session.getTransaction().commit();
			return actuatorList;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Sensor getSensorById(int sensorId) {
		Session session = sessionFactory.openSession();
		Sensor sensor = (Sensor) session.get(Sensor.class, sensorId);
		return sensor;
	}

	@Override
	public Actuator getActuatorById(int actuatorId) {
		Session session = sessionFactory.openSession();
		Actuator actuator = (Actuator) session.get(Sensor.class, actuatorId);
		return actuator;
	}

	@Override
	public boolean addModuleToDevice(int gatewayId,int deviceId, Module module) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			tx.setTimeout(10);
			tx.begin();
			Gateway gateway = (Gateway) session.get(Gateway.class, gatewayId);
			List<Device> deviceList = gateway.getDeviceList();
			Iterator<Device> deviceIterator = deviceList.iterator();
			while (deviceIterator.hasNext()){
				Device device = deviceIterator.next();
				if(device.getId() == deviceId){
					device.addModuleToDevice(module);
				}
			}
			session.save(gateway);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean addSensorListToDevice(int gatewayId,int deviceId, List<Sensor> sensorList) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			tx.setTimeout(10);
			tx.begin();
			Gateway gateway = (Gateway) session.get(Gateway.class, gatewayId);
			List<Device> deviceList = gateway.getDeviceList();
			Iterator<Device> deviceIterator = deviceList.iterator();
			while (deviceIterator.hasNext()){
				Device device = deviceIterator.next();
				if(device.getId() == deviceId){
					device.addSensorListToDevice(sensorList);
				}
			}
			session.save(gateway);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean addActuatorListToDevice(int gatewayId,int deviceId, List<Actuator> actuatorList) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			tx.setTimeout(10);
			tx.begin();
			Gateway gateway = (Gateway) session.get(Gateway.class, gatewayId);
			List<Device> deviceList = gateway.getDeviceList();
			Iterator<Device> deviceIterator = deviceList.iterator();
			while (deviceIterator.hasNext()){
				Device device = deviceIterator.next();
				if(device.getId() == deviceId){
					device.addActuatorListToDevice(actuatorList);
				}
			}
			session.save(gateway);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			session.close();
		}
		return false;
	}
}
