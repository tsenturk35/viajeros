<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehicle Type Details</title>
<jsp:include page="HeadContent.jsp" />
</head>
<body>
<jsp:include page="Header.jsp" />
	<jsp:include page="Menu.jsp" />
	<div class="container">
		<div class="row">
			<div class="span4">
				<h3>Enter details</h3>
				<table>
					<tr>
						<td>Tag:</td>
						<td><input type="text" id="tag_input" size="10" /></td>
					</tr>
					<tr>
						<td><input type="button" id="search" value="Search" /></td>
						<td><input type="button" id="reset" value="Reset" /></td>
							<s:form action="VehicleTypeViewEdit.jsp">
						<td><input type="submit"  value="Enter New Details " /></td>
						</s:form>
					</tr>
				</table>

			</div>
			<div class="span10">
				<div id="post-container">
					<div id="post-6272" class="post">
						<h2>Rate Details</h2>
						<div id="post-meta">
							<span id="post-meta-author"> By <a href="#" rel="author">info</a>
								- June 8, 2010
							</span> <span class="post-tag"><a href="#" rel="tag">service
									link</a></span>
						</div>
						<div class="content">
							<table class="userTable" cellpadding="5px" border="2">
								<tr class="even">
									<th>VehicleTypeId</th>
									<th>Name</th>
									<th>Capacity</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
								<s:if test="vehicleTypeList.size() > 0">
									<s:iterator value="vehicleTypeList">
										<tr>
											<td align="center"><s:property value="vehicleTypeId" /></td>
											<td align="center"><s:property value="name" /></td>
											<td align="center"><s:property value="capacity" /></td>
											<td align="center"><s:url id="editURL" action="editVehicleType">
													<s:param name="vehicleTypeId" value="%{vehicleTypeId}"></s:param>
												</s:url> <s:a href="%{editURL}">Edit</s:a></td>
											<td align="center"><s:url id="deleteURL" action="deleteVehicleType">
													<s:param name="vehicleTypeId" value="%{vehicleTypeId}"></s:param>
												</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
										</tr>
									</s:iterator>
								</s:if>
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