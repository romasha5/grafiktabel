package tb.properties;

public class WhatIsOS {
	
	private static String OS;

	public static String getOS() {
		OS = System.getProperty("os.name").toLowerCase();
		return OS;
	}
	
}
