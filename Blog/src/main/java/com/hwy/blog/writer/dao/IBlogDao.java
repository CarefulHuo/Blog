package com.hwy.blog.writer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hwy.blog.common.beans.Blog;
import com.hwy.blog.common.beans.Category;
import com.hwy.blog.common.beans.Label;

public interface IBlogDao {

	int insertBlog(Blog blog);

	List<Label> selectBlogLabel();
	List<Category> selectBlogCategory();

	int selectBlogCount(Blog blog);

	List<Blog> selectBlog(Map<Object, Object> map);

	int deleteBlog(@Param(value="blog_Id")Integer blog_Id);

	Blog selectOneBlog(@Param(value="blogId")Integer blogId);

	int updateBlog(Blog blog);


}
