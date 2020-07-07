package com.chuyenpn.usersevice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
	private String port;
	private List<User> users;
}
