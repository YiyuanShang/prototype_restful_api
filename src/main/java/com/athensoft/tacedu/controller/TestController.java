package com.athensoft.tacedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TestController {
	
	@GetMapping({"/index", "/{lang}/index"})
	public String gotoIndexCoporate(@PathVariable(required=false) String lang) {
		return "index-corporate";
	}
}
