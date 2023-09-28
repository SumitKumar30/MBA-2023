package org.ncu.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product_main")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@Column(nullable = false, unique = true)
	private String productName;
	
	@Column(nullable = false, unique = false)
	private double productPrice;
	
	@Column(length = 50, unique = false, nullable = true)
	private String productDescription;
	
	@Column(nullable = true, unique = true)
	private String productUrl;
	
	@Column(nullable = false)
	private boolean productAvailability;
	
	
}
