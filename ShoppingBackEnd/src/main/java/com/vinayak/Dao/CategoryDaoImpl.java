package com.vinayak.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vinayak.model.Category;


@Repository(value="categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private SessionFactory sessionFactory;
	public boolean addCategory(Category obj)
	{
		try
		{
			Session session=sessionFactory.getCurrentSession(); //hibernate
			session.save(obj);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Category> getAllCategories() {

		try
		{
			Session session=sessionFactory.getCurrentSession(); //hibernate
			Query q=session.createQuery("from Category");
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteCategory(int categoryId) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Category c=new Category();
			c.setCategoryId(categoryId);
			session.delete(c);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateCategory(Category obj) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(obj);
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Category getCategoryById(int Id) {
		// TODO Auto-generated method stub
			try
			{
				Session session=sessionFactory.getCurrentSession();
				Category cObj=session.get(Category.class,Id);
				return cObj;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		
	}

	}
	


