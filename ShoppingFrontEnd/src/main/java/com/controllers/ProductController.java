package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vinayak.Dao.CategoryDao;
import com.vinayak.Dao.ProductDao;
import com.vinayak.model.Category;
import com.vinayak.model.Product;
import java.util.List;

@Controller
public class ProductController {
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value="getProductForm",method=RequestMethod.GET)
	public String getProductForm(ModelMap map) {
		Product p=new Product();
		map.addAttribute("pObj",p);
		//List<Category> categories=categoryDao.getAllCategories();
		map.addAttribute("categories",categoryDao.getAllCategories());
		return "addProduct";
	}
	
	
	@RequestMapping(value="addProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute Product pObj,ModelMap map) {
		
		System.out.println(pObj.getCategoryId()+" "+pObj.getProductName());
		
		if(pObj.getProductId()==0) {
			
		System.out.println("In If");
		productDao.addProduct(pObj);
		}
		else
		{
			
			System.out.println("In else");
			productDao.updateProduct(pObj);
		}
		List<Product> product=productDao.getAllProducts();
		map.addAttribute("products",product);
		return "viewProducts";
	}
	@RequestMapping(value="viewProducts",method=RequestMethod.GET)
	
	public String getAllProducts(ModelMap map) {
		List<Product> product=productDao.getAllProducts();
		map.addAttribute("products",product);
		return "viewProducts";
	}
	
	@RequestMapping(value="deleteProduct/{prId}",method=RequestMethod.GET)
	public String deleteProduct(@PathVariable int prId,ModelMap map){
		productDao.deleteProduct(prId);
		map.addAttribute("msg","Product Deleted Succesfully");
		List<Product> product=productDao.getAllProducts();
		map.addAttribute("products",product);
		return "viewProducts";
	}
	@RequestMapping(value="updateProduct/{prId}",method=RequestMethod.GET)
	public String updateProduct(@PathVariable int prId,ModelMap map){
		Product pObj1=productDao.getProduct(prId);
		map.addAttribute("pObj",pObj1);
		
		return "addProduct";
	
	
	}
}
	
	


