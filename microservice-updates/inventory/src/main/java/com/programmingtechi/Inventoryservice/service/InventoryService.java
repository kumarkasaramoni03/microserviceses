package com.programmingtechi.Inventoryservice.service;

import org.springframework.stereotype.Service;

import com.programmingtechi.Inventoryservice.dto.Inventorydto;
import com.programmingtechi.Inventoryservice.dto.Inventoryrequest;



@Service
public interface InventoryService {

	boolean isInstock(String skucode);
	public void placeinventory(Inventorydto inventorydto);
}
