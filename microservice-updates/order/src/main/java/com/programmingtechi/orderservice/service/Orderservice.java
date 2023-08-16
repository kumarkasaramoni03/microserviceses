package com.programmingtechi.orderservice.service;

import java.util.List;

import com.programmingtechi.orderservice.dto.OrderRequest;
import com.programmingtechi.orderservice.model.OrderResponse;

public interface Orderservice {
	public void placeorder(OrderRequest orderRequest);

	public List<OrderResponse> getall();

}
