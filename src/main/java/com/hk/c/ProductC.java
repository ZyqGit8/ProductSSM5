package com.hk.c;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hk.bean.Product;
import com.hk.bean.category;
import com.hk.service.ProductService;

@Controller
public class ProductC {
	@Autowired
	private ProductService service;
	@RequestMapping("/products.do")
     public ModelAndView queryProducts(){
		List<Product> products = service.queryProducts();
		System.out.println(products);
    	ModelAndView mView = new ModelAndView();
    	mView.addObject("products",products);
    	mView.setViewName("/productInfo");
    	return mView;
     }
	
	@RequestMapping("/insertProduct.do")
	public ModelAndView insertProduct(Product product){
		int result = service.insertProduct(product);
		String id = product.getId();
		String cids = product.getCids();
		if (cids!=null) {
			String[] ids = cids.split(",");
			Map<String, Object> map = new HashMap<String,Object>();
		    map.put("pid",id);
		    map.put("cids",ids);
		    service.insertProductCategory(map);
		}
		ModelAndView mView = new ModelAndView();
		if (result>0) {
			mView.setViewName("redirect:products.do");
		}else{
			mView.setViewName("/fail");
		}
		return mView;
	}
	
	@RequestMapping("/insertInfo.do")
	public ModelAndView insertProducts(){
		List<category> categories = service.queryAllCategory();
		ModelAndView mView = new ModelAndView();
		mView.addObject("categories",categories);
		mView.setViewName("/insert");
		return mView;
	}
	
	@RequestMapping("/deleteProduct.do")
	public ModelAndView deleteProduct(String id){
		Product product = service.queryById(id);
		service.deleteProductCategory(product.getId());
		int result = service.deleteProduct(id);
		ModelAndView mView = new ModelAndView();
		if (result>0) {
			mView.setViewName("redirect:products.do");
		}else{
			mView.setViewName("/fail");
		}
		return mView;
	}
	
	@RequestMapping("/updateProduct.do")
	public ModelAndView updateProduct(String id){
		Product product = service.queryById(id);
		List<category> categories = service.queryAllCategory();
		ModelAndView mView = new ModelAndView();
		mView.addObject("product",product);
		mView.addObject("categories",categories);
		mView.setViewName("/update");
		return mView;
	}
	
	@RequestMapping("/updateProduct2.do")
	public ModelAndView updateProduct2(Product product){
		service.deleteProductCategory(product.getId());
		int result = service.update(product);
		String id = product.getId();
	    String cids = product.getCids();
	    System.out.println(cids);
		if (cids!=null) {
			String[] ids = cids.split(",");
			Map<String, Object> map = new HashMap<String,Object>();
		    map.put("pid",id);
		    map.put("cids",ids);
		    service.insertProductCategory(map);
		}
	    ModelAndView mView = new ModelAndView();
	    if (result>0) {
			mView.setViewName("redirect:products.do");
		}else{
			mView.setViewName("/fail");
		}
	    return mView;
	}
}
