$(document).ready(function() {
	
	$(".submitView").click(function() {
		
		if ($("#selected:checked").length == 0) {
			alert("You must select an agreement.")
			return false;
		}
		
		return true;
	});
	
	$(".submitSearch").click(function() {
		
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		var agrNumber = $("#agrNumber").val();
		
		if (Date.parse(startDate) > Date.parse(endDate)) {
			alert("End Date must be greater than Start Date.");
			$("#endDate").focus();
			return false;
		}
		
		if (agrNumber.length != 0 && isNaN(agrNumber)) {
			alert("Agreement number must be a number");
			$("#agrNumber").val("");
			$("#agrNumber").focus();
			return false;
		}
			
		return true;
	});
	
});
