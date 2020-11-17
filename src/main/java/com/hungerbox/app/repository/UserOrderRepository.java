package com.hungerbox.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hungerbox.app.dto.UserOrderResponseDto;
import com.hungerbox.app.entity.UserOrder;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Integer>{
	
	@Query(value = "SELECT * FROM hungerbox.user_orders where user_id = :userId order by order_date ASC limit 2", nativeQuery = true)
	List<UserOrder> serchUserOrderByUserId(@Param("userId") Integer userId);
}
