package com.byaoh.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author luliangyu
 * @date 2021-06-30 15:52
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@GetMapping("/getCurrentUser")
	public Object getCurrentUser(Authentication authentication) {
		return authentication;
	}
}
