package com.hwy.blog.writer.IService;

import java.util.List;

import com.hwy.blog.common.beans.Blog;
import com.hwy.blog.common.beans.Category;
import com.hwy.blog.common.beans.Label;
import com.hwy.blog.unitls.PageModel;

public interface IBlogService {

	int addBlog(Blog blog);

	List<Label> findBogLabel( );

	int findBlogCount(Blog blog);

	List<Blog> findBlog(PageModel page,Blog blog);

	List<Category> findBlogCategory();

	int deleteBlog(Integer blog_Id);

	Blog findOneBlog(Integer blogId);

	int nodifyBlog(Blog blog);


}
