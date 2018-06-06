package com.bookStore.client.product.dao;

import java.util.List;
import java.util.Map;

import com.bookStore.common.beans.Product;

public interface IProductDao {

	int selectProductCount(Map<String, Object> map);

	List<Product> selectProductByCategory(Map<String, Object> map);

	Product selectProductById(String id);

	int selectProductCountByName(Map<String, Object> map);

	List<Product> selectProductByName(Map<String, Object> map);

}
