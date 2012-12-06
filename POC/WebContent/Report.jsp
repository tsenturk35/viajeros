<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tookitaki Test Server</title>

<jsp:include page="HeadContent.jsp" />	

</head>
<body>

	<jsp:include page="Header.jsp" />
	<jsp:include page="Menu.jsp" />

<div class="container">
		<div class="row">
			
			<div class="span10">
				<div id="post-container">
					<div id="post-6272" class="post">
						<h2>Test Report</h2>
						<div id="post-meta"> 
							<span id="post-meta-author"> By <a href="#" rel="author">info</a> - June 8, 2010 </span> 
							<span class="post-tag"><a href="#" rel="tag">service link</a></span>
						</div>
						<div class="post-content">
						
						<table border="1px" cellpadding="8px">
							<tr>
								<th>Id</th>
								<th>Input</th>
								<th>Service</th>
								<th>total</th>
								<th>correct</th>
								<th>comment</th>
								<th>Created By</th>
								<th>Created Date</th>
							</tr>
							
								<s:iterator value="reportList" status="userStatus">
									<tr>
										<td><s:property value="id" /></td>
										<td><s:property value="tag" /></td>
										<td><s:property value="service.name" /></td>
										<td><s:property value="totalResults" /></td>
										<td><s:property value="correctResults" /></td>
										<td><s:property value="comment" /></td>
										<td><s:property value="lastupdatedBy" /></td>
										<td><s:date name="lastupdatedDate" format="dd/MM/yyyy" /></td>
									</tr>
								</s:iterator>
							
						</table>
						
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="Footer.jsp" />
</body>
</html>