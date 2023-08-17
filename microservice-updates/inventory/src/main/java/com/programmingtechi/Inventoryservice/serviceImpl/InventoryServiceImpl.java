package com.programmingtechi.Inventoryservice.serviceImpl;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programmingtechi.Inventoryservice.dto.InventoryResponse;
import com.programmingtechi.Inventoryservice.dto.Inventorydto;
import com.programmingtechi.Inventoryservice.dto.Inventoryrequest;
import com.programmingtechi.Inventoryservice.model.Inventory;
import com.programmingtechi.Inventoryservice.repository.Inventoryrepository;
import com.programmingtechi.Inventoryservice.service.InventoryService;


import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
@Transactional
public class InventoryServiceImpl implements InventoryService{
	@Autowired
	private Inventoryrepository inventoryrepository;

	@Override
	public void placeinventory(Inventorydto inventorydto) {
		
			Inventory inventory=new Inventory();
			inventory.setQuantity(inventorydto.getQuantity());;
			inventory.setSkuCode(inventorydto.getSkuCode());

inventoryrepository.save(inventory);
		
		}

	@Override
	public List<InventoryResponse> isInstock(List<String> skucode) {
		// TODO Auto-generated method stub
		return inventoryrepository.findBySkuCodeIn(skucode).stream()
				.map(inventory->InventoryResponse.builder()
						.skucode(inventory.getSkuCode())
						.isInstock(inventory.getQuantity()>0)
						.build()).toList();
	}


//	private Inventory maptoDto(Inventorydto inventorydto) {
//		Inventory inventory=new Inventory();
//		inventory.setQuantity(inventorydto.getQuantity());;
//		inventory.setSkuCode(inventorydto.getSkuCode());
//		return inventory;
//	}

}
