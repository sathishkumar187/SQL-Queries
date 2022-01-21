package com.sportsshop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sportsshop.model.Product;

public class ShopServiceImplementation implements ShopServices {
	private static final Map<String, List<Product>> SPORTS_KITS = new HashMap<>();
	private static final List<Product> SPORTS_PRODUCTS = new ArrayList<>();
	
	public Map<String, List<Product>> addProduct(String productBrand, Product product) {
		
		if (!SPORTS_KITS.containsKey(productBrand)) {
			SPORTS_PRODUCTS.add(product);
			SPORTS_KITS.put(productBrand, SPORTS_PRODUCTS);
		}else
		{
			SPORTS_PRODUCTS.add(product);
		}
		return SPORTS_KITS;
	}

	public Product selectProduct(String brand, String name, char size) {
		final Iterator<String> productBrand = SPORTS_KITS.keySet().iterator();
		Product product = new Product();
		boolean isProductFound = false;
		
		while (productBrand.hasNext()) {
			String brandName = productBrand.next();
			if (brandName.equals(brand)) {
				List<Product> products = SPORTS_KITS.get(brandName);
				for (Product productDetails : products) {
					product = productDetails;
					
					if (product.getName().equals(name) && product.getSize() == size) {
						isProductFound = true;
						break;
					}
				}
			}
		}
		
		if (!isProductFound) {
			System.out.println("Product not in crew");
		}
		return product;
	}

    public Map<String, List<Product>> updateProductPrice(String brand, String name, char size, double productPrice) {
    	Product product = selectProduct(brand, name, size);
    	int index = SPORTS_PRODUCTS.indexOf(product); 
    	
    	product.setPrice(productPrice);
    	SPORTS_PRODUCTS.set(index, product);
    	SPORTS_KITS.replace(brand, SPORTS_PRODUCTS);
		return SPORTS_KITS;
	}

	public Map<String, List<Product>> removeProduct(String brand, String name, char size) {
		Product product = selectProduct(brand, name, size);
		int index = SPORTS_PRODUCTS.indexOf(product);  
		
		SPORTS_PRODUCTS.remove(index);
		SPORTS_KITS.replace(brand, SPORTS_PRODUCTS);
		return SPORTS_KITS;
	}
}
