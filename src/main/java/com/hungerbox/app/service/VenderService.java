package com.hungerbox.app.service;

import com.hungerbox.app.dto.VenderRequestDto;
import com.hungerbox.app.dto.VenderResponseDto;
import com.hungerbox.app.exception.VenderNotFoundException;

public interface VenderService {

	String addVender(VenderRequestDto VenderRequestDto);
	
	VenderResponseDto getVender(Integer VenderId) throws VenderNotFoundException;
	
	VenderResponseDto getVenderByName(String venderName) throws VenderNotFoundException;
}
