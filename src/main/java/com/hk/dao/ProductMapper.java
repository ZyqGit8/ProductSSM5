package com.hk.dao;

import java.util.List;
import java.util.Map;

import com.hk.bean.Product;
import com.hk.bean.category;


public interface ProductMapper {
	
   public List<Product> queryProducts();
   
   public category queryCategory(String id);
   
   public List<category> queryAllCategory();
	
   public int insertProduct(Product product);
   
   public int insertProductCategory(Map<String,Object> map);
	
   public int deleteProduct(String id);
    
   public Product queryById(String id);
    
   public int update(Product product); 
   
   public int deleteProductCategory(String pid);
}
