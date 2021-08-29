package com.athensoft.tacedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/index")
	public String gotoIndexCoporate() {
		return "index-corporate";
	}
}
