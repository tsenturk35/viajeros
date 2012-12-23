<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html>
<head>
<jsp:include page="HeadContent.jsp" />

</head>
<body>

	<%-- <jsp:include page="Header.jsp" />
	<jsp:include page="Menu.jsp" />
 --%>
	<div class="container">
		<div class="row">
			<div class="span3">
				<ul class="nav nav-list sidenav affix">
          			<li class=""><a><h4>Administration</h3></a></li>
          			<li class=""><a href="#plugins"><i class="icon-chevron-right"></i> 1. Transportation Rates</a></li>
          			<li class="active"><a href="#variables"><i class="icon-chevron-right"></i> 2. Customize variables</a></li>
          			<li class=""><a href="#download"><i class="icon-chevron-right"></i> 3. Download</a></li>
        		</ul>
      			
			</div>
			
			<div class="span9">
				<div class="page-header">
              		<h1>Destinations</h1>
            	</div>
					
					<display:table name="destinationList" requestURI="/BuyerList.do"  export="true"  
					pagesize="10" decorator="com.viajeros.utils.CommonTableDecorator" class="table table-striped table-bordered"> 
						<display:column property ="destinationId" title="ID" sortable="true"/>
						<display:column property ="name" title="Name" sortable="true"/>
						<display:column property="view" title="View/Edit"  media ="html"/>
						<display:column property="delete" title="Delete"  media ="html"/>   
						<display:setProperty name="export.pdf" value="true" /> 
			            <display:setProperty name="export.pdf.filename" value="Destinaton.pdf"/>
			            <display:setProperty name="export.excel.filename" value="Destination.xls"/>
					</display:table>
					
					<a href="<s:url action='viewDestination' />" ><button class="btn btn-primary" >ADD</button></a>
			</div>
		</div>
					
									
					
	</div>



	<%-- <jsp:include page="Footer.jsp" /> --%>
</body>
</html>