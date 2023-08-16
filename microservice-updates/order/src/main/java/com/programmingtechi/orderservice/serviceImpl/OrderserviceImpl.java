package com.programmingtechi.orderservice.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programmingtechi.orderservice.dto.OrderLineItemdto;
import com.programmingtechi.orderservice.dto.OrderRequest;
import com.programmingtechi.orderservice.model.Order;
import com.programmingtechi.orderservice.model.OrderLineItem;
import com.programmingtechi.orderservice.model.OrderResponse;
import com.programmingtechi.orderservice.repository.OrderRepository;
import com.programmingtechi.orderservice.service.Orderservice;
@Service
@Transactional()
public class OrderserviceImpl implements Orderservice{
	@Autowired
private OrderRepository orderRepository;
	@Override
	public void placeorder(OrderRequest orderRequest) {
		Order order=new Order();
		order.setOrederNumber(UUID.randomUUID().toString());
		List<OrderLineItem> lineItem=orderRequest.getItemdtos()
				.stream().map(this::maptoDto).toList();
		order.setOrderLineItem(lineItem);
		orderRepository.save(order);
	}
private OrderLineItem maptoDto(OrderLineItemdto itemdto) {
	OrderLineItem item=new OrderLineItem();
	item.setId(itemdto.getId());
	item.setPrice(itemdto.getPrice());
	item.setQuantity(itemdto.getQuantity());
	item.setSkucode(itemdto.getSkucode());
	return item;
	
}
@Override
public List<OrderResponse> getall() {
	List<Order> items=orderRepository.findAll();
	return items.stream().map(this::mapTOOrderresponse).toList();
}

private OrderResponse mapTOOrderresponse(Order order) {
	OrderResponse orderResponse = new OrderResponse();
	orderResponse.setId(order.getId());
	orderResponse.setOrderLineItem(order.getOrderLineItem());
	return orderResponse;
}

}
