package com.skyler.smarthome.server.data;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skyler.smarthome.server.enums.ModuleStatus;
import com.skyler.smarthome.server.model.Gateway;
import com.skyler.smarthome.server.model.Module;
import com.skyler.smarthome.server.service.ModuleService;

@Repository
public class ModuleDaoImpl implements ModuleDao {

	final static Logger logger = Logger.getLogger(ModuleDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Module getModuleById(int id) {
		Session session = sessionFactory.openSession();
		Module module = (Module) session.get(Module.class, id);
		return module;
	}

	@Override
	public List<Module> getAllModules() {
		Session session = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			List<Module> moduleList = session.createQuery("from Module").list();
			return moduleList;
		} catch (HibernateException e) {

		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> getModuleByStatus(ModuleStatus status) {

		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Module where s_module_stat = :status ");
			query = ModuleService.setModuleStatusForQuery(query, status);
			List<Module> list = query.list();
			return list;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public boolean addModuleToGateway(int gatewayId, Module module) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Gateway gateway = (Gateway) session.get(Gateway.class, gatewayId);
			gateway.getModuleList().add(module);
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
	public boolean addModuleListToGateway(int gatewayId, List<Module> moduleList) {
		Session session = sessionFactory.openSession();
		try {
			Gateway gateway = (Gateway) session.get(Gateway.class, gatewayId);
			Iterator<Module> iterator = moduleList.iterator();
			while (iterator.hasNext()) {
				gateway.getModuleList().add(iterator.next());
				session.save(gateway);
			}
		} catch (HibernateException e) {

		} finally {
			session.close();
		}
		return false;

	}

	@Override
	public boolean setModuleStatus(int moduleId, ModuleStatus status) {
		Session session = sessionFactory.openSession();
		try {
			Module module = (Module) session.get(Module.class, status);
			module.setModuleStatus(status);
			session.merge(module);
			return true;
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return false;
	}
}
