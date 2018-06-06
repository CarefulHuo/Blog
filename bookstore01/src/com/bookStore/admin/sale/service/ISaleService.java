package com.bookStore.admin.sale.service;

import java.util.List;

import com.bookStore.common.beans.ProductList;

public interface ISaleService {

	List<ProductList> findProductList(String year, String month);

}
