<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>
<h1>Reject Approval</h1>
<form method="post" action="${rootPath}<%=PathConstants.AGREEMENT_REJECT%>">
<table class="table">
	<tbody>
		<tr>
			<td width="200px"><label>RFO Number:</label></td>
			<td>${rfonumber}</td>
			
		</tr>
		<tr>
			<td width="200px"><label>Customer Name:</label></td>
			<td>${com.companyName}</td>
		</tr>
		<tr>
			<td width="200px"><label>Agreement Number:</label></td>
			<td>${agr.agreementNumber} / ${agr.variantNumber}</td>
		</tr>
		<tr>
			<td width="200px"><label>Reasons:</label></td>
			<td><textarea rows="8" cols="25" name="reason"></textarea></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="hidden" name="agrNumber" value="${agr.agreementNumber}">
				<input type="submit" class="btn btn-success" value="Reject" />
			</td>
		</tr>
	</tbody>
</table>

</form>
