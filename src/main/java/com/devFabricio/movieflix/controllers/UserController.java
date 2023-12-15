package com.devFabricio.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devFabricio.movieflix.dto.UserDTO;
import com.devFabricio.movieflix.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/profile")
	public ResponseEntity<UserDTO> getProfile() {
		UserDTO userDTO = userService.getProfile();
		return ResponseEntity.ok(userDTO);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
		UserDTO userDTO = userService.findById(userId);
		return ResponseEntity.ok(userDTO);
	}

	@GetMapping("/authenticated")
	public ResponseEntity<UserDTO> getAuthenticatedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		UserDTO userDTO = userService.getProfile(username);
		return ResponseEntity.ok(userDTO);
	}
}
