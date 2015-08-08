<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>



<table class="table table-striped">
	<thead>
		<tr>
			<th>#</th>
			<th>RFO Number</th>
			<td>RFO Name</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="rfo" items="${listRFONumber}" varStatus="status">
			<tr>

				<th scope="row">#</th>
				<th>#</th>
				<th>${rfo.rFOName}</th>
			</tr>
		</c:forEach>
	</tbody>
</table>
