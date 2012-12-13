<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<jsp:include page="HeadContent.jsp" />

</head>
<body>

	<jsp:include page="Header.jsp" />
	<jsp:include page="Menu.jsp" />

	<div class="container">
		<div class="row"></div>
		<div class="span10">
			<div id="post-container">
				<div id="post-6272" class="post">
					<h2>Destination List</h2>
					<div id="post-meta">
						<span id="post-meta-author"> By <a href="#" rel="author">info</a>
							- June 8, 2010
						</span> <span class="post-tag"><a href="#" rel="tag">service
								link</a></span>
					</div>
					<div class="post-content">
					
					
					<s:iterator value="destinationList">
						
						<s:property value="destinationId"/> - 
						<s:property value="desc"/>
						<br/>
					</s:iterator>
					<s:bean name="test"/> -
					
					
					</div>


				</div>
			</div>
		</div>
	</div>



	<jsp:include page="Footer.jsp" />
</body>
</html>