<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>

<%-- Footer --%>
<div class="sidebar">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Menu</h3>
		</div>
		<div class="panel-body">Panel content</div>
	</div>
	<div class="list-group">
		<a href="#" class="list-group-item active"> Menu </a> <a href="${rootPath}<%=PathConstants.AGREEMENT_ADD_AGREEMENT %>"
			class="list-group-item">Add new an agreement</a> <a href="${rootPath}<%=PathConstants.AGREEMENT_COPY %>"
			class="list-group-item">Copy an agreement</a> <a href="${rootPath}<%=PathConstants.AGREEMENT_SEARCH%>"
			class="list-group-item">Search agreement</a> <a href="#"
			class="list-group-item">New tab 4</a>
	</div>
</div>