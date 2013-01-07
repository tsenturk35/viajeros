package com.viajeros.action.administration;

public interface IAdminAction {
	
	public  String list();
	
	public  String view();
	
	public  String save();
	
	public  String delete();
	
	public String getPrimaryId() ;

	public void setPrimaryId(String primaryId) ;
	
	
	public String getEntityName();
}
