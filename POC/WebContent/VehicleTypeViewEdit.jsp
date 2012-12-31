								
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

                    <h3>Destination</h3>                    

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
                        <li class="active">Vehicle Type</li>
                    </ul>

                </div><!-- End .heading-->

                <!-- Build page from here: -->
                <div class="row-fluid">
                	<div class="span12">

                            <div class="box gradient">

                                <div class="title">
                                    
                                    <h4 class="clearfix"><span class="left">Vehicle Type View/Edit</span>
                                    <a href="<s:url action='listVehicleType' />" class="right box-form">
                                    		<button class="btn" >Back</button>
                                	</a>
                                    </h4>
                                </div>

							<div class="content noPad clearfix">
							
							<s:form action="saveVehicleType" cssClass="form-horizontal">
								<s:textfield name="vehicleTypeId" label="Vehicle Type Id" />
								<s:textfield name="name" label="Name" />
								<s:textfield name="capacity" label="Capacity" />
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