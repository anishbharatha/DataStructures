package com.area55.bluesea.bluesea;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

	@RequestMapping("/ping")
	public String handlePing(){
		return "Yay! I am 200";
	}
}
