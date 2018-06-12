package com.hwy.blog.find.IService.Impl;

import java.util.ArrayList;
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
	//博客归档按月份
	@Override
	public List<String> guiDangDateCount(List<String> createDates) {
		List<String> result = new ArrayList<>();  //查询结果集
		StringBuilder dateBuilder = new StringBuilder();
		
		for(int i = 0; i<createDates.size()-1; i++){
			int count  = blogFindDao.slectGuiDangCount(createDates.get(i));
			if(count != 0){
				char [] creatDates = createDates.get(i).toCharArray();
				dateBuilder.append(creatDates[0]).append(creatDates[1]).append(creatDates[2]).append(creatDates[3]).append("年");
				dateBuilder.append(creatDates[4]).append(creatDates[5]).append("月");
				dateBuilder.append("          ").append(Integer.toString(count)).append("篇");
				result.add(dateBuilder.toString());
				dateBuilder.setLength(0);
			}
		}
		return result;
	}
	/*按月份查找博客*/
	@Override
	public List<Blog> findGuiDangBlog(PageModel page, String string) {
		int recordCount = blogFindDao.slectGuiDangCount(string);
		page.setRecordCount(recordCount);
		
		Map<String,Object> information = new HashMap<>();
		information.put("startIndex", page.getFirstLimitParam());
		information.put("pageSize", page.getPageSize());
		information.put("date", string);
		
		return blogFindDao.selectGuiDangBlog(information);
	}

}
