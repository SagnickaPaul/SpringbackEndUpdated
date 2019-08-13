package com.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String addCategory(@ModelAttribute Category cObj,ModelMap map) {
		boolean result=categoryDao.addCategory(cObj);
		if(result) {
			List<Category> categoryList=categoryDao.getAllCategories();
			map.addAttribute("categories",categoryList);
			return "ViewAllCategories";
		}
		else {
			return "Error";
		}
		
		
	}
	
	
	@RequestMapping(value="/deleteCategory/{catId}",method=RequestMethod.GET)
	public String deleteCategory(@PathVariable String catId,ModelMap map){
		categoryDao.deleteCategory(catId);
		map.addAttribute("msg","Category Deleted Succesfully");
		List<Category> categoryList=categoryDao.getAllCategories();
		map.addAttribute("categories",categoryList);
		return "ViewAllCategories";
	
	}
	
	
	
	
	
	
	
	
}

