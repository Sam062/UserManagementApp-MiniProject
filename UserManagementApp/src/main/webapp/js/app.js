$(document).ready(function(event) {
	$("#countryID").change(function() {
		
		$("#stateID").find('option').remove();
		$('<option>').val('').text('-Select-').appendTo("#stateID");
		
		$("#cityID").find('option').remove();
		$('<option>').val('').text('-Select-').appendTo("#cityID");
		
		var countryId = $("#countryID").val();
		$.ajax({
			type : "GET",
			url : "getStates?id=" + countryId,
			success : function(res) {
				$.each(res, function(stateId, stateName) {
					$('<option>').val(stateId).text(stateName).appendTo("#stateID");
				});
			}
		});
	});

	$("#stateID").change(function() {
		
		$("#cityID").find('option').remove();
		$('<option>').val('').text('-Select-').appendTo("#cityID");
		
		var stateId = $("#stateID").val();
		$.ajax({
			type : "GET",
			url : "getCities?id=" + stateId,
			success : function(data) {
				$.each(data, function(cityId, cityName) {
					$('<option>').val(cityId).text(cityName).appendTo("#cityID");
				});
			}
		});
	});
});