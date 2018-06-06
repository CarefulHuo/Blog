package com.hwy.blog.writer.IService.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwy.blog.common.beans.Blog;
import com.hwy.blog.common.beans.Category;
import com.hwy.blog.common.beans.Label;
import com.hwy.blog.unitls.PageModel;
import com.hwy.blog.writer.IService.IBlogService;
import com.hwy.blog.writer.dao.IBlogDao;

@Service
public class IBlogServiceImpl implements IBlogService {
	
	@Autowired
	private IBlogDao blogDao;
	
	public int addBlog(Blog blog) {
		return blogDao.insertBlog(blog);
	}
	
	public List<Label> findBogLabel() {
		return blogDao.selectBlogLabel();
	}
	
	public int findBlogCount(Blog blog) {
		return blogDao.selectBlogCount(blog);
	}
	
	public List<Category> findBlogCategory() {
		return blogDao.selectBlogCategory();
	}
	
	public List<Blog> findBlog(PageModel page,Blog blog) {
		Map<Object,Object> map = new HashMap<Object, Object>();
		map.put("startPageIndex", page.getFirstLimitParam());
		map.put("pageSize", page.getPageSize());
		map.put("b_category", blog.getB_category());
		map.put("b_label", blog.getB_label());
		return blogDao.selectBlog(map);
	}

	public int deleteBlog(Integer blog_Id) {
		return blogDao.deleteBlog(blog_Id);
	}

	public Blog findOneBlog(Integer blogId) {
		return blogDao.selectOneBlog(blogId);
	}

	public int nodifyBlog(Blog blog) {
		return blogDao.updateBlog(blog);
	}
	

}
