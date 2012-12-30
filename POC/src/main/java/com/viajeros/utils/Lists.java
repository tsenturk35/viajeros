package com.viajeros.utils;

import java.util.Collection;


public class Lists {
	

	public static boolean hasValue(Collection<?> aList){
		if(aList==null)
			return false;
		
		return !aList.isEmpty();
	}
	
		
	

}
