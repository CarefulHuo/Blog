package com.bookStore.admin.sale.handler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.admin.sale.service.ISaleService;
import com.bookStore.common.beans.ProductList;

@Controller
@RequestMapping("/admin/sale")
public class SaleHandler {
	
	@Autowired
	private ISaleService saleService;
	
	
	@RequestMapping("/download.do")
	public void createSaleList(HttpServletResponse response,String year,String month,HttpSession session,
			HttpServletRequest request) throws IOException{
		if(year == null || year.equals(' ') ) {
			Calendar c = Calendar.getInstance();
			year =   Integer.toString(c.get(Calendar.YEAR));
			System.out.println("year"+year);
		}
		if(month == null) {
			Calendar c = Calendar.getInstance();
			month =   Integer.toString(c.get(Calendar.MONTH));
			System.out.println("month"+month);
		}
		//查询对应时间段你的销售榜单
		List<ProductList> productsList = saleService.findProductList(year,month);
		
		//下载excel文件
		String fileName = year +"年"+month+"月销售榜单";
		String sheetName = month +"月销售榜单";
		String titleName = year+"年"+month+"月销售榜单";
		
		String[] columnName = {"商品名称","销售数量"};
		//自定义列数目为2
		int columnNum = 2;
		
		String[][] dataList = new String[productsList.size()][columnNum];
		for(int i =0;i<productsList.size();i++) {
			ProductList p1 = productsList.get(i);
			dataList[i][0] = p1.getName();
			dataList[i][1] = p1.getSalenum();
		}
		
		//
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		HSSFRow row1 = sheet.createRow(0);
		HSSFCell cell1 = row1.createCell(0);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
		cell1.setCellValue(titleName);
		
		//创建第二行
		HSSFRow row = sheet.createRow(1);
		for(int i = 0;i<columnNum;i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(columnName[i]);
		}
		//创建数据行
		for(int i =0;i<dataList.length;i++) {
			row =sheet.createRow(i+2);
			HSSFCell datacell = null;
			for(int j=0;j<columnNum;j++) {
				row.createCell(j);
				datacell = row.createCell(j);
				datacell.setCellValue(dataList[i][j]);
			}
		}
		
		//输出excel文件
		OutputStream out = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition","attachment;filename=book_sale_list.xls");
		response.setContentType("application/ms-excel;charset=UTF-8");
		wb.write(out);
		out.close();   //关闭流
		System.out.println(productsList);
		
		/*adminProductService.exportExcel(response,productsList);*/
	}
	}
		
		

