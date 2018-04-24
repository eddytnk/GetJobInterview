package edu.mum.common;

import java.time.Year;
import java.util.ArrayList;
//import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Helper {

	public static List<Integer> getYears(){
		List<Integer> years = new ArrayList<Integer>();
		int yearToday = Year.now().getValue(); //today.getYear();
		//System.out.println("======================================yearToday: "+ yearToday);
		int yearInit = yearToday - 50;
		int yearEnd = yearInit + 100;
		for(int i = yearInit; i<yearEnd;i++ ) {
			years.add(i);
		}
		return years;
	}
	
	public static HashMap<Integer, String> mapMonths(){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "January");
		map.put(2, "February");
		map.put(3, "March");
		map.put(4, "April");
		map.put(5, "May");
		map.put(6, "June");
		map.put(7, "July");
		map.put(8, "August");
		map.put(9, "September");
		map.put(10, "October");
		map.put(11, "November");
		map.put(12, "December");		
		return map;		
	}
	public static List<String> getImageExtentions(){
		List<String> imageExtentions = new ArrayList<String>();
		imageExtentions.add(".jpg");
		imageExtentions.add(".bmp");
		imageExtentions.add(".png");
		return imageExtentions;		
	}
	public static String getImageExt(String fileName) {
		String fileExt="";
		List<String> allowedExtentions = getImageExtentions();
    	for(String ext : allowedExtentions) {
    		if(fileName.endsWith(ext)) {
    			fileExt=ext;
    		}
    	}
		return fileExt;
	}

}
