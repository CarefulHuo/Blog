package com.bookStore.admin.products.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.admin.products.dao.IAdminProductDao;
import com.bookStore.admin.products.service.IAdminProductService;
import com.bookStore.common.beans.Product;

@Service
public class AdminProductServiceImpl implements IAdminProductService {
	
	@Autowired
	private IAdminProductDao adminProductDao;

	@Override
	public List<Product> findAllProducts() {
		return adminProductDao.selectAllProducts();
	}

	@Override
	public List<Product> findProductByManyCondition(Product product, String minprice, String maxprice) {
			Map map = new HashMap<>();
			map.put("product", product);
			map.put("minprice", minprice);
			map.put("maxprice", maxprice);
		return adminProductDao.selectProductByManyCondition(map);
	}

	@Override
	public Product findProductById(String id) {
		return adminProductDao.selectProductById(id);
	}

	@Override
	public int addProduct(Product product) {
		return adminProductDao.insertProduct(product);
	}

	@Override
	public int editProduct(Product product) {
		return adminProductDao.updateProduct(product);
	}

	@Override
	public int deleteProduct(String id) {
		// TODO Auto-generated method stub
		return adminProductDao.deleteProduct(id);
	}

}
