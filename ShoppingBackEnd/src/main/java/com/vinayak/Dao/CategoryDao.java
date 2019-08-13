package com.vinayak.Dao;

import java.util.List;

import com.vinayak.model.Category;

public interface CategoryDao  {

		public boolean addCategory(Category obj);
		public List<Category> getAllCategories();
}
