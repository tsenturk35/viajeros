package com.viajeros.utils;

public class Booleans {

	public static boolean booleanValue(Boolean aBoolean) {
		if (aBoolean == null)
			return false;
		return aBoolean.booleanValue();
	}

	public static boolean hasValue(Boolean aBoolean) {
		if (aBoolean == null)
			return false;
		return true;
	}

	public static boolean fromString(String aString) {
		if ("true".equals(aString))
			return true;
		return false;
	}
}
