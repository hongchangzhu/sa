package com.analysis.utils;

public class Toolkit {

	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static int parseInteger(String str) {
		return Integer.parseInt(str);
	}
}
