package com.skyler.smarthome.server.data;

import java.util.List;

import com.skyler.smarthome.server.enums.ModuleStatus;
import com.skyler.smarthome.server.model.Module;

public interface ModuleDao {

	public List<Module> getAllModules();

	public Module getModuleById(int id);

	public List<Module> getModuleByStatus(ModuleStatus status);

	public boolean addModuleToGateway(int gateway, Module module);

	public boolean addModuleListToGateway(int gateway, List<Module> moduleList);

	public boolean setModuleStatus(int moduleId,ModuleStatus status);
}
