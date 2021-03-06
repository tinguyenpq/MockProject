<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>


<c:if test="${!empty error }">
	<div class="alert alert-warning alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
		</button>
		${error}
	</div>
</c:if>
<c:if test="${!empty denied }">
	<div class="alert alert-warning alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
		</button>
		${denied}
	</div>
</c:if>

<h1>
	<spring:message code="htmlException.404.default" />
</h1>

<c:if test="${not empty param.denied}">
	<div class="alert alert-danger" role="alert">
		<strong>Oh snap!</strong> ${denied}
	</div>
</c:if>

<p>
	The server can not find the requested page..<br>
</p>

<a href="${rootPath}<%=PathConstants.COMMON_HOME%>" class="logo"> <img
	width="32" height="32" title="Home" alt="Home"
	src="${rootPath}/img/home_icon.png">
</a>
