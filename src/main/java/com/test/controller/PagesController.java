package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PagesController {
	
	@GetMapping("/home")
	@ResponseBody
	public String home(@RequestParam(required = false,defaultValue = "world!") String name) {
		return "hello "+name;
	}
}
