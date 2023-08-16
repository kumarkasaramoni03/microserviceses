package com.programmingtechi.Inventoryservice.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programmingtechi.Inventoryservice.dto.Inventorydto;
import com.programmingtechi.Inventoryservice.dto.Inventoryrequest;
import com.programmingtechi.Inventoryservice.model.Inventory;
import com.programmingtechi.Inventoryservice.repository.Inventoryrepository;
import com.programmingtechi.Inventoryservice.service.InventoryService;


import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{
	@Autowired
	private Inventoryrepository inventoryrepository;

	@Override
	@Transactional(readOnly=true)
	public boolean isInstock(String skucode) {

		return inventoryrepository.findBySkuCode(skucode).isPresent();
	}

	@Override
	public void placeinventory(Inventorydto inventorydto) {
		
			Inventory inventory=new Inventory();
			inventory.setQuantity(inventorydto.getQuantity());;
			inventory.setSkuCode(inventorydto.getSkuCode());

inventoryrepository.save(inventory);
		
		}
//	private Inventory maptoDto(Inventorydto inventorydto) {
//		Inventory inventory=new Inventory();
//		inventory.setQuantity(inventorydto.getQuantity());;
//		inventory.setSkuCode(inventorydto.getSkuCode());
//		return inventory;
//	}

}
