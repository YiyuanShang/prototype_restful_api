package com.athensoft.edusys.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {
	@GetMapping("/edusys/test")
	public String gotoTestPost() {
		System.out.println("entering gotoTestPost");
		return "test_post";
	}
}
