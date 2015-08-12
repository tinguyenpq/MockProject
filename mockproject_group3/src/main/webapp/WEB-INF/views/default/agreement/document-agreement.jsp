<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>
<h1>Generate Agreement Document</h1>

<table class="table">
	<tbody>
		<tr>
			<td width="200px"><label>Agreement Number:</label></td>
			<td>${agr.agreementNumber}/${agr.variantNumber}</td>
		</tr>
		<tr>
			<td width="200px"><label>RFO Number:</label></td>
			<td>${rfonumber}</td>
		</tr>
		<tr>
			<td width="200px"><label>Customer Name:</label></td>
			<td>${com.companyName}</td>
		</tr>

	</tbody>
</table>

<form method="post"
	action="${rootPath}<%=PathConstants.AGREEMENT_GENERATE_DOCUMENT%>">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Category</th>
				<th>Document Name</th>
				<th>Filename</th>
				<th>Select</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Agreement</td>
				<td>Agreement Template 01</td>
				<td>template01-.pdf</td>
				<td><input type="radio" name="selected" id="selected" value="template1" /></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				
				<td colspan="3"><input type="hidden" name="param" value="${paramAgr}" /></td>
				<td><input type="submit" value="Generate document"
					class="btn btn-primary submitView" /></td>
			</tr>
		</tfoot>
	</table>
</form>
<script>
	$(document).ready(function() {
		$(".submitView").click(function() {

			if ($("#selected:checked").length == 0) {
				alert("You must select an template.")
				return false;
			}

			return true;
		});
	});
</script>