package com.chuyenpn.usersevice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsernameConfig {
	private int minLength;
	private int maxLength;
}
