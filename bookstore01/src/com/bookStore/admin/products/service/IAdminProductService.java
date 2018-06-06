package com.bookStore.admin.products.service;

import java.util.List;

import com.bookStore.common.beans.Product;

public interface IAdminProductService {

	List<Product> findAllProducts();

	List<Product> findProductByManyCondition(Product product, String minprice, String maxprice);

	Product findProductById(String id);

	int addProduct(Product product);

	int editProduct(Product product);

	int deleteProduct(String id);

}
