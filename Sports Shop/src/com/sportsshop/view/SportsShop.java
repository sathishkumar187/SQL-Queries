package com.sportsshop.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sportsshop.controller.ShopKeeper;
import com.sportsshop.model.Product;

public class SportsShop {
	public static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		int operation;

		do {
			System.out.println("\n Operations: \n  1.Add Product \n  2.Select Product \n  3.Update Product Price \n  4.Remove Product \n  5.Exit \n   Select Any Operation");
			operation = Validations.validateOperation(SCANNER.next());

			switch (operation) {
			case 1:
				addProduct();
				break;
			case 2:
				selectProduct();
				break;
			case 3:
				updateProductPrice();
				break;
			case 4:
				removeProduct();
				break;
			case 5:
				SCANNER.close();
				System.exit(0);
			}
		} while (true);
	}

	private static final void addProduct() {
		final Product product = new Product();

		System.out.println("Mention Product Brand(SS, SG, MRF, RBK, NIKE)");
		product.setBrand(Validations.validateBrand(SCANNER.next()));

		System.out.println("Mention Product Name(Bat, Ball, Stump, Gloves, Helmet)");
		product.setName(Validations.validateName(SCANNER.next()));

		System.out.println("Mention Product Price");
		product.setPrice(Validations.validatePrice(SCANNER.next()));

		System.out.println("Mention Product Size(S, M, L)");
		product.setSize(Validations.validateSize(SCANNER.next()));

		System.out.println("Mention Manufacture Date(YYYY-MM-DD)");
		product.setManufactureDate(Validations.validateDate(SCANNER.next()));

		ShopKeeper.addProduct(product.getBrand(), product);
	}

	private static final void selectProduct() {
		System.out.println("Select Any Product");
		Customer customer = new Customer();
		customer.selectAnyProduct();
	}

	private static final void updateProductPrice() {
		String brand;
		String name;
		char size;
		double price;

		System.out.println("Mention Product Brand(SS, SG, MRF, RBK, NIKE)");
		brand = Validations.validateBrand(SCANNER.next());

		System.out.println("Mention Product Name(Bat, Ball, Stump, Gloves, Helmet)");
		name = Validations.validateName(SCANNER.next());

		System.out.println("Mention Product Size(S, M, L)");
		size = Validations.validateSize(SCANNER.next());

		System.out.println("Mention Product Price");
		price = Validations.validatePrice(SCANNER.next());

		ShopKeeper.updateProductPrice(brand, name, size, price);
	}

	private static final void removeProduct() {
		String brand;
		String name;
		char size;

		System.out.println("Mention Product Brand(SS, SG, MRF, RBK, NIKE)");
		brand = Validations.validateBrand(SCANNER.next());

		System.out.println("Mention Product Name(Bat, Ball, Stump, Gloves, Helmet)");
		name = Validations.validateName(SCANNER.next());

		System.out.println("Mention Product Size(S, M, L)");
		size = Validations.validateSize(SCANNER.next());

		ShopKeeper.removeProduct(brand, name, size);
	}

	public static final void showAllProducts(Map<String, List<Product>> sportsKits) {

		for (String productBrand : sportsKits.keySet()) {
			List<Product> products = sportsKits.get(productBrand);

			System.out.println(new StringBuilder().append("\n ").append(productBrand).append(" Brand").toString());

			for (Product product : products) {
				System.out.println(new StringBuilder().append("  { Product Name : ").append(product.getName())
						.append("\n    Product Price : ").append(product.getPrice()).append("\n    Product Size : ")
						.append(product.getSize()).append(" \n    Product Manufacture Date : ")
						.append(product.getManufactureDate()).append(" }").toString());
			}
		}
	}

	public static final void showSelectedProduct(Product product) {
		System.out.println(new StringBuilder().append("Product Details: \n  ProductName: ").append(product.getName())
				.append("\n  ProductBrand: ").append(product.getBrand()).append("\n  ProductPrice: ")
				.append(product.getPrice()).append("\n  ProductSize: ").append(product.getSize())
				.append("\n  ManufactureDate: ").append(product.getManufactureDate()).toString());
	}
}
