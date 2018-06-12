package com.hwy.blog.unitls;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class dateConfig  {

	private static String year;
	private static String month;
	private static String day;
	
	/*public static void main(String [] args){
		List<String> b = addBlogStartMonth();
		for(String c: b){
			System.out.println(c+"\n");
		}
	}*/
	//博客归档的起始日期
	public static  List<Integer>  blogStrartGuiDang(){
		
		Calendar  calendar  =  Calendar.getInstance(Locale.CHINA);    //获取中国本地日历
		calendar.set(Calendar.YEAR, 2018);
		calendar.set(Calendar.MONTH, 4);
		calendar.set(Calendar.DATE, 1);
		int year  = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day  =  calendar.get(Calendar.DATE);
		List<Integer> dateList =  new ArrayList<Integer>();
		dateList.add(year);
		dateList.add(month);
		dateList.add(day);
		return dateList;
	}
	//归档起始日期到最新日期所经历的月数
	public static List<String> addBlogStartMonth(){
		StringBuilder dateBuilder = new StringBuilder();
		List<String>  dateList = new ArrayList<String>();
		List<Integer> startDate = dateConfig.blogStrartGuiDang();
		Calendar  calendar = Calendar.getInstance();
		int lastYear = calendar.get(Calendar.YEAR);
		int lastMonth = calendar.get(Calendar.MONTH)+1;  //Java中月份是0--11，所以加1
		int firstYear = startDate.get(0);
		int firstMonth = startDate.get(1);
		while(firstYear<=lastYear||firstMonth<=(lastMonth+1)){
			//设置年
			calendar.set(Calendar.YEAR,firstYear);
			year = Integer.toString(calendar.get(Calendar.YEAR));
			dateBuilder.append(year);
			//设置月
			calendar.set(Calendar.MONTH, firstMonth);
			month = Integer.toString(calendar.get(Calendar.MONTH));
			if(calendar.get(Calendar.MONTH)>9){
				dateBuilder.append(month);
			}else{
				dateBuilder.append(0).append(month);
			}
			//设置日
			calendar.set(Calendar.DATE, 1);
			day = Integer.toString(calendar.get(Calendar.DATE));
			dateBuilder.append(0).append(day);
			
			dateList.add(dateBuilder.toString());
			dateBuilder.setLength(0);   //清空缓冲区
			if (firstYear!=lastYear) {
				firstYear++;
			}
			if (firstMonth!=(lastMonth+1)) {
				firstMonth++;
			}else{
				break;
			}
		}
		return dateList;
		
	}
	

}
