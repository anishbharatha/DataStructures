package com.area55.bluesea.bluesea;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

	@RequestMapping("/")
	public String handleIndex(){
		return "Yay! I am Index and I am 200";
	}
	
	@RequestMapping("/ping")
	public String handlePing(){
		return "Ping received. I am 200";
	}
	
	@RequestMapping("/hello")
	public String handleHello(){
		return "Hello back";
	}
}
