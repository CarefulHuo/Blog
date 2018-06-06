package com.hwy.blog.writer.handler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hwy.blog.common.beans.Blog;
import com.hwy.blog.common.beans.Category;
import com.hwy.blog.common.beans.Label;
import com.hwy.blog.unitls.PageModel;
import com.hwy.blog.writer.IService.IBlogService;

@Controller
@RequestMapping("/blogAdmin")
public class blogWriter {
	
	@Autowired
	private IBlogService blogService;
	
	/*添加博客*/
	@RequestMapping("/addBlog.action")
	public String addBlog(HttpServletResponse response,Blog blog,Model model,@RequestParam(defaultValue="1")Integer addId) throws IOException{
		int result = 0;
		List<Category> categoryInformation = blogService.findBlogCategory();		
		List<Label> labelInformation = blogService.findBogLabel();
		if(addId==0){
			Date b_createDate = new Date();
			blog.setB_createDate(b_createDate);
			 result = blogService.addBlog(blog);
		}
		model.addAttribute("labels", labelInformation);
		model.addAttribute("categorys", categoryInformation);
			return "/jsp/addBlog.jsp";
	}
	/*查找博客*/
	@RequestMapping("/findBlog.action")
	public String findBlog(@RequestParam(defaultValue="-1")Integer labelId,@RequestParam(defaultValue="-1")Integer categoryId,@RequestParam(defaultValue="1")Integer pageIndex,Model model) throws Exception{
		//设置日期格式
		SimpleDateFormat bartDateFormat =  new SimpleDateFormat("MM-dd-yyyy");
		Blog blog = new Blog();
		List<Category> categoryInformation = blogService.findBlogCategory();		
		List<Label> labelInformation = blogService.findBogLabel();
		blog.setB_category(categoryId);
		blog.setB_label(labelId);
		model.addAttribute("category_number", categoryId);
		model.addAttribute("label_number", labelId);
		int recordCount = blogService.findBlogCount(blog);
		PageModel  page = new PageModel();
		page.setPageIndex(pageIndex);
		page.setRecordCount(recordCount);
		List<Blog> blogs = blogService.findBlog(page,blog);
		
		for(Blog bl :blogs){
			bl.setB_date(bartDateFormat.format(bl.getB_createDate()));
			bl.setB_htmlStr(blogWriter.removeTag(bl.getB_content()));
		}
		
		model.addAttribute("labelId", labelId);
		model.addAttribute("b_category", categoryId);
		model.addAttribute("page", page);
		model.addAttribute("blogs", blogs);
		model.addAttribute("categorys", categoryInformation);
		model.addAttribute("labels", labelInformation);
		
		return "/jsp/blogList.jsp";
		
	}
	/*博客的单个查找*/
	@RequestMapping("/findOneBlog.action")
	public String findOneBlog(@RequestParam(defaultValue="-1")Integer blogId,Model model){
		Blog blog = blogService.findOneBlog(blogId);
		model.addAttribute("blog", blog);
		return "/jsp/blogInformation.jsp";
	}
	/*删除博客*/
	@RequestMapping("/deleteBlog.action")
	public String deleteBlog(Integer blog_Id){
		int result = blogService.deleteBlog(blog_Id);
		return "/blogAdmin/findBlog.action";
	}
	/*查找需修改博客的内容*/
	@RequestMapping("/findNodifyBlog.action")
	public String findNodifyBlog(Integer blogId,Model model){
		List<Category> categoryInformation = blogService.findBlogCategory();		
		List<Label> labelInformation = blogService.findBogLabel();
		Blog blog = blogService.findOneBlog(blogId);
		
		model.addAttribute("blog", blog);
		model.addAttribute("categorys", categoryInformation);
		model.addAttribute("labels", labelInformation);
		return "/jsp/nodifyBlog.jsp";
	}
	/*修改博客*/
	@RequestMapping("/nodifyBlog.action")
	public String nodifyBlog(Integer id,Blog blog,Model model){
		System.out.println(id);
		blog.setB_id(id);
		int result = blogService.nodifyBlog(blog);
		return "/jsp/nodifyBlog.jsp";
	}
	//截取博客内容部分
		public static String removeTag(String htmlStr) {  
		    String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // script  
		    String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // style  
		    String regEx_html = "<[^>]+>"; // HTML tag  
		    String regEx_space = "\\s+|\t|\r|\n";// other characters  
		  
		    Pattern p_script = Pattern.compile(regEx_script,  
		        Pattern.CASE_INSENSITIVE);  
		    Matcher m_script = p_script.matcher(htmlStr);  
		    htmlStr = m_script.replaceAll("");  
		    Pattern p_style = Pattern  
		        .compile(regEx_style, Pattern.CASE_INSENSITIVE);  
		    Matcher m_style = p_style.matcher(htmlStr);  
		    htmlStr = m_style.replaceAll("");  
		    Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);  
		    Matcher m_html = p_html.matcher(htmlStr);  
		    htmlStr = m_html.replaceAll("");  
		    Pattern p_space = Pattern  
		        .compile(regEx_space, Pattern.CASE_INSENSITIVE);  
		    Matcher m_space = p_space.matcher(htmlStr);  
		    htmlStr = m_space.replaceAll(" ");
		    if(htmlStr.length()>300){
		    	return htmlStr.substring(0, 300);  
		    }
		    return htmlStr;  
		}
}
