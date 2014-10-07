<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<title>Search Result</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/index.jsp">Books Manage</a>
			</div>
		</div>
	</nav>
	
	<div class="container">
		<h2>Search Result</h2>
		<table class="table table-hover">
			<tr>
				<td>Title</td>
				<td>Publisher</td>
			</tr>
			<s:iterator value="result">
				<tr>
				<s:url action="detail" var="bookISBN">
		    		<s:param name="ISBN"><s:property value="ISBN"/></s:param>
				</s:url>
				<td><a href="<s:property value="#bookISBN" />"><s:property value="Title" /></a></td>
				<td><s:property value="Publisher" /></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	

</body>
</html>