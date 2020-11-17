package com.hungerbox.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hungerbox.app.dto.UserDto;
import com.hungerbox.app.exception.UserNotFoundException;
import com.hungerbox.app.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/adduser/{userId}")
	public ResponseEntity<String> addUser(@Valid @RequestBody UserDto userDto) {
		LOGGER.info("addUser.................");
		String message = userService.addUser(userDto);
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable("userId") Integer userId) throws UserNotFoundException {
		LOGGER.info("addUser.................");
		return new ResponseEntity<UserDto>(userService.getUser(userId),HttpStatus.OK);
	}

}
