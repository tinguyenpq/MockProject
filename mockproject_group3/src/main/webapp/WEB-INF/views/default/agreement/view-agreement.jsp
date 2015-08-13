<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>
<h1>customer</h1>
<c:choose>
	<c:when test="${message ne null}">
		<p align="center" style="color: red;">${message}</p>
	</c:when>
	<c:otherwise>
		<table class="table">
			<tbody>
				<tr>
					<td width="200px"><label>Agreement:</label></td>
					<td>${agr.agreementName}</td>
				</tr>
				<tr>
					<td width="200px"><label>RFO Number:</label></td>
					<td>${rfonumber}</td>
				</tr>
				<tr>
					<td width="200px"><label>Customer Name:</label></td>
					<td>${com.companyName}</td>
				</tr>
				<tr>
					<td width="200px"><label>Start - End:</label></td>
					<td><fmt:formatDate value="${agr.startDate}"
							var="formattedStartDate" type="date" pattern="dd MMM yyyy" /> <fmt:formatDate
							value="${agr.endDate}" var="formattedEndDate" type="date"
							pattern="dd MMM yyyy" /> ${formattedStartDate} -
						${formattedEndDate}</td>
				</tr>
				<tr>
					<td width="200px"><label>Status:</label></td>
					<td>${agr.agreementStatus.agreementStatusName}</td>
				</tr>
			</tbody>
		</table>

		<div>

			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#orverview"
					aria-controls="orverview" role="tab" data-toggle="tab">Orverview</a></li>
				<li role="presentation"><a href="#dealers"
					aria-controls="dealers" role="tab" data-toggle="tab">Dealers</a></li>
				<li role="presentation"><a href="#volume"
					aria-controls="volume" role="tab" data-toggle="tab">Volume</a></li>
				<li role="presentation"><a href="#misctext"
					aria-controls="misctext" role="tab" data-toggle="tab">Misc Text</a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane fade in active" id="orverview">
					<table class="table">
						<tbody>
							<tr>
								<td width="200px"><label>Business Area:</label></td>
								<td>${com.businessArea}</td>
							</tr>
							<tr>
								<td width="200px"><label>Agreement Details:</label></td>
								<td>${agr.description}</td>
							</tr>
							<tr>
								<td width="200px"><label>Created By:</label></td>
								<td>${agr.createdBy}</td>
							</tr>
							<tr>
								<td width="200px"><label>Created Date:</label></td>
								<td><fmt:formatDate value="${agr.createdDate}"
										var="formattedCreatedDate" type="date" pattern="dd MMM yyyy" />
									${formattedCreatedDate}</td>
							</tr>
							<tr>
								<td width="200px"><label>Authorised By:</label></td>
								<td></td>
							</tr>
							<tr>
								<td width="200px"><label>Authorised Date:</label></td>
								<td></td>
							</tr>
							<tr>
								<td width="200px"><label>Signed agreement required?</label></td>
								<td><c:choose>
										<c:when test="${agr.isSignRequired eq true}">
									YES
								</c:when>
										<c:otherwise>
									NO
								</c:otherwise>
									</c:choose></td>
							</tr>
							<tr>
								<td width="200px"><label>Payment to:</label></td>
								<td>${agr.paymentTo}</td>
							</tr>
							<tr>
								<td width="200px"><label>Handling Charge:</label></td>
								<td>£${agr.handlingCharge}</td>
							</tr>
							<tr>
								<td width="200px"><label>Agenda Payment:</label></td>
								<td>${agr.agendaPayment}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div role="tabpanel" class="tab-pane fade" id="dealers">
					<table class="table">
						<thead>
							<tr>
								<th>Code</th>
								<th>Name</th>
								<th>Town</th>
								<th>Country</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${dealerList}" var="p">
								<tr>
									<td>${p.dealerCode}</td>
									<td>${p.dealerName}</td>
									<td>${p.town}</td>
									<td>${p.country}</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				<div role="tabpanel" class="tab-pane fade" id="volume">
					<table class="table">
						<tbody>
							<tr>
								<td width="200px"><label>Trigger Credit</label></td>
								<td>${vol.triggerCredit}</td>
							</tr>
							<tr>
								<td width="200px">Payable To</td>
								<td>${vol.paymentTo}</td>
							</tr>
						</tbody>
					</table>
					<table class="table">
						<thead>
							<tr>
								<th>Min</th>
								<th>Max</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${bandings}" var="p">
								<tr>
									<td>${p.min}</td>
									<td>${p.max}</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				<div role="tabpanel" class="tab-pane fade" id="misctext">
					<table class="table">
						<tbody>
							<tr>
								<td width="200px"><label>Credit Note Comments</label></td>
								<td>${creNoteText.creditNote}</td>
							</tr>
							<tr>
								<td width="200px"><label>Support Justification</label></td>
								<td>${creNoteText.justification}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<c:choose>
				<c:when test="${agr.agreementStatus.agreementStatusId eq 1}">
					<div class="row">
						<div class="col-md-1 col-md-offset-7">
							<form action="${rootPath}<%=PathConstants.AGREEMENT_SUBMIT%>"
								method="post">
								<input type="hidden" name="agrNumber"
									value="${agr.agreementNumber}"> <input type="submit"
									class="btn btn-primary" value="Submit" />
							</form>
						</div>
						<div class="col-md-1 ">
							<form action="${backURI}" method="get">
								<input type="submit" class="btn btn-primary" value="Back" />
							</form>
						</div>
						<div class="col-md-1">
							<form action="${rootPath}<%=PathConstants.AGREEMENT_DOCUMENT%>"
								method="post">
								<input type="submit" class="btn btn-primary" value="Print" />
							</form>
						</div>

						<div class="col-md-2">
							<form
								action="${rootPath}<%=PathConstants.AGREEMENT_SAVE_AS_DRAFT%>"
								method="post">
								<input type="submit" class="btn btn-primary"
									value="Save
						As Draft" />
							</form>
						</div>
					</div>
				</c:when>
				<c:when test="${agr.agreementStatus.agreementStatusId eq 2}">
					<div class="row">
						<div class="col-md-1 col-md-offset-9">
							<form action="${rootPath}<%=PathConstants.AGREEMENT_APPROVE%>"
								method="post">
								<input type="hidden" name="agrNumber"
									value="${agr.agreementNumber}"> <input type="submit"
									class="btn btn-primary " value="Approve" />
							</form>
						</div>
						<div class="col-md-1">
							<form action="${rootPath}<%=PathConstants.AGREEMENT_DOCUMENT%>"
								method="post">
								<input type="hidden" name="param" value="${paramAgr}"> <input
									type="submit" class="btn btn-primary" value="Print" />
							</form>
						</div>
						<div class="col-md-1">
							<form action="#" method="post">
								<input type="submit" class="btn btn-primary"
									value="Copy Agreement" />
							</form>
						</div>
					</div>
				</c:when>
				<c:when test="${agr.agreementStatus.agreementStatusId eq 6}">
					<div class="row">
						<div class="col-md-1 col-md-offset-11">
							<form action="${rootPath}<%=PathConstants.AGREEMENT_DOCUMENT%>"
								method="post">
								<input type="submit" class="btn btn-primary" value="Print" />
							</form>
						</div>
					</div>
				</c:when>
				<c:when test="${agr.agreementStatus.agreementStatusId eq 4}">
					<div class="row">
						<div class="col-md-1 col-md-offset-7">
							<form action="#" method="post">
								<input type="hidden" name="param" value="${paramAgr}"> <input
									type="submit" class="btn btn-primary" value="Edit" />
							</form>
						</div>
						<div class="col-md-1">
							<form action="#" method="post">
								<input type="hidden" name="param" value="${paramAgr}"> <input
									type="submit" class="btn btn-primary" value="Extend" />
							</form>
						</div>
						<div class="col-md-1">
							<form action="${rootPath}<%=PathConstants.AGREEMENT_DOCUMENT%>"
								method="post">
								<input type="hidden" name="param" value="${paramAgr}"> <input
									type="submit" class="btn btn-primary" value="Print" />
							</form>
						</div>
						<div class="col-md-1">
							<form action="${rootPath}<%=PathConstants.AGREEMENT_TERMINATE%>" method="post">
								<input type="hidden" name="agrNumber"
									value="${agr.agreementNumber}">
									<input type="hidden" id="endDateTer" value="${agr.endDate}">
									<input
									type="submit" class="btn btn-primary submitTerminate" value="Terminate" />
							</form>
						</div>
						<div class="col-md-1">
							<form action="#" method="post">
								<input type="hidden" name="param" value="${paramAgr}"> <input
									type="submit" class="btn btn-primary" value="Copy Agreement" />
							</form>
						</div>
					</div>
				</c:when>
			</c:choose>
		</div>
	</c:otherwise>
</c:choose>
<script>
	$(document).ready(function() {
		$(".submitTerminate").click(function() {
			
			var endDate = $("#endDateTer").val();
			
			var endD = new Date(endDate);
			
			var now = new Date();
			
			var temp = Math.floor((now - endD)/(60*60*24*1000));
			
			var flag = false;
			
			if (temp <= 30) {
				flag = confirm("There are less than 30 days left on this agreement" 
						+ ", are you sure you would like to terminate?");
			}
			
			return flag;
		});
	});
</script>

