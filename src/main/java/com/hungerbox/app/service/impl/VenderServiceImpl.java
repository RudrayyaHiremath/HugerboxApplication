package com.hungerbox.app.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungerbox.app.dto.VenderRequestDto;
import com.hungerbox.app.dto.VenderResponseDto;
import com.hungerbox.app.entity.Vender;
import com.hungerbox.app.exception.VenderNotFoundException;
import com.hungerbox.app.repository.VenderRepository;
import com.hungerbox.app.service.VenderService;

@Service
public class VenderServiceImpl implements VenderService {

	@Autowired
	VenderRepository venderRepository;

	@Override
	public String addVender(VenderRequestDto venderRequestDto) {
		System.out.println("venderRequestDto::" + venderRequestDto);
		Vender newVender = new Vender();
		BeanUtils.copyProperties(venderRequestDto, newVender);
		System.out.println("newVender::" + newVender);

		Vender savedVender = venderRepository.save(newVender);

		Optional<Vender> userUpdated = venderRepository.findById(savedVender.getVenderId());

		String message = null;
		if (userUpdated.isPresent()) {
			message = "Vender Saved Successfully.";
		} else {
			message = "Vender Not Saved .";
		}
		return message;

	}

	@Override
	public VenderResponseDto getVender(Integer venderId) throws VenderNotFoundException {
		if (venderRepository.findById(venderId).isPresent()) {
			VenderResponseDto VenderResponseDto = new VenderResponseDto();
			Vender vender = venderRepository.findById(venderId).get();
			BeanUtils.copyProperties(vender, VenderResponseDto);
			return VenderResponseDto;

		} else {
			throw new VenderNotFoundException("Id Not Found");
		}
	}

	@Override
	public VenderResponseDto getVenderByName(String venderName) throws VenderNotFoundException {
		System.out.println("getVenderByName.................");
		VenderResponseDto venderResponseDto = new VenderResponseDto();
		Vender vender = venderRepository.findByvenderName(venderName);
		BeanUtils.copyProperties(vender, venderResponseDto);
		System.out.println("venderResponseDto:::"+venderResponseDto);
		return venderResponseDto;

	}

}
