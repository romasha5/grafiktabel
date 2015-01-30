package tb.properties;

public class WhatIsOS {
	
	static String OS = System.getProperty("os.name").toLowerCase();
	private static Integer i;
	
	
	public static Integer getI() {
		
		if(OS.indexOf("win")>=0){
			i = 0;
		}
		else if(OS.indexOf("nux")>=0){
			i = 1;
		}
		
		return i;
	}


}
