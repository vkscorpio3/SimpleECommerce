package com.hepsiburada.service;

import java.util.List;

import com.hepsiburada.entity.Brand;
import com.hepsiburada.entity.Category;
import com.hepsiburada.entity.Product;

public interface HepsiBuradaService {
	List<Brand> getAllBrands();

	void removeBrand(Long brandId);

	Brand getBrand(Long brandId);

	void createBrand(Brand brand);

	void updateBrand(Brand brand);

	List<Category> getAllCategories();

	Category getCategory(Long categoryId);

	void removeCategory(Long categoryId);

	void createCategory(Category category);
	
	void updateCategory(Category category);

	List<Product> getAllProducts();

	void createProduct(Product product);

	Product getProduct(Long productId);

	void removeProduct(Long productId);

	void updateProduct(Product product);
}
