package com.hwy.blog.find.IService.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwy.blog.common.beans.Blog;
import com.hwy.blog.common.beans.Label;
import com.hwy.blog.find.IService.IBlogFindService;
import com.hwy.blog.find.dao.IBlogFindDao;
import com.hwy.blog.unitls.PageModel;

@Service
public class IBlogFindServiceImpl implements IBlogFindService {

	@Autowired
	private IBlogFindDao blogFindDao;
	
	/*查找博客分类标签*/
	public List<Label> findLabel() {
		return blogFindDao.selectLabel();
	}
	/*查找博客*/
	public List<Blog> findBlogs(Label label,PageModel page) {
		Map<Object,Object> blogMap  = new HashMap<Object,Object>();
		blogMap.put("startIndex", page.getFirstLimitParam());
		blogMap.put("pageSize", page.getPageSize());
		blogMap.put("labelId", label.getLabelId());
		return blogFindDao.selectBlogs(blogMap);
	}
	/*查找博客数量*/
	public int findBlogCount(Label label) {
		return blogFindDao.findBlogCount(label);
	}
	//单个查找博客
	public Blog findBlogByOne(Integer id) {
		return blogFindDao.selectBlogByOne(id);
	}
	/*studyNote页面显示内容*/
	public int findStudentNoteCount(Label label, Integer flag) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("labelId", label.getLabelId());
		map.put("categoryId", flag);
		return blogFindDao.selectStudentNoteCount(map);
	}
	public List<Blog> findStudentNotes(Integer flag, Label label, PageModel page) {
		Map<Object,Object> studentNoteMap  = new HashMap<Object,Object>();
		studentNoteMap.put("startIndex", page.getFirstLimitParam());
		studentNoteMap.put("pageSize", page.getPageSize());
		studentNoteMap.put("labelId", label.getLabelId());
		studentNoteMap.put("categoryId", flag);
		return blogFindDao.selectStudentNotes(studentNoteMap);
	}
	/*根据博客书写日期进行查找*/
	public List<Blog> findBlogByDate(PageModel page, String creat) {
		int recordCount = blogFindDao.selectBlogCountByDate(creat);
		page.setRecordCount(recordCount );
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("startIndex", page.getFirstLimitParam());
		map.put("pageSize", page.getPageSize());
		map.put("date", creat);
		return blogFindDao.selectBlogByDate(map);
	}

}
