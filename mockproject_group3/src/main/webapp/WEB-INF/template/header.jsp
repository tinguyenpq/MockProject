<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>


<!--  Fixed Header  -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand"
				href="${rootPath}<%=PathConstants.COMMON_HOME %>"><spring:message
					code="navbar.project.name" /></a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="${rootPath}<%=PathConstants.COMMON_HOME %>"><spring:message
							code="navbar.home" /></a></li>
				<li><a href="#about">About</a></li>
			</ul>
			<span style="float: right;"><spring:message
					code="navbar.language" />: <a href="?lang=en"><spring:message
						code="navbar.english" /></a> | <a href="?lang=vi"><spring:message
						code="navbar.vietnamese" /></a> </span>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<li><a> <spring:message code="header.welcome" />,
							${userPrincipalName}
					</a></li>
					<li><a href="${rootPath}<%=PathConstants.COMMON_LOGOUT%>"><i
							class="glyphicon glyphicon-off"></i> <spring:message
								code="header.logout" /></a></li>
				</c:if>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>















