package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.PaymentOrder;

public interface PaymentRepo extends JpaRepository<PaymentOrder,Long>{
	
	PaymentOrder findByOrderId(String orderId);

		
}