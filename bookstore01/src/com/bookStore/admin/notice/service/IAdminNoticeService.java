package com.bookStore.admin.notice.service;

import java.util.List;

import com.bookStore.common.beans.Notice;
import com.bookStore.utils.PageModel;

public interface IAdminNoticeService {

	List<Notice> findAllNotices(PageModel pageModel);

	int findNoticeCount();

	int addNotice(Notice notice);

	Notice findNoticeById(Integer nid);

	int editNotice(Notice notice);

	int removeNotice(Integer id);

}
