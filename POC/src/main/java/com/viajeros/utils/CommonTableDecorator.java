package com.viajeros.utils;

import org.apache.commons.lang.StringEscapeUtils;
import org.displaytag.decorator.TableDecorator;

import com.viajeros.entity.IOperable;

public class CommonTableDecorator extends TableDecorator {
	
	public String getAction(){
		
		String id = ((IOperable)getCurrentRowObject()).getPrimaryId();
		String entityName = (String) getPageContext().getRequest().getAttribute(Constants.ENTITY_NAME_KEY);
		String editUrl = getEditUrl(id,entityName);
		String deleteUrl = getDeleteUrl(id,entityName);
		
		
		return  "<div class='controls center'>"+
        "<a href=\""+editUrl+"\" title='Edit' class='tip'><span class='icon12 icomoon-icon-pencil'></span></a>"+
        "<a href=\""+deleteUrl+"\" title='Remove' class='tip'><span class='icon12 icomoon-icon-remove'></span></a>"+
        "</div>";
	}

	private String getDeleteUrl(String id, String pageName) {
		String url = "delete"+pageName+".action?"+Constants.PRIMARY_ID_KEY+"="+id;
		url =  StringEscapeUtils.escapeHtml(url);
		String finalUrl = "javascript:deleteEntity('"+url+"');";
		return StringEscapeUtils.escapeHtml(finalUrl);
	}

	private String getEditUrl(String id, String pageName) {
		return StringEscapeUtils.escapeHtml("view"+pageName+".action?"+Constants.PRIMARY_ID_KEY+"="+id);
	}
		

}
