package com.hepsiburada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping(value = { "/"})
	public String listBrands() {
		return "index";
	}

}
