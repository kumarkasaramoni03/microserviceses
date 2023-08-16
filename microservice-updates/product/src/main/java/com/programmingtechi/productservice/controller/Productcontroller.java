package com.programmingtechi.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programmingtechi.productservice.dto.ProductReesponse;
import com.programmingtechi.productservice.dto.Productrequest;
import com.programmingtechi.productservice.model.Product;
import com.programmingtechi.productservice.service.Productservice;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value="api/productservice")
public class Productcontroller {
	@Autowired
	private Productservice productservice;
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
	public void createproduct(@RequestBody Productrequest productrequest ) {
	productservice.createproduct(productrequest);
}

@GetMapping
@ResponseStatus(HttpStatus.OK)
public List<ProductReesponse> getallproduct(){
return	productservice.getall();
	
}
}
