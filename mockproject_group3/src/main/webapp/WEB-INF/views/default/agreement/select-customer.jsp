<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>

<c:set var="searchCustomerPath"
	value="${pageContext.request.contextPath}/agreement/search-customer" />
<h1>Search</h1>
<form:form role="form" action="${searchCustomerPath}"
	commandName="customerSearchForm" method="POST">
	<table class="table">
		<tr>
			<td width="200px"><label for="rFONumberInput">RFO
					Number: </label></td>
			<td><form:input path="rFONumber" id="rFONumberInput"
					tabindex="-1" cssErrorClass="input-error" />
				<p></p> <form:errors path="rFONumber" cssclass="error" /></td>
		</tr>
		<tr>
			<td><label for="customerTypeInput">Customer Type: </label></td>
			<td><form:input path="customerType" id="customerTypeInput"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="customerType" cssclass="error" /></td>
		</tr>
		<tr>
			<td><label for="rFONameInput">RFO Name: </label></td>
			<td><form:input path="rFOName" id="rFONameInput"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="rFOName" cssclass="error" /></td>
		</tr>
		<tr>
			<td><label for="postCodeInput">Post Code: </label></td>
			<td><form:input path="postCode" id="postCodeInput"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="postCode" cssclass="error" /></td>
		</tr>
		<tr>
			<td><label for="businessAreaInput">Business Area: </label></td>
			<td><form:input path="businessArea" id="businessAreaInput"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="businessArea" cssclass="error" /></td>
		</tr>
		<tr>
			<td><label for="regionInput">Region: </label></td>
			<td><form:input path="region" id="regionInput"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="region" cssclass="error" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Search" /></td>
			<td></td>
		</tr>
	</table>
</form:form>
<table class="table table-striped">
	<thead>
		<tr>
			<th>#</th>
			<th>RFO Number</th>
			<th>RFO Name</th>
			<th>Customer Type</th>
			<th>Business Area</th>
			<th>PostCode</th>
			<th>Region</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<form:form
			action="${rootPath}<%=PathConstants.AGREEMENT_SELECT_CUSTOMER%>"
			method="POST" commandName="customerSelectForm">
			<c:forEach var="rfo" items="${listRFONumber}" varStatus="status">
				<tr>
					<th scope="row">${status.index +1}</th>
					<th>${rfo.getRFONumber()}</th>
					<th>${rfo.getRFOName()}</th>
					<th>${rfo.getCustomerType().getCustomerTypeName()}</th>
					<th>${rfo.getCompany().getAddress().getPostCode()}</th>
					<th>${rfo.getCompany().getBusinessArea()}</th>
					<th>${rfo.getCompany().getSector()}</th>
					<th><form:radiobutton path="customer"
							id="customer${status.index +1}" value="${rfo.getRFONumber()}"
							cssErrorClass="input-error" /></th>
				</tr>
			</c:forEach>
		</form:form>
	</tbody>
</table>
