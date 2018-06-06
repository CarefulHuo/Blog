package com.bookStore.admin.products.dao;

import java.util.List;
import java.util.Map;

import com.bookStore.common.beans.Product;

public interface IAdminProductDao {

	List<Product> selectAllProducts();

	List<Product> selectProductByManyCondition(Map map);

	Product selectProductById(String id);

	int insertProduct(Product product);

	int updateProduct(Product product);

	int deleteProduct(String id);

}
