<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>



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
				<th>${rfo.getCompany().getAddress().getPostCode()}</th>
				<th>${rfo.getCompany().getBusinessArea()}</th>
				<th>${rfo.getCompany().getSector()}</th>
				<th></th>
			</tr>
		</c:forEach>
	</tbody>
</table>
