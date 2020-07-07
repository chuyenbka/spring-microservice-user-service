package com.chuyenpn.usersevice.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuyenpn.usersevice.dto.ResponseDTO;
import com.chuyenpn.usersevice.dto.User;
import com.chuyenpn.usersevice.dto.UsernameConfig;

@RefreshScope
@RestController
public class DemoConfig {
	
	@Autowired
	Environment enviroment;
	
	@GetMapping("/config")
	public UsernameConfig getConfigFromServerConfig() {
		try {
			return new UsernameConfig(
					Integer.parseInt(enviroment.getProperty("user.username.minLength")),
					Integer.parseInt(enviroment.getProperty("user.username.maxLength")));
		} catch (Exception e) {
			System.out.println("Could not connect to server config");
			return new UsernameConfig();
		}
		
	}
	
	@GetMapping("/users")
	public ResponseDTO getAllUsers() {
		return new ResponseDTO(enviroment.getProperty("server.port"), 
				Arrays.asList(new User("chuyenpn", "12345678")));
	}
}
