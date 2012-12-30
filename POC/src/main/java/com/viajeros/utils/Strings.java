package com.viajeros.utils;


public class Strings {

	public static final String EMPTY = "";
	public static final String BLANK = " ";
	
	

	private Strings() { 
	}

	public static boolean isAlphaNumeric(String aValue) {
		boolean isNumeric = true;
		char[] numbers = aValue.toCharArray();
		int size = numbers.length;
		for (int i = 0; i < size; i++) {
			if (!Character.isLetterOrDigit(numbers[i])) {
				isNumeric = false;
				break;
			}
		}
		return isNumeric;
	}

	public static boolean isNumeric(String aValue) {
		boolean isNumeric = true;
		char[] numbers = aValue.toCharArray();
		int size = numbers.length;
		for (int i = 0; i < size; i++) {
			if (!Character.isDigit(numbers[i])) {
				isNumeric = false;
				break;
			}
		}
		return isNumeric;
	}

	public static boolean isNumericWithDecimalAllowed(String aValue) {
		boolean isNumeric = true;
		char[] numbers = aValue.toCharArray();
		int size = numbers.length;
		char validDecimalChar = '.';
		for (int i = 0; i < size; i++) {
			if (!Character.isDigit(numbers[i])
					&& !(numbers[i] == validDecimalChar)) {
				isNumeric = false;
				break;
			}
		}
		return isNumeric;
	}

	public static boolean hasValue(String aString) {
		if (aString == null)
			return false;
		return aString.trim().length()==0;
	}

	public static boolean containsNumericCharacters(String aString) {
		return aString.matches(".*[0-9]+.*");
	}

	public static boolean containsAlphaCharacters(String aString) {
		return aString.matches(".*[A-Za-z]+.*");
	}
	
	


}
