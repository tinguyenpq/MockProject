<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>
<link rel="stylesheet" href="${rootPath}/css/login.css" />

<div class="login" style="margin-top: 10%">
	<h1>Login to Homepage</h1>
	<form method="post"
		action="${rootPath}<%=PathConstants.COMMON_LOGIN_PROCESS%>">
		<c:if test="${not empty param.error}">
			<div class="alert alert-danger" role="alert">
				<strong>Oh snap!</strong> Username or password incorrect.
			</div>
		</c:if>
		<p>
			<input type="text" name="username" value="" placeholder="Username">
		</p>
		<p>
			<input type="password" name="password" value=""
				placeholder="Password">
		</p>
		<p class="remember_me">
			<label> <input type="checkbox" name="remember_me"
				id="remember_me"> Remember me on this computer
			</label>
		</p>
		<p class="submit">
			<input type="submit" name="commit" value="Login">
		</p>
	</form>
</div>
