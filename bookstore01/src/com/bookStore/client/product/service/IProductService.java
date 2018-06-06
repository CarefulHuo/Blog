package com.bookStore.client.product.service;

import java.util.List;

import com.bookStore.common.beans.Product;
import com.bookStore.utils.PageModel;

public interface IProductService {

	List<Product> findProductByCategory(String category, PageModel pageModel);

	Product findProductById(String id);

	List<Product> findProductByName(String name, PageModel pageModel);

}
