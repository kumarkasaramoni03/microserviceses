package com.programmingtechi.orderservice.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.programmingtechi.orderservice.dto.InventoryResponse;
import com.programmingtechi.orderservice.dto.OrderLineItemdto;
import com.programmingtechi.orderservice.dto.OrderRequest;
import com.programmingtechi.orderservice.model.Order;
import com.programmingtechi.orderservice.model.OrderLineItem;
import com.programmingtechi.orderservice.model.OrderResponse;
import com.programmingtechi.orderservice.repository.OrderRepository;
import com.programmingtechi.orderservice.service.Orderservice;

@Service
@Transactional()
public class OrderserviceImpl implements Orderservice {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private WebClient.Builder client;

	@Override
	public void placeorder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrederNumber(UUID.randomUUID().toString());
		List<OrderLineItem> lineItem = orderRequest.getItemdtos().stream().map(this::maptoDto).toList();
		order.setOrderLineItem(lineItem);


		List<String> result = order.getOrderLineItem().stream().map(OrderLineItem::getSkucode).toList();
		// call inventory service and place order if product is stock
		InventoryResponse[] inventoryResponseArray = client.build().get()
				.uri("http://inventory-service/api/inventory/getall",
						UriBuilder -> UriBuilder.queryParam("skucode", result).build())
				.retrieve().bodyToMono(InventoryResponse[].class).block();
	boolean boolean1=	Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInstock);
		if (boolean1) {
			orderRepository.save(order);
		} else {
			throw new IllegalArgumentException("product is not in stock,please try again later");
		}

		
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
