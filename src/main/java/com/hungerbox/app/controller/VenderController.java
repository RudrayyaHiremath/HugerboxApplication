package com.hungerbox.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hungerbox.app.dto.VenderRequestDto;
import com.hungerbox.app.dto.VenderResponseDto;
import com.hungerbox.app.exception.VenderNotFoundException;
import com.hungerbox.app.service.VenderService;

@RestController
public class VenderController {

	@Autowired
	VenderService venderService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VenderController.class);
	
	@PostMapping("/vender")
	public ResponseEntity<String> addVender(@RequestBody VenderRequestDto venderRequestDto) {
		LOGGER.info("addVender.................");
		String message = venderService.addVender(venderRequestDto);
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/vender/{venderId}")
	public ResponseEntity<VenderResponseDto> getVender(@PathVariable("venderId") Integer venderId) throws VenderNotFoundException {
		LOGGER.info("getVender................");
		return new ResponseEntity<VenderResponseDto>(venderService.getVender(venderId),HttpStatus.OK);
	}
	
	
	@GetMapping("/venderByName")
	public ResponseEntity<VenderResponseDto> getVenderByname(@RequestParam("venderName") String venderName) throws VenderNotFoundException {
		LOGGER.info("getVenderByname................");
		return new ResponseEntity<VenderResponseDto>(venderService.getVenderByName(venderName),HttpStatus.OK);
	}

}
