package com.hepsiburada.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hepsiburada.entity.Brand;
import com.hepsiburada.entity.Category;
import com.hepsiburada.entity.Product;

@Repository
public class HepsiBuradaDAOImpl implements HepsiBuradaDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getSession() {
		Session session = getSessionFactory().getCurrentSession();
		if (session == null) {
			session = getSessionFactory().openSession();
		}
		return session;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public List<Brand> getAllBrands() {
		return getSession().createQuery("from Brand").list();
	}

	@Override
	public List<Category> getAllCategories() {
		return sessionFactory.getCurrentSession().createQuery("from Category")
				.list();
	}

	@Override
	public List<Product> getAllProducts() {
		return getSession().createQuery("from Product").list();
	}

	@Override
	public Category getCategory(Long categoryId) {

		return (Category) getSession().get(Category.class, categoryId);

	}

	@Override
	public void removeCategory(Long categoryId) {
		Category category = getCategory(categoryId);
		if (null != category) {
			getSession().delete(category);
		}
	}

	@Override
	public void createCategory(Category category) {
		getSession().save(category);
	}

	@Override
	public void updateCategory(Category category) {
		getSession().merge(category);
	}

	@Override
	public void removeBrand(Long brandId) {
		Brand brand = getBrand(brandId);
		if (null != brand) {
			getSession().delete(brand);
		}
	}

	@Override
	public Brand getBrand(Long brandId) {
		return (Brand) getSession().get(Brand.class, brandId);
	}

	@Override
	public void createBrand(Brand brand) {
		getSession().save(brand);
	}

	@Override
	public void updateBrand(Brand brand) {
		getSession().update(brand);
	}

	@Override
	public void createProduct(Product product) {
		getSession().merge(product);
	}

	@Override
	public Product getProduct(Long productId) {
		return (Product) getSession().get(Product.class, productId);
	}

	@Override
	public void removeProduct(Long productId) {
		Product product = getProduct(productId);
		if (null != product) {
			getSession().delete(product);
		}
	}

	@Override
	public void updateProduct(Product product) {
		getSession().update(product);
	}

}
