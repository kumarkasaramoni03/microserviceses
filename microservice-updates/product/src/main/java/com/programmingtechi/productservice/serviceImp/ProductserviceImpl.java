package com.programmingtechi.productservice.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.sym.Name;
import com.mongodb.connection.Stream;
import com.programmingtechi.productservice.dto.ProductReesponse;
import com.programmingtechi.productservice.dto.Productrequest;
import com.programmingtechi.productservice.model.Product;
import com.programmingtechi.productservice.repository.ProductRepository;
import com.programmingtechi.productservice.service.Productservice;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductserviceImpl implements Productservice {
@Autowired
private ProductRepository productRepository;

@Override
public void createproduct(Productrequest productrequest) {
	
	Product product=Product.builder()
		.id(productrequest.getId())
			.name(productrequest.getName())
			.discription(productrequest.getDiscription())
			.price(productrequest.getPrice())
			.build();
	productRepository.save(product);
	log.info("Product {} is created",product.getId());
	
}

@Override
public List<ProductReesponse> getall() {
	List<Product> product=productRepository.findAll();
	return product.stream().map(this::mapTOproductresponse).toList();
}
private ProductReesponse mapTOproductresponse(Product product) {
	return ProductReesponse.builder()
			.id(product.getId())
			.name(product.getName())
			.discription(product.getDiscription())
			.price(product.getPrice())
			.build();

}
}