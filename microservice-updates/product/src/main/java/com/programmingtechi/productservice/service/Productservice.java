package com.programmingtechi.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.programmingtechi.productservice.dto.ProductReesponse;
import com.programmingtechi.productservice.dto.Productrequest;

@Service
public  interface Productservice {
	
	public  void createproduct(Productrequest productrequest);
	
	public List<ProductReesponse> getall();

}
