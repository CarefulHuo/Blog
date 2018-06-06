package com.bookStore.admin.notice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.admin.notice.dao.IAdminNoticeDao;
import com.bookStore.admin.notice.service.IAdminNoticeService;
import com.bookStore.common.beans.Notice;
import com.bookStore.utils.PageModel;

@Service
public class AdminNoticeServiceImpl implements IAdminNoticeService {
	
	@Autowired
	private IAdminNoticeDao adminNoticeDao;

	@Override
	public List<Notice> findAllNotices(PageModel pageModel) {
		return adminNoticeDao.selectAllNotices(pageModel);
	}

	@Override
	public int findNoticeCount() {
		return adminNoticeDao.selectNoticeCount();
	}

	@Override
	public int addNotice(Notice notice) {
		return adminNoticeDao.insertNotice(notice);
	}

	@Override
	public Notice findNoticeById(Integer nid) {
		return adminNoticeDao.selectAdminNoticeById(nid);
	}

	@Override
	public int editNotice(Notice notice) {
		return adminNoticeDao.updateNotice(notice);
	}

	@Override
	public int removeNotice(Integer id) {
		// TODO Auto-generated method stub
		return adminNoticeDao.deleteNotice(id);
	}

	
}
