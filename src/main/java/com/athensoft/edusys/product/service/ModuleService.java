package com.athensoft.edusys.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.athensoft.edusys.product.dao.ModuleRepository;

@Service
public class ModuleService {
	private final ModuleRepository moduleRepo;
	
	public ModuleService(ModuleRepository moduleRepo) {
		this.moduleRepo = moduleRepo;
	}
	
	

}
