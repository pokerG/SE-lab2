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
<title>Books Manage</title>
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
		<div class="container">
			<img src="image/book.jpg"  class="bookimg">	
		</div>
		<h1 class="text-center">Search Books</h1>
		<s:actionerror cssClass="alert alert-danger" />
		<div class="search-box">
			<s:form action="main" method="post" cssClass="form-inline">
				<s:textfield label="Author Name" name="keyword" size="20" cssClass="form-control"></s:textfield>
		    	<s:submit type="button" method="execute" name="Search" value="Search" align="center" cssClass="btn btn-default" />
			</s:form>
		</div>
	</div>
	

</body>
</html>