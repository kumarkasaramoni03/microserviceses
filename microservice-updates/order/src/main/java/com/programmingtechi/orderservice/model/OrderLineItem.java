package com.programmingtechi.orderservice.model;

import java.math.BigDecimal;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="OrderLineItem_t")
@NoArgsConstructor
@Getter
@Setter
public class OrderLineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String skucode;
	private BigDecimal price;
	private Integer quantity;

}
