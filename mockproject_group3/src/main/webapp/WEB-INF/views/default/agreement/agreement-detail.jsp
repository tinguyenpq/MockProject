<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>

<c:set var="addAreementUrl" value="${rootPath}/agreement/agreement-detail" />
<h2>Basic agreement details</h2>
<c:if test="${not empty error}">
	<div class="alert alert-danger" role="alert">
		<strong>${error}</strong>
	</div>
</c:if>
${rFONumber}
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
					cssErrorClass="input-error" cols="40" />
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
					id="isSignRequiredYes" value="1" cssErrorClass="input-error" />Yes
				&nbsp;&nbsp;<form:radiobutton path="isSignRequired"
					id="isSignRequiredNo" value="0" cssErrorClass="input-error" />No
				<p></p> <form:errors path="isSignRequired" cssclass="error" /></td>
		</tr>
		<tr>
			<td><label for="fundingMethodInput">Funding Method: </label></td>
			<td><form:select path="fundingMethod" class="selectpicker"
					data-style="btn-success" items="${listFundingMethod}"
					itemLabel="configValue" itemValue="configValue"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="fundingMethod" class="error" /></td>
		</tr>
		<tr>
			<td><label for="PaymentToInput">Payment To: </label></td>
			<td><form:select path="paymentTo" class="selectpicker"
					data-style="btn-success" items="${listPaymentTo}"
					itemLabel="configValue" itemValue="configValue"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="paymentTo" class="error" /></td>
		</tr>
		<tr>
			<td><label for="AgendaPaymentInput">Agenda Payment: </label></td>
			<td><form:select path="agendaPayment" class="selectpicker"
					data-style="btn-success" items="${listAgendaPayment}"
					itemLabel="configValue" itemValue="configValue"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="agendaPayment" class="error" /></td>
		</tr>


		<tr>
			<td><label for="handlingChargeInput">Handling Charge: </label></td>
			<td><form:input path="handlingCharge" id="handlingChargeInput"
					cssErrorClass="input-error" type="number" />
				<p></p> <form:errors path="handlingCharge" class="error" /></td>
		</tr>

		<tr>
			<td><label for="DealerVisibilityInput">Dealer
					Visibility: </label></td>
			<td><form:select path="dealerVisibility" class="selectpicker"
					data-style="btn-success" items="${listDealerVisibility}"
					itemLabel="configValue" itemValue="configValue"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="dealerVisibility" class="error" /></td>
		</tr>

		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td><label for="DealerVisibilityInput">Volume Discount
					Type: </label></td>
			<td><form:select path="volumeDiscountType" class="selectpicker"
					data-style="btn-success" items="${listVolumeDiscountType}"
					itemLabel="configValue" itemValue="configValue"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="volumeDiscountType" class="error" /></td>
		</tr>

		<tr>
			<td><label for="discountUnitInput">Discount Unit: </label></td>
			<td><form:select path="discountUnit" class="selectpicker"
					data-style="btn-success" items="${listDiscountUnit}"
					itemLabel="configValue" itemValue="configValue"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="discountUnit" class="error" /></td>
		</tr>


		<tr>
			<td><label for="combinabilityInput">Combinability: </label></td>
			<td><form:select path="combinability" class="selectpicker"
					data-style="btn-success" items="${listCombinability}"
					itemLabel="configValue" itemValue="configValue"
					cssErrorClass="input-error" />
				<p></p> <form:errors path="combinability" class="error" /></td>
		</tr>
	</table>

	<a><input type="submit" value="Save as draft"
		class="btn btn-primary submitSearch" /></a>
	<a><input type="submit" value="Back"
		class="btn btn-primary submitSearch" /></a>
	<a><input type="submit" value="Next"
		class="btn btn-primary submitSearch" /></a>



</form:form>

