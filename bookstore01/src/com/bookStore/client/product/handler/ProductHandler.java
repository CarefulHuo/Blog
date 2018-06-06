package com.bookStore.client.product.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookStore.client.product.service.IProductService;
import com.bookStore.common.beans.Product;
import com.bookStore.utils.PageModel;

@Controller
@RequestMapping("/client/products")
public class ProductHandler {
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping("/findProductByCategory.do")
	public String findProductByCategory(@RequestParam(defaultValue = "1") Integer pageIndex,String category, Model model) {
		//设置pagemodel属性
				PageModel pageModel = new PageModel();
				pageModel.setPageIndex(pageIndex);
				pageModel.setPageSize(4);
		
				//设置查询功能
				List<Product> products = productService.findProductByCategory(category,pageModel);
				//model.addAttribute("name",name);
				model.addAttribute("category",category);
				model.addAttribute("products",products);
				model.addAttribute("pageModel", pageModel);
				return "/client/product_list.jsp";
	}
	
	@RequestMapping("/findProductById.do")
	public String findProductById(String id,Model model) {
		Product product =productService.findProductById(id);
		model.addAttribute("p",product);
		return "/client/info.jsp";
	}
	
	@RequestMapping("/findProductByName.do")
	public String findProductByName(@RequestParam(defaultValue = "1") Integer pageIndex,String name, Model model) {
		//设置pagemodel属性
				PageModel pageModel = new PageModel();
				pageModel.setPageIndex(pageIndex);
				pageModel.setPageSize(2);
		
				//设置查询功能
				List<Product> products = productService.findProductByName(name,pageModel);
				//model.addAttribute("name",name);
				model.addAttribute("name",name);
				model.addAttribute("products",products);
				model.addAttribute("pageModel", pageModel);
				System.out.println("pageMOdle"+pageModel);
				return "/client/product_search_list.jsp";
	}
	


}
