<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transportation Rate Details</title>
<jsp:include page="HeadContent.jsp" />
</head>
<body>
<jsp:include page="Header.jsp" />
	<jsp:include page="Menu.jsp" />

	<div class="content">
		<table class="userTable" cellpadding="5px">
			<tr class="even">
				<th>src_id</th>
				<th>dest_id</th>
				<th>client_id</th>
				<th>vehicle_typ_id</th>
				<th>amount</th>
			</tr>
			<s:if test="transportationRateList.size() > 0">
				<s:iterator value="transportationRateList" status="userStatus">
					<tr>
						<td><s:property value="sourceId" /></td>
						<td><s:property value="destinationId" /></td>
						<td><s:property value="clientId" /></td>
						<td><s:property value="VehicleTypeId" /></td>
						<td><s:property value="amount" /></td>
						<td><s:url id="editURL" action="editUser">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{editURL}">Edit</s:a></td>
						<td><s:url id="deleteURL" action="deleteUser">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
					</tr>
				</s:iterator>
			</s:if>
		</table>
	</div>

<jsp:include page="Footer.jsp" />
</body>
</html>