package com.hepsiburada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hepsiburada.entity.Brand;
import com.hepsiburada.entity.Product;
import com.hepsiburada.service.HepsiBuradaService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	HepsiBuradaService hepsiBuradaService;

	@RequestMapping(value = { "/" })
	public ModelAndView index() {

		ModelAndView modelAndView = new ModelAndView("products");

		modelAndView.addObject("product", new Product());
		modelAndView.addObject("brandList", hepsiBuradaService.getAllBrands());
		modelAndView.addObject("categoryList",
				hepsiBuradaService.getAllCategories());
		modelAndView.addObject("productList",
				hepsiBuradaService.getAllProducts());

		return modelAndView;
	}

	@RequestMapping(value = "/createProduct", method = RequestMethod.POST)
	public String doneFormSubmission(
			@ModelAttribute("product") Product product, BindingResult result) {
		Long brandId = Long.parseLong(product.getProductBrand().getBrandName());
		if (brandId == -1) {
			product.setProductBrand(new Brand());
			hepsiBuradaService.createProduct(product);
		} else {
			product.setProductBrand(hepsiBuradaService.getBrand(brandId));
			hepsiBuradaService.createProduct(product);
		}
		return "redirect:/product/";
	}

	@RequestMapping(value = "/edit/{productId}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable("productId") Long productId) {
		ModelAndView modelAndView = new ModelAndView("editProduct");
		modelAndView.addObject(hepsiBuradaService.getProduct(productId));
		modelAndView.addObject("brandList", hepsiBuradaService.getAllBrands());
		modelAndView.addObject("categoryList",
				hepsiBuradaService.getAllCategories());
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{productId}", method = RequestMethod.POST)
	public String doneEditFormSubmission(
			@ModelAttribute("product") Product product, BindingResult result,
			Model model) {
		hepsiBuradaService.updateProduct(product);
		return "redirect:/brand/";
	}

	@RequestMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable("productId") Long productId) {
		hepsiBuradaService.removeProduct(productId);
		return "redirect:/product/";
	}

}
