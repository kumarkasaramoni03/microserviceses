package com.programmingtechi.Inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programmingtechi.Inventoryservice.dto.InventoryResponse;
import com.programmingtechi.Inventoryservice.dto.Inventorydto;
import com.programmingtechi.Inventoryservice.service.InventoryService;


@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;
	

//@PathVariable:http://localhost:8082/api/inventory/skucode/Iphone13,Iphone13red
//	@GetMapping("/skucode/{skucode}")
//	public boolean isInstock(@PathVariable(name="skucode") String skucode) {
//		return inventoryService.isInstock(skucode);
//	}

	//@RequestParam: http://localhost:8082/api/inventory?skucode=Iphone13&skucode=Iphone13red
	@GetMapping("/getall")
	public List<InventoryResponse> isInstock(@RequestParam List<String> skucode) {

		return inventoryService.isInstock(skucode);
	}

	@PostMapping("/creaated")
	public String placeinventory(@RequestBody Inventorydto inventorydto) {
		inventoryService.placeinventory(inventorydto);
		return " successfully added product in inventory";
}
}