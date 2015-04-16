package com.hepsiburada.controller;

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
import com.hepsiburada.service.HepsiBuradaService;

@Controller
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	HepsiBuradaService hepsiBuradaService;

	@RequestMapping(value = { "/" })
	public String index(Map<String, Object> map) {

		map.put("brand", new Brand());
		map.put("brandList", hepsiBuradaService.getAllBrands());

		return "brands";
	}

	@RequestMapping(value = "/createBrand", method = RequestMethod.POST)
	public String doneFormSubmission(@ModelAttribute("brand") Brand brand,
			BindingResult result) {
		hepsiBuradaService.createBrand(brand);
		return "redirect:/brand/";
	}

	@RequestMapping(value = "/edit/{brandId}", method = RequestMethod.GET)
	public ModelAndView editBrand(@PathVariable("brandId") Long brandId) {
		ModelAndView modelAndView = new ModelAndView("editBrand");
		modelAndView.addObject(hepsiBuradaService.getBrand(brandId));
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{brandId}", method = RequestMethod.POST)
	public String doneEditFormSubmission(@ModelAttribute("brand") Brand brand, BindingResult result,
			Model model) {
		hepsiBuradaService.updateBrand(brand);
		return "redirect:/brand/";
	}

	@RequestMapping("/delete/{brandId}")
	public String deleteBrand(@PathVariable("brandId") Long brandId) {
		hepsiBuradaService.removeBrand(brandId);
		return "redirect:/brand/";
	}
}
