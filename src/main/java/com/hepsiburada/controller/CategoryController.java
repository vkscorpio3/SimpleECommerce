package com.hepsiburada.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.hepsiburada.entity.Category;
import com.hepsiburada.service.HepsiBuradaService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	HepsiBuradaService hepsiBuradaService;

	@RequestMapping(value = { "/" })
	public String index(Map<String, Object> map) {

		map.put("category", new Category());
		map.put("categoryList", hepsiBuradaService.getAllCategories());

		return "categories";
	}

	@RequestMapping(value = "/createCategory", method = RequestMethod.POST)
	public String doneFormSubmission(
			@ModelAttribute("category") Category category, BindingResult result) {
		Long selectedCategory = Long.parseLong(category.getParentCategory()
				.getCategoryName());
		Category category1;
		if (selectedCategory == -1) {
			category1 = new Category(category.getCategoryName());
		} else {
			category1 = new Category(category.getCategoryName());
			category1.setParentCategory(hepsiBuradaService
					.getCategory(selectedCategory));
		}
		hepsiBuradaService.createCategory(category1);
		return "redirect:/category/";
	}

	@RequestMapping(value = "/edit/{categoryId}", method = RequestMethod.GET)
	public ModelAndView editCategory(@PathVariable("categoryId") Long categoryId) {
		ModelAndView modelAndView = new ModelAndView("editCategory");
		Map<Long, String> categoryMap = new HashMap<Long, String>();
		for (Category obj : hepsiBuradaService.getAllCategories()) {
			categoryMap.put(obj.getCategoryId(), obj.getCategoryName());
		}
		Category category = new Category();
		category = hepsiBuradaService.getCategory(categoryId);
		modelAndView.addObject("category", category);
		modelAndView.addObject("categoryList", categoryMap);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{categoryId}", method = RequestMethod.POST)
	public String doneEditFormSubmission(
			@ModelAttribute("category") Category category,
			BindingResult result, Model model) {
		Long selectedCategory = Long.parseLong(category.getParentCategory()
				.getCategoryName());
		if (selectedCategory == -1) {
			category.setParentCategory(new Category());
		} else {
			category.setParentCategory(hepsiBuradaService
					.getCategory(selectedCategory));
		}
		hepsiBuradaService.updateCategory(category);
		return "redirect:/category/";
	}

	@RequestMapping("/delete/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") Long categoryId) {
		hepsiBuradaService.removeCategory(categoryId);
		return "redirect:/category/";
	}

}
