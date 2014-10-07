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
<title>Book Detail</title>
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
		<h2>Book Information</h2>
		<table class="table">
			<tr class="info">
				<td>ISBN</td>
				<td>Title</td>
				<td>Author</td>
				<td>Publisher</td>
				<td>Publish Date</td>
				<td>Price(RMB)</td>
			</tr>
			<tr>
				<td><s:property value="book.ISBN" /></td>
				<td><s:property value="book.Title" /></td>
				<td><s:property value="book.Author" /></td>
				<td><s:property value="book.Publisher" /></td>
				<td><s:property value="book.PublishDate" /></td>
				<td><s:property value="book.Price" /></td>
			</tr>
		</table>
		<h2>Author Information</h2>
		<table class="table">
			<tr class="success">
				<td>Name</td>
				<td>Age</td>
				<td>Country</td>
			</tr>
			<tr>
				<td><s:property value="author.Name" /></td>
				<td><s:property value="author.Age" /></td>
				<td><s:property value="author.Country" /></td>
			</tr>
		</table>
		<s:form action="edit" method="post" cssClass="form-inline">
			<s:hidden name="ISBN" value="%{book.ISBN}" />
			<%-- <s:submit method="edit" value="Edit" align="center" disabled="true" /> --%>
			<s:submit type="button" method="delete" value="Delete" align="center" cssClass="btn btn-danger"/>
		</s:form>
	</div>
	
	

</body>
</html>