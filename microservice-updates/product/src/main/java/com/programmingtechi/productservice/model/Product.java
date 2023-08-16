package com.programmingtechi.productservice.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

	import lombok.AllArgsConstructor;
	import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document(value="productservice")
public class Product {
	
@Id
private String id;
private String name;
private String discription;
private BigDecimal price;

}
