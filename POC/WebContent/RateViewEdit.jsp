								
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<jsp:include page="HeadContent.jsp" />
	
</head>
      
    <body>
    
	<jsp:include page="Header.jsp" />

    <div id="wrapper">
    
    	<jsp:include page="Menu.jsp" />


        <!--Body content-->
        <div id="content" class="clearfix">
            <div class="contentwrapper"><!--Content wrapper-->

                <div class="heading">

                    <h3>Detention Rates</h3>                    

                    <div class="resBtnSearch">
                        <a href="#"><span class="icon16 brocco-icon-search"></span></a>
                    </div>

                    <div class="search">

                        <form id="searchform" action="search.html" />
                            <input type="text" id="tipue_search_input" class="top-search" placeholder="Search here ..." />
                            <input type="submit" id="tipue_search_button" class="search-btn" value="" />
                        </form>
                
                    </div><!-- End search -->
                    
                    <ul class="breadcrumb">
                        <li>You are here:</li>
                        <li>
                            <a href="#" class="tip" title="back to dashboard">
                                <span class="icon16 icomoon-icon-screen"></span>
                            </a> 
                            <span class="divider">
                                <span class="icon16 icomoon-icon-arrow-right"></span>
                            </span>
                        </li>
                        <li class="active">Detention Rate</li>
                    </ul>

                </div><!-- End .heading-->

                <!-- Build page from here: -->
                <div class="row-fluid">
                	<div class="span12">

                            <div class="box gradient">

                                <div class="title">
                                    
                                    <h4 class="clearfix"><span class="left">Detention Rate View/Edit</span>
                                    <a href="<s:url action='listDetenetionRate' />" class="right box-form">
                                    	<button class="btn btn-info"><span class="icon16 typ-icon-back white"></span> Back</button>
                                	</a>
                                    </h4>
                                </div>

							<div class="content noPad clearfix">

								<s:form action="saveDetentionRate"	cssClass="form-horizontal">
									<s:select name="detentionRate.sourceId"  list ="destinationIdList" listKey="destinationId" listValue="name" 
									 headerKey="-1"	headerValue="-- Select Source --" label="Source" />

									<s:select name="detentionRate.destinationId" list ="destinationIdList" listKey="destinationId" listValue="name"
										headerKey="-1"	headerValue="-- Select Destination --" label="Destination" />
									
									<s:select name="detentionRate.clientId" list="clientIdList"  listKey="clientId" listValue="clientName"
									headerKey="-1" headerValue="-- Select Client --" label="Client" />

									<s:select name="detentionRate.vehicleTypeId" list="vehicletypeIdList"  listKey="vehicleTypeId" listValue="name"
									headerKey="-1" headerValue="-- Select Vehicle Type --" label="Vehicle Type" />

									<s:textfield name="detentionRate.amount" label="Amount" />
									<s:textfield name = "detentionRate.detentionDays" label = "Detention Days"/>
									<s:hidden name="detentionRate.detentionRateId" />
									<s:hidden name="detentionRate.version" />
									<s:submit type="button" value="Save Changes"/>
								</s:form>
							</div>

						</div>
                     </div>

                                       
                </div>
                
            </div><!-- End contentwrapper -->
        </div><!-- End #content -->
    
    </div><!-- End #wrapper -->
    
   	<jsp:include page="Footer.jsp" />
   	
  
   	
    </body>
</html>								