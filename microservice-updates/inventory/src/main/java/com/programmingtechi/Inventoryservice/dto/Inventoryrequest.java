package com.programmingtechi.Inventoryservice.dto;

import java.util.List;

import com.programmingtechi.Inventoryservice.model.Inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventoryrequest {
	List<Inventory> inventories;
}
