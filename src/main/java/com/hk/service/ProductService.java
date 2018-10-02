package com.hk.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hk.bean.Product;
import com.hk.bean.category;
import com.hk.dao.ProductMapper;

@Service
public class ProductService {
	@Autowired
	private ProductMapper mapper;

	public List<Product> queryProducts() {
		List<Product> products = mapper.queryProducts();
		return products;
	}

	public List<category> queryAllCategory() {
		return mapper.queryAllCategory();
	}

	public int insertProduct(Product product) {
		return mapper.insertProduct(product);
	}

	public int insertProductCategory(Map<String,Object> map){
		return mapper.insertProductCategory(map);
	}
	
	public int deleteProduct(String id) {
		return mapper.deleteProduct(id);
	}

	public Product queryById(String id) {
		return mapper.queryById(id);
	}

	public int update(Product product) {
		return mapper.update(product);
	}
	
	public int deleteProductCategory(String pid){
		return mapper.deleteProductCategory(pid);
	}

}
