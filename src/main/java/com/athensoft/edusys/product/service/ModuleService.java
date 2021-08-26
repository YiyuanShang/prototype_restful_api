package com.athensoft.edusys.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.athensoft.edusys.error.exceptions.ModuleNotFoundException;
import com.athensoft.edusys.product.dao.ModuleRepository;
import com.athensoft.edusys.product.entity.Module;

@Service
public class ModuleService {
	private final ModuleRepository moduleRepo;
	
	public ModuleService(ModuleRepository moduleRepo) {
		this.moduleRepo = moduleRepo;
	}
	
	public Module getModuleById(Integer moduleId) {
		return moduleRepo.findById(moduleId).orElseThrow(() -> new ModuleNotFoundException(moduleId));
	}
	

}
