package com.bookStore.client.notice.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.client.notice.service.INoticeService;
import com.bookStore.common.beans.Notice;
import com.bookStore.common.beans.Product;

@RequestMapping("/client/notice")
@Controller
public class NoticeHandler {
	
	@Autowired
	private INoticeService noticeService;
	
	
	@RequestMapping("/findAllNotices.do")
	public String findAllNotices(Model model) {
		List<Notice> notices = noticeService.findAllNotices();
		model.addAttribute("notices", notices);
		
		List<Product> products =noticeService.findWeekHotProduct();
		model.addAttribute("products", products);
		return "/client/index.jsp";
		
	}

}
