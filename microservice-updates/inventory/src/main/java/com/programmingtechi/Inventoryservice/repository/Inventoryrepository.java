package com.programmingtechi.Inventoryservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programmingtechi.Inventoryservice.model.Inventory;
import java.util.List;

@Repository
public interface Inventoryrepository extends JpaRepository<Inventory, Long>{
	
 Optional<Inventory> findBySkuCode(String skuCode);
}
