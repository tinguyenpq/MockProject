<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>

<c:set var="searchDealerPath"
	value="${rootPath}/agreement/search-dealer" />
<h2>Select Dealer</h2>
<form:form role="form" action="${searchDealerPath}"
	commandName="dealerSearchForm" method="POST">
	<table class="table">
		<tr>
			<td width="200px"><label for="dealerCodeInput">Dealer
					Code: </label></td>
			<td><form:input path="dealerCode" id="dealerCodeInput"
					tabindex="-1" cssErrorClass="input-error" />
				<p></p> <form:errors path="dealerCode" class="error" /></td>
		</tr>
		<tr>
			<td><label for="dealerNameInput">Dealer Name: </label></td>
			<td><form:input path="dealerName" id="dealerNameInput"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="dealerName" class="error" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Search"
				class="btn btn-primary submitSearch" /></td>
			<td></td>
		</tr>
	</table>
</form:form>

<c:set var="selectDealerNextPath"
	value="${rootPath}/agreement/select-dealer" />
<form:form action="${selectDealerNextPath}" method="POST"
	commandName="agreement">
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Code</th>
				<th>Name</th>
				<th>Town</th>
				<th>County</th>
				<th>Action</th>
			</tr>
			
		</thead>
		<tbody>
			<c:forEach var="dealer" items="${listDealers}" varStatus="status">
				<tr>
					<th>${dealer.getDealerCode()}</th>
					<th>${dealer.getDealerName()}</th>
					<th>${dealer.getTown()}</th>
					<th>${dealer.getCountry()}</th>
					
					
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="form-group" style="text-align: right;">
		<input type="submit" value="Next"
			class="btn btn-primary submitSearch" />
	</div>
</form:form>
