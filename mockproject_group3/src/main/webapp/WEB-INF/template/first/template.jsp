<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>

<!DOCTYPE html>
<html>
<head>

<%--METADATA --%>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Nguyen Thanh Tien">

<%-- Title --%>
<tiles:importAttribute name="title" />
<title><spring:message code="${title}"></spring:message></title>

<%-- CSS --%>
<%-- <link rel="stylesheet"
	href="${rootPath}/assets/bootstrap/3.3.5/css/bootstrap.css" /> --%>
<link rel="stylesheet"
	href="${rootPath}/assets/bootstrap/3.3.5/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${rootPath}/assets/bootstrap/3.3.5/css/bootstrap-theme.min.css"> 
<link rel="stylesheet" href="${rootPath}/css/header.css" />
<link rel="stylesheet" href="${rootPath}/css/navbar.css" />
<link rel="stylesheet" href="${rootPath}/css/footer.css" />
<link rel="stylesheet" href="${rootPath}/css/style.css" />

<%--JAVASCRIPT --%>
<script src="${rootPath}/assets/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<%-- <script src="${rootPath}/assets/bootstrap/3.3.5/js/bootstrap.js"></script> --%>
<script type="text/javascript"
	src="${rootPath}/assets/jquery/1.11.3/jquery.min.js"></script>

<%-- Icon --%>
<link rel="icon" href="${rootPath}/img/app.ico">

</head>

<%--Body --%>
<body>

	<%-- NAV bar --%>
	<tiles:insertAttribute name="header" />

	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<%-- right Sidebar --%>
				<tiles:insertAttribute name="left-sidebar" />
			</div>
			<div class="col-md-10">
				<%-- Body --%>
				<tiles:insertAttribute name="body" />
			</div>

		</div>
	</div>

	<%-- Footer --%>
	<tiles:insertAttribute name="footer" />



</body>

</html>