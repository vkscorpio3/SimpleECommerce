package com.hepsiburada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hepsiburada.dao.HepsiBuradaDAO;
import com.hepsiburada.entity.Brand;
import com.hepsiburada.entity.Category;
import com.hepsiburada.entity.Product;

@Service
public class HepsiBuradaServiceImpl implements HepsiBuradaService {

	@Autowired
	private HepsiBuradaDAO hepsiBuradaDAO;

	@Transactional
	public List<Brand> getAllBrands() {
		return hepsiBuradaDAO.getAllBrands();
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<Category> getAllCategories() {
		return hepsiBuradaDAO.getAllCategories();
	}

	@Transactional
	public List<Product> getAllProducts() {
		return hepsiBuradaDAO.getAllProducts();
	}

	@Transactional
	public Category getCategory(Long categoryId) {
		return hepsiBuradaDAO.getCategory(categoryId);
	}

	@Transactional
	public void removeCategory(Long categoryId) {
		hepsiBuradaDAO.removeCategory(categoryId);
	}

	@Transactional
	public void createCategory(Category category) {
		hepsiBuradaDAO.createCategory(category);
	}

	@Transactional
	public void removeBrand(Long brandId) {
		hepsiBuradaDAO.removeBrand(brandId);
	}

	@Transactional
	public Brand getBrand(Long brandId) {
		return hepsiBuradaDAO.getBrand(brandId);
	}

	@Transactional
	public void createBrand(Brand brand) {
		hepsiBuradaDAO.createBrand(brand);
	}

	@Transactional
	public void updateBrand(Brand brand) {
		hepsiBuradaDAO.updateBrand(brand);
	}

	@Transactional
	public void createProduct(Product product) {
		hepsiBuradaDAO.createProduct(product);
	}

	@Transactional
	public Product getProduct(Long productId) {
		return hepsiBuradaDAO.getProduct(productId);
	}

	@Transactional
	public void removeProduct(Long productId) {
		hepsiBuradaDAO.removeProduct(productId);
	}

	@Transactional
	public void updateProduct(Product product) {
		hepsiBuradaDAO.updateProduct(product);
	}

	@Transactional
	public void updateCategory(Category category) {
		hepsiBuradaDAO.updateCategory(category);
	}

}
