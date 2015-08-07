<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>

<%-- Message --%>
<c:if test="${!empty errorMessage }">
	<div class="alert alert-warning alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
		</button>
		${errorMessage}
	</div>
</c:if>
<h1>
	<spring:message code="htmlException.500.default" />
</h1>
<p>
	<strong>File not found</strong>
</p>

<p>The site configured at this address does not contain the
	requested file.</p>

<p>
	If this is your site, make sure that the filename case matches the URL.<br>
</p>


<a href="${rootPath}<%=PathConstants.COMMON_HOME%>" class="logo"> <img
	width="32" height="32" title="Home" alt="Home"
	src="${rootPath}/img/home_icon.png">
</a>
