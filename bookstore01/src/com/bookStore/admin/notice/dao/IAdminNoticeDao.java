package com.bookStore.admin.notice.dao;

import java.util.List;

import com.bookStore.common.beans.Notice;
import com.bookStore.utils.PageModel;

public interface IAdminNoticeDao {

	List<Notice> selectAllNotices(PageModel pageModel);

	int selectNoticeCount();

	int insertNotice(Notice notice);

	Notice selectAdminNoticeById(Integer nid);

	int updateNotice(Notice notice);

	int deleteNotice(Integer id);

}
