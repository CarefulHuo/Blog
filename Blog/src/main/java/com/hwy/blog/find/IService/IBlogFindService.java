package com.hwy.blog.find.IService;

import java.util.List;

import com.hwy.blog.common.beans.Blog;
import com.hwy.blog.common.beans.Label;
import com.hwy.blog.unitls.PageModel;

public interface IBlogFindService {

	List<Label> findLabel();

	List<Blog> findBlogs(Label label,PageModel page);

	int findBlogCount(Label label);

	Blog findBlogByOne(Integer id);

	int findStudentNoteCount(Label label, Integer flag);

	List<Blog> findStudentNotes(Integer flag, Label label, PageModel page);

}
