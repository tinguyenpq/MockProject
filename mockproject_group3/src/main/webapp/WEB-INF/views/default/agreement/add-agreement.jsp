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
			<td><label for="rFONumberInput">agreement.getRFONumber()</label>
			</td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Next"
				class="btn btn-primary submitSearch" /></td>
			<td></td>
		</tr>
	</table>
</form:form>

