package com.xoriant.bank.poc.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-service",url="http://localhost:8084/api/filter")
public interface UserFient {
	
	@GetMapping("/changePassword/{email}/{mobileno}/{password}")
	public String changePassword(@PathVariable String email,@PathVariable Long mobileno,@PathVariable String password);

}
