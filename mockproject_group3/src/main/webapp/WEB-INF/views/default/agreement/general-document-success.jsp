<%-- Settings --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/jsp-header.jsp"%>
<h1>Success</h1>
<p>
	Wait for 5 second add you'll be taken to home page... <span id="time"></span>
</p>

<script>
	$(function() {
		var count = 5;
		var myVar = setInterval(function() {
			myTimer(count);
			count--;
		}, 1000);
	});

	function myTimer(count) {
		$("#time").text(count);
		if (count == 0) {
			window.location.href = "/mockproject";
		}
	}
</script>