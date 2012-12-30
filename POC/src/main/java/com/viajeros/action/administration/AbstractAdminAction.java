package com.viajeros.action.administration;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAdminAction extends ActionSupport implements IAdminAction{
	
	private static final long serialVersionUID = 1312973100931231877L;
	
	private String primaryId;

	public String getPrimaryId() {
		return primaryId;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}
	
}
