package com.athensoft.tacedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalController {
	@GetMapping("/")
	public String gotoIndex() {
		return "coming-soon";
	}
	
	@GetMapping("/home")
	public String gotoHome() {
		return "homepage";
	}
	
	@GetMapping("/about")
	public String gotoAbout() {
		return "about-us";
	}
	
	@GetMapping("/contact")
	public String gotoContact() {
		return "contact";
	}
	
	@GetMapping("/team")
	public String gotoTeam() {
		return "team";
	}
	
	@GetMapping("/teammember")
	public String gotoTeamMember() {
		return "teammember";
	}
	
	@GetMapping("/career")
	public String gotoCareer() {
		return "career";
	}
	
	@GetMapping("/business")
	public String gotoBusiness() {
		return "business";
	}
	
	@GetMapping("/maintenance")
	public String gotoMaintenance() {
		return "maintenance";
	}
}
