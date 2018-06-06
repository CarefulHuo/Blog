package com.bookStore.client.notice.dao;

import java.util.List;

import com.bookStore.common.beans.Notice;
import com.bookStore.common.beans.Product;

public interface INoticeDao {

	List<Notice> selectAllNotices();

	List<Product> selectWeekHotProduct();

}
