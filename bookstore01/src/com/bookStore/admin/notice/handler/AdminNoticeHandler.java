package com.bookStore.admin.notice.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookStore.admin.notice.service.IAdminNoticeService;
import com.bookStore.common.beans.Notice;
import com.bookStore.utils.PageModel;

@RequestMapping("/admin/notice")
@Controller
public class AdminNoticeHandler {
	
	@Autowired
	private IAdminNoticeService adminNoticeService; 
	
	@RequestMapping("/findAllNotices.do")
	public String findAllNotices(@RequestParam(defaultValue="1")Integer pageIndex,Model model) {
		PageModel pageModel =new PageModel();
		pageModel.setPageIndex(pageIndex);
		int count = adminNoticeService.findNoticeCount();
		pageModel.setRecordCount(count);
		List<Notice> notices= adminNoticeService.findAllNotices(pageModel);
		model.addAttribute("notices", notices);
		model.addAttribute("pageModel", pageModel);
		return "/admin/notices/list.jsp";
	}
	
	@RequestMapping("/AddNotice.do")
	public String AddNotice(Notice notice,Model model) {
		int rows =adminNoticeService.addNotice(notice);
		if(rows > 0) {
			model.addAttribute("add_notice_error", "公告添加成功！");
		}else {
			model.addAttribute("add_notice_error", "公告添加失败！");
		}
		return "redirect:/admin/notice/findAllNotices.do";
	}
	
	@RequestMapping("/findNoticeById.do")
	public String findNoticeById(Integer nid ,Model model) {
		Notice notice =adminNoticeService.findNoticeById(nid);
		System.out.println("notice"+notice);
		model.addAttribute("n", notice);
		return "/admin/notices/edit.jsp";
	}
	
	
	
	@RequestMapping("/editNotice.do")
	public String editNotice(Notice notice,Model model) {
		int rows =adminNoticeService.editNotice(notice);
		if(rows > 0) {
			model.addAttribute("add_notice_error", "公告修改成功！");
		}else {
			model.addAttribute("add_notice_error", "公告修改失败！");
		}
		return "redirect:/admin/notice/findAllNotices.do";
	}
	
	@RequestMapping("/removeNotice.do")
	public String removeNotice(Integer id,Model model) {
		int rows =adminNoticeService.removeNotice(id);
		if(rows > 0) {
			model.addAttribute("add_notice_error", "公告删除成功！");
		}else {
			model.addAttribute("add_notice_error", "公告删除失败！");
		}
		return "redirect:/admin/notice/findAllNotices.do";
	}
	
	

}
