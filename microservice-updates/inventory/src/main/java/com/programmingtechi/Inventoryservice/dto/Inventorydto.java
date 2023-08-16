package com.programmingtechi.Inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventorydto {
	private String skuCode;
	private Integer quantity;
}
