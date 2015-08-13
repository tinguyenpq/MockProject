<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>

<c:set var="searchCustomerPath"
	value="${rootPath}/agreement/search-customer" />
<h2>Select Customer</h2>
<form:form role="form" action="${searchCustomerPath}"
	commandName="customerSearchForm" method="POST">
	<table class="table">
		<tr>
			<td width="200px"><label for="rFONumberInput">RFO
					Number: </label></td>
			<td><form:input path="rFONumber" id="rFONumberInput"
					tabindex="-1" cssErrorClass="input-error" />
				<p></p> <form:errors path="rFONumber" class="error" /></td>
		</tr>
		<tr>
			<td><label for="customerTypeInput">Customer Type: </label></td>
			<td><form:select path="customerType" class="selectpicker"
					data-style="btn-success" items="${listCustomerType}"
					itemLabel="customerTypeName" itemValue="customerTypeName"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="customerType" class="error" /></td>


		</tr>
		<tr>
			<td><label for="rFONameInput">RFO Name: </label></td>
			<td><form:input path="rFOName" id="rFONameInput"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="rFOName" class="error" /></td>
		</tr>
		<tr>
			<td><label for="postCodeInput">Post Code: </label></td>
			<td><form:input path="postCode" id="postCodeInput"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="postCode" class="error" /></td>
		</tr>
		<tr>
			<td><label for="businessAreaInput">Business Area: </label></td>
			<td><form:select path="businessArea" class="selectpicker"
					data-style="btn-success" items="${listBusinessArea}"
					itemLabel="configValue" itemValue="configValue"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="businessArea" class="error" /></td>
		</tr>
		<tr>
			<td><label for="regionInput">Region: </label></td>
			<td><form:input path="region" id="regionInput"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="region" class="error" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Search"
				class="btn btn-primary submitSearch" /></td>
			<td></td>
		</tr>
	</table>
</form:form>

<c:set var="selectCustomerUrl"
	value="${rootPath}/agreement/select-customer" />
<form:form action="${selectCustomerUrl}" method="POST"
	commandName="customerSelectForm">
	<form:errors path="customer" class="error alert-danger" />
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
			<c:forEach var="rfo" items="${listRFONumber}" varStatus="status">
				<tr>
					<th scope="row">${status.index +1}</th>
					<th>${rfo.getRFONumber()}</th>
					<th>${rfo.getRFOName()}</th>
					<th>${rfo.getCustomerType().getCustomerTypeName()}</th>
					<th>${rfo.getCompany().getBusinessArea()}</th>
					<th>${rfo.getCompany().getAddress().getPostCode()}</th>
					<th>${rfo.getCompany().getSector()}</th>
					<th><form:radiobutton path="customer"
							id="customer${status.index +1}" value="${rfo.getRFONumber()}" /></th>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="form-group" style="text-align: right;">
		<input type="submit" value="Create agreemen"
			class="btn btn-primary submitSearch" />
	</div>
</form:form>
