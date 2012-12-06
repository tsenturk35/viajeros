<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<jsp:include page="HeadContent.jsp" />
<s:head />
</head>
<body>

	<jsp:include page="Header.jsp" />
	<jsp:include page="Menu.jsp" />

	<div class="container">
		<div class="row">
			<div class="span4">
			<h3>Enter Tags</h3>
			<s:form action="getUsersByTag" >
				<s:textfield name="tag" label="Tag" javascriptTooltip="Enter Comma separated Tags" required="true"/>
				<s:submit />
			</s:form>
			<h5>Select Tag</h5>
			<s:iterator value="tags">
				<div style="padding-top:5px;padding-bottom:5px;">
					<span class="post-tag">
						
						<s:url action="getUsersByTag.action" var="tagUrl" >
    						<s:param name="tag"><s:property/></s:param>
						</s:url>
						<a href="<s:property value="#tagUrl" />" ><s:property/></a>
					</span>
				</div>
			</s:iterator>
			</div>
			<div class="span10">
				<div id="post-container">
					<div id="post-6272" class="post">
						<h2>Test Users by Tag</h2>
						<div id="post-meta"> 
							<span id="post-meta-author"> By <a href="#" rel="author">info</a> - June 8, 2010 </span> 
							<span class="post-tag"><a href="#" rel="tag">service link</a></span>
						</div>
							<div class="post-content">
								<ul class="user_result">
								<s:iterator value="userResult">
									<li>
										<a href='<s:property value="link"/>'>
										<img src='<s:property value="name"/>' ></img>
										<s:property value="name"/> - <s:property value="score"/>
										</a>
									</li>
								</s:iterator>
								</ul>
								
							</div>
							

					</div>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="Footer.jsp" />
</body>
</html>