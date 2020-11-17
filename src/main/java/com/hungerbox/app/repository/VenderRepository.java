package com.hungerbox.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hungerbox.app.dto.VenderResponseDto;
import com.hungerbox.app.entity.Vender;

@Repository
public interface VenderRepository extends JpaRepository<Vender, Integer> {

	Vender findByvenderName(String venderName);
}
