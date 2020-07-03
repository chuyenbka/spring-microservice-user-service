package com.chuyenpn.usersevice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuyenpn.usersevice.dto.UsernameConfig;

@RefreshScope
@RestController
public class DemoConfig {
	
	@Autowired
	Environment enviroment;
	
	@GetMapping("/config")
	public UsernameConfig getConfigFromServerConfig() {
		return new UsernameConfig(
				Integer.parseInt(enviroment.getProperty("user.username.minLength")),
				Integer.parseInt(enviroment.getProperty("user.username.maxLength")));
	}
}
