package com.bookStore.client.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.client.product.dao.IProductDao;
import com.bookStore.client.product.service.IProductService;
import com.bookStore.common.beans.Product;
import com.bookStore.utils.PageModel;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductDao productDao;

	@Override
	public List<Product> findProductByCategory(String category, PageModel pageModel) {
		Map<String,Object> map=new HashMap<>();
		map.put("category", category);
		int recordCount=productDao.selectProductCount(map);
		pageModel.setRecordCount(recordCount);
		if(recordCount>0){
			map.put("start", pageModel.getFirstLimitParam());
			map.put("pageSize", pageModel.getPageSize());		
		}
		List<Product> products=productDao.selectProductByCategory(map);
		return products;
	}

	@Override
	public Product findProductById(String id) {
		return productDao.selectProductById(id);
	}

	@Override
	public List<Product> findProductByName(String name, PageModel pageModel) {
		
		Map<String,Object> map=new HashMap<>();
		map.put("name", name);
		int recordCount=productDao.selectProductCountByName(map);
		pageModel.setRecordCount(recordCount);
		if(recordCount>0){
			map.put("start", pageModel.getFirstLimitParam());
			map.put("pageSize", pageModel.getPageSize());		
		}
		List<Product> products=productDao.selectProductByName(map);
		return products;
	}
	


}
