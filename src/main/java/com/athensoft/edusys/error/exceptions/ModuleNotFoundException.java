package com.athensoft.edusys.error.exceptions;

public class ModuleNotFoundException extends NotFoundException{

	public ModuleNotFoundException(String message) {
		super(message);
	}
	
	public ModuleNotFoundException(Integer moduleId) {
		super("Module " + moduleId + " is not found!");
	}

}
