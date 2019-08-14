package com.vinayak.Dao;

import java.util.List;

import com.vinayak.model.Category;

public interface CategoryDao  {

		public boolean addCategory(Category obj);
		public boolean deleteCategory(int categoryId);
		public  Category getCategoryById(int Id);
		public boolean updateCategory(Category obj);
		public List<Category> getAllCategories();
}
