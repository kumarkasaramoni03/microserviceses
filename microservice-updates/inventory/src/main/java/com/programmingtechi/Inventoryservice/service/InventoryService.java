package com.programmingtechi.Inventoryservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.programmingtechi.Inventoryservice.dto.InventoryResponse;
import com.programmingtechi.Inventoryservice.dto.Inventorydto;
import com.programmingtechi.Inventoryservice.dto.Inventoryrequest;



@Service
public interface InventoryService {

	public List<InventoryResponse> isInstock(List<String> skucode);
	public void placeinventory(Inventorydto inventorydto);
}
