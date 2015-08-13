<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>
<h1>Agreement Complete</h1>
Thank you for creating the agreement.
<div class="row">
	<div class="col-md-1 col-md-offset-8">
		<form action="${rootPath}<%=PathConstants.AGREEMENT_DOCUMENT%>"
			method="post">
			<input type="hidden" name="param" value="${paramAgr}">
			<input type="submit" class="btn btn-primary" value="Print" />
		</form>
	</div>
	<div class="col-md-2">
		<form action="${rootPath}<%=PathConstants.AGREEMENT_VIEW%>"
			method="post">
			<input type="hidden" name="selected" value="${sessionScope.param}">
			<input type="hidden" name="backURI" value="">
			<input type="submit" class="btn btn-primary"
				value="View agreement" />
		</form>
	</div>
</div>