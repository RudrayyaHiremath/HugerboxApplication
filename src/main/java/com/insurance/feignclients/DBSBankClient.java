package com.insurance.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hungerbox.app.dto.UserTransactionRequestDto;




@FeignClient(name = "http://DBSBANK-SERVICE/bank/bank")

public interface DBSBankClient {

	@PostMapping("/fundTransfer")
	public String fundTransfer(@RequestBody UserTransactionRequestDto transactionRequestDto);

}
