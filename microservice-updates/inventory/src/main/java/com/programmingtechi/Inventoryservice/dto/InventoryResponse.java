package com.programmingtechi.Inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
private String skucode;
private boolean isInstock;
}