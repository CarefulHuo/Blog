package com.bookStore.admin.sale.dao;

import java.util.List;
import java.util.Map;

import com.bookStore.common.beans.ProductList;

public interface ISaleDao {

	List<ProductList> selectProductList(Map map);

}
