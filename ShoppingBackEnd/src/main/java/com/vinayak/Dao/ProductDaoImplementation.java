package com.vinayak.Dao;



import java.util.List;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vinayak.model.Category;
import com.vinayak.model.Product;



@Repository(value="productDao")
@Transactional
public class ProductDaoImplementation implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
	public boolean addProduct(Product p) {
		
		try
		{
			Session session=sessionFactory.getCurrentSession(); //hibernate
			session.save(p);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateProduct(Product p) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(p);
			
			return true;
		}
		catch(Exception e)
		{
		e.printStackTrace();
		return false;
		}
	}
	/*@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public boolean updateProduct(Product p) {
		try {
			Session session=SessionFactoryProvider.getSF().openSession();
			Transaction tx=session.beginTransaction();
			session.update(p);
			tx.commit();
			session.close();
			
			return true;
		}
		catch(Exception e)
		{
		e.printStackTrace();
		return false;
		}
	}

	public boolean deleteProduct(int productId) {
		try {
			Product p=new Product();
			p.setProductId(productId);
			Session session=SessionFactoryProvider.getSF().openSession();
			Transaction tx=session.beginTransaction();
			session.delete(p);
			tx.commit();
			session.close();
			
			
			return true;
			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}


	}

	public Product getProduct(int productId) {
		
		try {
		Session session=SessionFactoryProvider.getSF().openSession();
		
		Product p=session.get(Product.class, productId);
		
		return p;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return null;
	}
*/
	public List<Product> getAllProducts() {

		try
		{
			Session session=sessionFactory.getCurrentSession(); 
			org.hibernate.Query q=session.createQuery("from Product");
			return q.list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	


	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Product p=session.get(Product.class, productId);
			session.delete(p);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}
		
/*public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		return false;
	}


	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}*/


}
