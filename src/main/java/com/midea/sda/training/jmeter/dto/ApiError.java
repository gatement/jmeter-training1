package com.midea.sda.training.jmeter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError {
	public static ApiError LOGIN_FAIL = new ApiError(1000, "wrong username and password.");
	public static ApiError INVALID_TOKEN = new ApiError(1001, "invalid token.");

	public Integer code;
	public String msg;
}
