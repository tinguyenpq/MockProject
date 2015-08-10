<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>

<%-- Message --%>
<c:if test="${!empty error }">
	<div class="alert alert-warning alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
		</button>
		${error}
	</div>
</c:if>


<h1>
	<spring:message code="htmlException.403.default" />
</h1>
<p>
	Access is forbidden to the requested page.<br>
</p>

<a href="${rootPath}<%=PathConstants.COMMON_HOME%>" class="logo"> <img width="32" height="32" title="Home"
	alt="Home" src="${rootPath}/img/home_icon.png">
</a>
