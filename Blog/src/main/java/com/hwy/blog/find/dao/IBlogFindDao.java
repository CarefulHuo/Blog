package com.hwy.blog.find.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hwy.blog.common.beans.Blog;
import com.hwy.blog.common.beans.Label;

public interface IBlogFindDao {

	List<Label> selectLabel();

	List<Blog> selectBlogs(Map<Object,Object> blogMap);

	int findBlogCount(@Param(value="label")Label label);

	Blog selectBlogByOne(Integer id);

	int selectStudentNoteCount(Map<String,Integer> count);

	List<Blog> selectStudentNotes(Map<Object, Object> studentNoteMap);

	int selectBlogCountByDate(String creat);

	List<Blog> selectBlogByDate(Map<String, Object> map);

	int slectGuiDangCount(@Param(value="startDate")String startDate);

	List<Blog> selectGuiDangBlog(Map<String, Object> information);

}
