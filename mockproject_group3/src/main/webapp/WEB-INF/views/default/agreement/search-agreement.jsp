<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>
<h1>search customer</h1>
<form method="post" action="#">
	<table>
		<tr>
			<td>Customer Type</td>
			<td><select name="cusTypeId" id="cusTypeId" class="selectpicker"
				data-style="btn-primary">
					<c:forEach var="p" items="${cusTypes}">
						<option value="${p.customerTypeId}">${p.customerTypeName}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="cusName" id="cusName" /></td>
		</tr>
		<tr>
			<td>Postcode</td>
			<td><input type="text" name="cusPostcode" id="cusPostcode" /></td>
		</tr>
		<tr>
			<td>
			<td>
		</tr>
		<tr>
			<td>Status</td>
			<td><select name="agrStatusId" id="agrStatusId"
				class="selectpicker" data-style="btn-success">
					<c:forEach var="p" items="${agrStatuses}">
						<option value="${p.agreementStatusId}">${p.agreementStatusName}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Start Date</td>
			<td>
				<div class="input-group date">
					<input data-provide="datepicker" class="datepicker" />
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-th" aria-hidden="true"></span>
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td>End Date</td>
			<td><div class="input-group date">
					<input data-provide="datepicker" class="datepicker" />
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-th" aria-hidden="true"></span>
					</div>
				</div></td>
		</tr>
		<tr>
			<td>Agreeement Number</td>
			<td><input type="number" name="agrNumber" id="agrNumber" /></td>
		</tr>
	</table>

</form>
<script>
	$(function() {
		$('.datepicker').datepicker({
			format : 'dd/mm/yyyy'
		});
		$('.selectpicker').selectpicker();
	});
</script>