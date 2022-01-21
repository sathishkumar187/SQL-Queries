package com.sportsshop.view;

import com.sportsshop.controller.ShopKeeper;

public class Customer extends SportsShop {
	void selectAnyProduct() {
		String brand;
		String name;
		char   size;
		
		System.out.println("Mention Product Brand(SS, SG, MRF, RBK, NIKE)");
		brand = Validations.validateBrand(SCANNER.next());
		
		System.out.println("Mention Product Name(Bat, Ball, Stump, Gloves, Helmet)");
		name = Validations.validateName(SCANNER.next());
		
		System.out.println("Mention Product Size(S, M, L)");
		size = Validations.validateSize(SCANNER.next());
		
		ShopKeeper.selectProduct(brand, name, size);	
	}
}
