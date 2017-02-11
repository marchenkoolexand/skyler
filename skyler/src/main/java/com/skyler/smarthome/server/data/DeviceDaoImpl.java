package com.skyler.smarthome.server.data;

import com.skyler.smarthome.server.model.Device;
import com.skyler.smarthome.server.model.Gateway;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository("deviceDAO")
public class DeviceDaoImpl implements  DeviceDao{

    final static Logger logger = Logger.getLogger(DeviceDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Device> getAllDevices() {
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().setTimeout(10);
            session.getTransaction().begin();
            List<Device> deviceList = session.createQuery("from Device").list();
            session.getTransaction().commit();
            return deviceList;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    public List<Device> getAllDevicesFromGateway(int gwId){
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().setTimeout(10);
            session.getTransaction().begin();
            Gateway gateway = (Gateway) session.get(Gateway.class, gwId);
            session.getTransaction().commit();
            return gateway.getDeviceList();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;

    }

    @Override
    public Device getDeviceById(int id) {
        Session session = sessionFactory.openSession();
        Device device = (Device) session.get(Device.class, id);
        return device;
    }

    @Override
    public boolean addDeviceToGateway(int gatewayId, Device device) {
        Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Gateway gateway = (Gateway) session.get(Gateway.class, gatewayId);
			gateway.getDeviceList().add(device);
			session.save(gateway);
		} catch (HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			tx.commit();
			session.close();
		}
		return false;
    }

    @Override
    public boolean addDeviceListToGateway(int gatewayId, List<Device> devicesList) {
        Session session = sessionFactory.openSession();
		try {
			Gateway gateway = (Gateway) session.get(Gateway.class, gatewayId);
			Iterator<Device> iterator = devicesList.iterator();
			while (iterator.hasNext()) {
				gateway.getDeviceList().add(iterator.next());
				session.save(gateway);
			}
		} catch (HibernateException e) {

		} finally {
			session.close();
		}
		return false;
    }
}
