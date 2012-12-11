<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="HeadContent.jsp" />
</head>
<body>
	<jsp:include page="Header.jsp" />
	<jsp:include page="Menu.jsp" />
<s:form action="addTransportationRates">
<s:select name="sourceId" list="{'1','2','3'}" headerKey=""
headerValue="Source" label="Select a Source Id" />

<s:select name="destinationId" list="{'1','2','3'}" headerKey=""
headerValue="destination" label="Select a destination Id" />

<s:select name="clientId" list="{'1','2','3'}" headerKey=""
headerValue="client" label="Select a client Id" />
<s:textfield name="amount" label="Amount" />
<s:submit />
</s:form>
	<jsp:include page="Footer.jsp" />
</body>
</html>