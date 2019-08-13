package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vinayak.Dao.CategoryDao;
import com.vinayak.model.Category;


@Controller
public class CategoryController {
	
	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value="getCategoryForm",method=RequestMethod.GET)
	public String fetchCategoryForm(ModelMap map) {
		
		map.addAttribute("cObj",new Category());
		return "addCategory";
		
	}
	

	@RequestMapping(value="addCategory",method=RequestMethod.POST)
	public String addCategory(@ModelAttribute Category cObj) {
		boolean result=categoryDao.addCategory(cObj);
		if(result) {
			return "ViewAllCategories";
		}
		else {
			return "Error";
		}
		
		
	}
}
