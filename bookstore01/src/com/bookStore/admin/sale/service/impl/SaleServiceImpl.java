package com.bookStore.admin.sale.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.admin.sale.dao.ISaleDao;
import com.bookStore.admin.sale.service.ISaleService;
import com.bookStore.common.beans.ProductList;

@Service
public class SaleServiceImpl implements ISaleService {
	
	@Autowired
	private ISaleDao saleDao;

	@Override
	public List<ProductList> findProductList(String year, String month) {
		Map map = new HashMap<>();
		map.put("year", year);
		map.put("month", month);
		return saleDao.selectProductList(map);
	}

}
