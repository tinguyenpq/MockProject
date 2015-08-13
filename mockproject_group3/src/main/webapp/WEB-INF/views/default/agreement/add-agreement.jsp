<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>

<c:set var="addAreementUrl" value="${rootPath}/agreement/add-agreement" />
<h2>Select Customer</h2>
<form:form role="form" action="${addAreementUrl}"
	commandName="agreement" method="POST">
	<table class="table">
		<tr>
			<td width="200px"><label for="rFONumberInput">RFO
					Number: </label></td>
			<td><label for="rFONumberInput">${rFONumber.getRFONumber()}</label>
			</td>
		</tr>
		<tr>
			<td width="200px"><label for="rFONumberInput">Customer
					Name: </label></td>
			<td><label for="rFONumberInput">${rFONumber.getRFOName()}</label>
			</td>
		</tr>

		<tr>
			<td><label for="agreementNameInput">Agreement Name: </label></td>
			<td><form:input path="agreementName" id="agreementNameInput"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="agreementName" class="error" /></td>
		</tr>
		<tr>
			<td><label for="descriptionInput">Agreement Description:
			</label></td>
			<td><form:textarea path="description" id="descriptionInput"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="description" class="error" /></td>
		</tr>
		<tr>
			<td><label for="startDateInput">Start Date: </label></td>
			<td><form:input path="startDate" id="startDateInput"
					cssErrorClass="input-error" type="date" />
				<p></p> <form:errors path="startDate" class="error" /></td>
		</tr>
		<tr>
			<td><label for="endDateInput">End Date: </label></td>
			<td><form:input path="endDate" id="endDateInput"
					cssErrorClass="input-error" type="date" />
				<p></p> <form:errors path="endDate" class="error" /></td>
		</tr>
		<tr>
			<td><label for="isSignRequiredInput">Is a signed
					agreement required? </label></td>
			<td><form:radiobutton path="isSignRequired"
					id="isSignRequiredYes" value="1" cssErrorClass="input-error" />YES
				&nbsp;<form:radiobutton path="isSignRequired" id="isSignRequiredNo"
					value="0" cssErrorClass="input-error" />NO
				<p></p> <form:errors path="isSignRequired" cssclass="error" /></td>
		</tr>
	</table>

	<a><input type="submit" value="Next"
		class="btn btn-primary submitSearch" /></a>


</form:form>

