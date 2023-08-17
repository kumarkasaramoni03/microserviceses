package com.programmingtechi.Inventoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmingtechi.Inventoryservice.dto.Inventorydto;
import com.programmingtechi.Inventoryservice.dto.Inventoryrequest;
import com.programmingtechi.Inventoryservice.service.InventoryService;


@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/skucode/{skucode}")
	public boolean isInstock(@PathVariable(name="skucode") String skucode) {
		return inventoryService.isInstock(skucode);
	}

	@PostMapping("/creaated")
	public String placeinventory(@RequestBody Inventorydto inventorydto) {
		inventoryService.placeinventory(inventorydto);
		return "order placed successfully";
}
}