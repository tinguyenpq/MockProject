<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>
<h1>search customer</h1>
<form method="post" action="${rootPath}<%=PathConstants.AGREEMENT_SEARCH%>"
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