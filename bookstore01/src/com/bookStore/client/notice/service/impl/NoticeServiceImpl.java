package com.bookStore.client.notice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.client.notice.dao.INoticeDao;
import com.bookStore.client.notice.service.INoticeService;
import com.bookStore.common.beans.Notice;
import com.bookStore.common.beans.Product;

@Service
public class NoticeServiceImpl implements INoticeService {
	
	@Autowired
	private INoticeDao noticeDao;

	@Override
	public List<Notice> findAllNotices() {
		return noticeDao.selectAllNotices();
	}

	@Override
	public List<Product> findWeekHotProduct() {
		return noticeDao.selectWeekHotProduct();
	}

}
