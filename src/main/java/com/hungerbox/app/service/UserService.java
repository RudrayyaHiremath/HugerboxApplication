package com.hungerbox.app.service;

import com.hungerbox.app.dto.UserDto;
import com.hungerbox.app.exception.UserNotFoundException;

public interface UserService {

	String addUser(UserDto userDto);

	UserDto getUser(Integer userId) throws UserNotFoundException;

}
