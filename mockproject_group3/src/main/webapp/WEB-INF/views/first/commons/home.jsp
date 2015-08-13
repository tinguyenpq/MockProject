<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>
<h1>Corporate sales solution</h1>
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Agreements</h3>
	</div>
	<div class="panel-body">
		<c:forEach items="${listCountStatusAgreement}" var="c">
			<tr>
				<td>${c.getCount()}</td>
				<td>${c.getAgreementStatusName()}</td>
			</tr>
		</c:forEach>
	</div>
</div>
