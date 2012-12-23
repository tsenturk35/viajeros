package com.viajeros.utils;

import org.displaytag.decorator.TableDecorator;

public class CommonTableDecorator extends TableDecorator {
	
	public String getView(){
		return "<a title=\"Edit\" href='#'><i class=\"icon-pencil\"></i></a>";
	}
	
	public String getDelete(){
		return "<a title=\"Delete\" href='#'><i class='icon-trash'></i></a>";
	}

}
