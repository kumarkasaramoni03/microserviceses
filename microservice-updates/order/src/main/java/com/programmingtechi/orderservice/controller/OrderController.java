package com.programmingtechi.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programmingtechi.orderservice.dto.OrderRequest;
import com.programmingtechi.orderservice.model.OrderResponse;
import com.programmingtechi.orderservice.service.Orderservice;

@RestController
@RequestMapping("api/orderservice")
public class OrderController {
	@Autowired
	private Orderservice orderservice;
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String placeorder(@RequestBody OrderRequest orderRequest) {
		orderservice.placeorder(orderRequest);
		return "order placed successfully";
		
	}
@GetMapping
@ResponseStatus(HttpStatus.OK)
public List<OrderResponse> getallOedrs(){
	return orderservice.getall();
	
}
}
