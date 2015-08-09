<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>
<h1>SEARCH AGREEMENT</h1>
<form method="post"
	action="${rootPath}<%=PathConstants.AGREEMENT_SEARCH%>"
	class="form-horizontal" role="form">
	<div class="form-group">
		<label class="control-label col-sm-4" for="cusTypeId">Customer
			Type:</label>
		<div class="col-sm-8">
			<select name="cusTypeId" id="cusTypeId" class="selectpicker"
				data-style="btn-success">
				<c:forEach var="p" items="${cusTypes}">
					<option value="${p.customerTypeId}">${p.customerTypeName}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="cusName">Name:</label>
		<div class="col-sm-8">
			<input type="text" name="cusName" id="cusName" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="cusPostcode">Postcode:</label>
		<div class="col-sm-8">
			<input type="text" name="cusPostcode" id="cusPostcode" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="agrStatusId">Status:</label>
		<div class="col-sm-8">
			<select name="agrStatusId" id="agrStatusId" class="selectpicker"
				data-style="btn-success">
				<c:forEach var="p" items="${agrStatuses}">
					<option value="${p.agreementStatusId}">${p.agreementStatusName}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="startDate">Start
			Date:</label>
		<div class="col-sm-2">
			<input data-provide="datepicker" class="datepicker" name="startDate"
				id="startDate" placeholder="Click to select date" />


		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="endDate">End Date:</label>
		<div class="col-sm-8">
			<div class="input-group">
				<input data-provide="datepicker" class="datepicker" name="endDate"
					id="endDate" placeholder="Click to select date" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="agrNumber">Agreement
			Number:</label>
		<div class="col-sm-8">
			<input type="number" name="agrNumber" id="agrNumber" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-4 col-sm-8">
			<input type="submit" value="Search" class="btn btn-primary" />
		</div>
	</div>
</form>
<script>
	$(function() {
		$('.datepicker').datepicker({
			format : 'dd/mm/yyyy'
		});
		$('.selectpicker').selectpicker();
	});
</script>
<form method="post" action="#">
<table class="table table-striped">
	<thead>
		<tr>
			<th>RFO Number</th>
			<th>Customer</th>
			<th>Postcode</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Agreement</th>
			<th>Status</th>
			<th>Select</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="p" items="${agreementList}" varStatus="status">
		<tr>
			<td>${p.rFONumber}</td>
			<td>${p.companyName}</td>
			<td>${p.postCode}</td>
			<td>
				<fmt:formatDate value="${p.startDate}" var="formattedStartDate"
				 type="date" pattern="dd/MM/yyyy" />
				${formattedStartDate}
			</td>
			<td>
				<fmt:formatDate value="${p.endDate}" var="formattedEndDate"
				 type="date" pattern="dd/MM/yyyy" />
				${formattedEndDate}
			</td>
			<td>${p.agreementNumber} / ${p.variantNumber}</td>
			<td>${p.agreementStatusName}</td>
			<td><input type="radio" name="selected" /></td>
		</tr>
	</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6"></td>
			<td><input type="submit" value="View an agreement" class="btn btn-primary" /></td>
			<td><input type="submit" value="Copy agreement" class="btn btn-primary" /></td>
		</tr>
	</tfoot>
</table>
</form>








