package com.hwy.blog.find.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hwy.blog.common.beans.Blog;
import com.hwy.blog.common.beans.Label;
import com.hwy.blog.find.IService.IBlogFindService;
import com.hwy.blog.unitls.PageModel;
import com.hwy.blog.unitls.dateConfig;


@Controller
@RequestMapping("/blogFind")
public class blogFindHandler {

	@Autowired
	private IBlogFindService blogFindService;
	
	/*主页index的内容显示*/
	@RequestMapping("/findBlogs.action")
	public String findBlogs(Model model,Label label,@RequestParam(defaultValue="1")Integer pageIndex){
		int recordCount = blogFindService.findBlogCount(label);
		
		PageModel page = new PageModel();
		page.setPageIndex(pageIndex);
		page.setRecordCount(recordCount);
		
		List<Label> labelList = blogFindService.findLabel();
		List<Blog> blogList = blogFindService.findBlogs(label,page);
		
		SimpleDateFormat bartDateFormat =  new SimpleDateFormat("MM-dd-yyyy");
		for(Blog bl :blogList){
			bl.setB_date(bartDateFormat.format(bl.getB_createDate()));
			bl.setB_htmlStr(blogFindHandler.removeTag(bl.getB_content()));
		}
		/*博客归档显示*/
		List<String>  createDates = dateConfig.addBlogStartMonth();  //获取默认日期和最新日期的间隔月数
		List<String>  guiDangMap = blogFindService.guiDangDateCount(createDates);
		
		model.addAttribute("guiDangs", guiDangMap);
		model.addAttribute("labe", label);
		model.addAttribute("page", page);
		model.addAttribute("blogs", blogList);
		model.addAttribute("labels", labelList);
		return "/jsp/index.jsp";
	}
	/*studyNote页面的内容显示*/
	@RequestMapping("/findStudentNote.action")
	public String findStudentNote(@RequestParam(defaultValue="1")Integer pageIndex,Integer flag,Label label,Model model){
		int recordCount = blogFindService.findStudentNoteCount(label,flag);
		
		PageModel page = new PageModel();
		page.setPageIndex(pageIndex);
		page.setRecordCount(recordCount);
		List<Label> labelList = blogFindService.findLabel();
		List<Blog> blogList = blogFindService.findStudentNotes(flag,label,page);
		SimpleDateFormat bartDateFormat =  new SimpleDateFormat("MM-dd-yyyy");
		for(Blog bl :blogList){
			bl.setB_date(bartDateFormat.format(bl.getB_createDate()));
			bl.setB_htmlStr(blogFindHandler.removeTag(bl.getB_content()));
		}
		/*博客归档显示*/
		List<String>  createDates = dateConfig.addBlogStartMonth();  //获取默认日期和最新日期的间隔月数
		List<String>  guiDangMap = blogFindService.guiDangDateCount(createDates);
		
		model.addAttribute("guiDangs", guiDangMap);
		model.addAttribute("fg", flag);
		model.addAttribute("labe", label);
		model.addAttribute("page", page);
		model.addAttribute("blogs", blogList);
		model.addAttribute("labels", labelList);
		
		if(flag==1){
			return "/jsp/informationSharing.jsp";
		}else if(flag==2){
			return "/jsp/studyNote.jsp";
		}else if(flag==3){
			return "/jsp/chickenSoup.jsp";
		}
		return null;
	}
	
	/*每个博客的内容显示*/
	@RequestMapping("/findBlogByOne.action")
	public String findBlogByOne(Integer id,Model model){
		
		Blog blog = blogFindService.findBlogByOne(id);
		List<Label> labelList = blogFindService.findLabel();
		
		SimpleDateFormat bartDateFormat =  new SimpleDateFormat("MM-dd-yyyy");
		blog.setB_date(bartDateFormat.format(blog.getB_createDate()));
		
		/*博客归档显示*/
		List<String>  createDates = dateConfig.addBlogStartMonth();  //获取默认日期和最新日期的间隔月数
		List<String>  guiDangMap = blogFindService.guiDangDateCount(createDates);
		
		model.addAttribute("guiDangs", guiDangMap);
		model.addAttribute("blog", blog);
		model.addAttribute("labels", labelList);
		return "/jsp/blogContent.jsp";
	}
	/*根据博客书写日期查找博客*/
	@RequestMapping(value="/findBlogByDate.action")
	public String findBlogByDate(@RequestParam(defaultValue="1")Integer pageIndex,Model model,String creat) throws ParseException{
		PageModel page = new PageModel();
		page.setPageIndex(pageIndex);
		String cterMonth = creat;
		//去除字符日期的-
		String [] date = creat.split("-"); 
		StringBuilder dateBuilder = new StringBuilder();
		dateBuilder.append(date[0]).append(date[1]).append(date[2]);
		creat = dateBuilder.toString();
		//更改日期显示，增加内容摘要
		List<Label> labelList = blogFindService.findLabel();
		List<Blog> blogListByDate = blogFindService.findBlogByDate(page,creat);
		SimpleDateFormat blogDateFormate = new SimpleDateFormat("MM-dd-YYYY");
		for(Blog blog: blogListByDate){
			blog.setB_date(blogDateFormate.format(blog.getB_createDate()));
			blog.setB_htmlStr(blogFindHandler.removeTag(blog.getB_content()));
		}
		/*博客归档显示*/
		List<String>  createDates = dateConfig.addBlogStartMonth();  //获取默认日期和最新日期的间隔月数
		List<String>  guiDangMap = blogFindService.guiDangDateCount(createDates);
		
		model.addAttribute("guiDangs", guiDangMap);
		model.addAttribute("creat", cterMonth);
		model.addAttribute("page", page);
		model.addAttribute("labels", labelList);
		model.addAttribute("blogs", blogListByDate);
		return "/jsp/preciseDateBlog.jsp";
	}
	//根据月份查找博客
	@RequestMapping(value="/fingGuiDangDate.action")
	public String findGuiDang(@RequestParam(defaultValue="1")Integer pageIndex,Model model,String guidang){
		String month = guidang;
		char []  resultDate =  guidang.toCharArray();
		StringBuilder dateBuilder = new StringBuilder();
		dateBuilder.append(resultDate[0]).append(resultDate[1]).append(resultDate[2]).append(resultDate[3]);
		dateBuilder.append(resultDate[5]).append(resultDate[6]).append(0).append(1);
		
		PageModel page = new PageModel();
		page.setPageIndex(pageIndex);
		List<Label> labelList = blogFindService.findLabel();
		List<Blog> blogListByGuiDang = blogFindService.findGuiDangBlog(page,dateBuilder.toString());
		SimpleDateFormat blogDateFormate = new SimpleDateFormat("MM-dd-YYYY");
		for(Blog blog: blogListByGuiDang){
			blog.setB_date(blogDateFormate.format(blog.getB_createDate()));
			blog.setB_htmlStr(blogFindHandler.removeTag(blog.getB_content()));
		}
		/*博客归档显示*/
		List<String>  createDates = dateConfig.addBlogStartMonth();  //获取默认日期和最新日期的间隔月数
		List<String>  guiDangMap = blogFindService.guiDangDateCount(createDates);
		
		model.addAttribute("guiDangs", guiDangMap);
		model.addAttribute("month", month);
		model.addAttribute("page", page);
		model.addAttribute("labels", labelList);
		model.addAttribute("blogs", blogListByGuiDang);
		return "/jsp/guiDang.jsp";
	}
	/*关于我的显示*/
	@RequestMapping("/aboutme.action")
	public String aboutme(Model model){
		List<Label> labelList = blogFindService.findLabel();
		
		/*博客归档显示*/
		List<String>  createDates = dateConfig.addBlogStartMonth();  //获取默认日期和最新日期的间隔月数
		List<String>  guiDangMap = blogFindService.guiDangDateCount(createDates);
		
		model.addAttribute("guiDangs", guiDangMap);
		model.addAttribute("labels", labelList);
		return "/jsp/aboutme.jsp";
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
