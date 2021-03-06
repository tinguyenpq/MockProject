<%-- Settings --%>
<%@page import="vn.tdt.mockproject.common.constant.ViewConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>
<c:set var="searchAgreementPath"
	value="${rootPath}/agreement/search-agreement" />
<h2 class="section-heading">Search Agreement</h2>
<form:form method="post" action="${searchAgreementPath}"
	class="form-horizontal" role="form" commandName="agrSearchForm">

	<div class="form-group">
		<label class="control-label col-sm-4" for="cusTypeId">Customer
			Type:</label>
		<div class="col-sm-8">
			<form:select path="cusTypeId" class="selectpicker"
				data-style="btn-success" items="${cusTypes}"
				itemLabel="customerTypeName" itemValue="customerTypeId" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="cusName">Name:</label>
		<div class="col-sm-8">
			<form:input path="cusName" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="cusPostcode">Postcode:</label>
		<div class="col-sm-8">
			<form:input path="cusPostcode" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="agrStatusId">Status:</label>
		<div class="col-sm-8">
			<form:select path="agrStatusId" class="selectpicker"
				data-style="btn-success" items="${agrStatuses}"
				itemLabel="agreementStatusName" itemValue="agreementStatusId" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="startDate">Start
			Date:</label>
		<div class="col-sm-2">
			<form:input path="startDate" data-provide="datepicker"
				class="datepicker" placeholder="Click to select date" id="startDate" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="endDate">End Date:</label>
		<div class="col-sm-8">
			<div class="input-group">
				<form:input path="endDate" data-provide="datepicker" id="endDate"
					class="datepicker" placeholder="Click to select date" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="agrNumber">Agreement
			Number:</label>
		<div class="col-sm-8">
			<form:input path="agrNumber" id="agrNumber" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-4 col-sm-8">
			<input type="submit" value="Search"
				class="btn btn-primary submitSearch" />
		</div>
	</div>
</form:form>
<script>
	$(function() {
		$('.datepicker').datepicker({
			format : 'dd/mm/yyyy'
		});
		$('.selectpicker').selectpicker();
	});
</script>
<form method="post"
	action="${rootPath}<%=PathConstants.AGREEMENT_VIEW%>">
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
			<c:choose>
				<c:when test="${message eq null}">
					<c:forEach var="p" items="${agreementList}" varStatus="status">
						<tr>
							<td>${p.rFONumber}</td>
							<td>${p.companyName}</td>
							<td>${p.postCode}</td>
							<td><fmt:formatDate value="${p.startDate}"
									var="formattedStartDate" type="date" pattern="dd/MM/yyyy" />
								${formattedStartDate}</td>
							<td><fmt:formatDate value="${p.endDate}"
									var="formattedEndDate" type="date" pattern="dd/MM/yyyy" />
								${formattedEndDate}</td>
							<td>${p.agreementNumber}/${p.variantNumber}</td>
							<td>${p.agreementStatusName}</td>
							<td><input type="radio" name="selected" id="selected"
								value='<c:out value="${p.rFONumber}///${p.companyId}///${p.addressId}///${p.agreementNumber}///${p.variantNumber}"></c:out>' />
							</td>

						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="8" align="center" style="color: red;">${message}</td>
					</tr>
				</c:otherwise>
			</c:choose>

		</tbody>
		<tfoot>
			<c:if test="${message eq null && agreementList ne null}">
				<tr>
					<td colspan="6"><input type="hidden" name="backURI"
						value="${rootPath}<%=PathConstants.AGREEMENT_SEARCH%>" /></td>
					<td><input type="submit" value="View an agreement"
						class="btn btn-primary submitView" /></td>
					<td><input type="submit" value="Copy agreement"
						class="btn btn-primary submitView" /></td>
				</tr>
			</c:if>
		</tfoot>
	</table>
</form>

<script src="${rootPath}/js/search-agreement-validation.js"></script>








