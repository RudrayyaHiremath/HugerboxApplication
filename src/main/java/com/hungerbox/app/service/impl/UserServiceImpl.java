package com.hungerbox.app.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungerbox.app.dto.UserDto;
import com.hungerbox.app.entity.User;
import com.hungerbox.app.exception.UserNotFoundException;
import com.hungerbox.app.repository.UserRepository;
import com.hungerbox.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public String addUser(UserDto userDto) {
		System.out.println("userDto:::" + userDto);
		User newUser = new User();
		BeanUtils.copyProperties(userDto, newUser);
		System.out.println("newUser:::" + newUser);
		User savedUser = userRepository.save(newUser);
		Optional<User> userUpdated = userRepository.findById(savedUser.getUserId());
		String message = null;
		if (userUpdated.isPresent()) {
			message = "User Saved Successfully.";
		} else {
			message = "User Not Saved .";
		}
		return message;

	}

	@Override
	public UserDto getUser(Integer userId) throws UserNotFoundException {
		if (userRepository.findById(userId).isPresent()) {
			UserDto userDto = new UserDto();
			User user = userRepository.findById(userId).get();
			BeanUtils.copyProperties(user, userDto);

			return userDto;

		} else {
			throw new UserNotFoundException("Id Not Found");
		}
	}

}
