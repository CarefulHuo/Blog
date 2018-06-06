package com.bookStore.client.notice.service;

import java.util.List;

import com.bookStore.common.beans.Notice;
import com.bookStore.common.beans.Product;

public interface INoticeService {

	List<Notice> findAllNotices();

	List<Product> findWeekHotProduct();

}
