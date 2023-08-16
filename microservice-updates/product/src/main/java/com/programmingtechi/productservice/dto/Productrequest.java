package com.programmingtechi.productservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Productrequest {
	private String id;
	private String name;
	private String discription;
	private BigDecimal price;
}
