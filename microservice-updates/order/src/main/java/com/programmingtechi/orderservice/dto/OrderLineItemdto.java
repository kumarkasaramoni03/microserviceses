package com.programmingtechi.orderservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemdto {
	private Long id;
	private String skucode;
	private BigDecimal price;
	private Integer quantity;
}
