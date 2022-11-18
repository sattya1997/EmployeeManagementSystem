$(document).ready(function() {
	$(".add-employee-form").hide();
	var employee=[];
	getAllEmployee();

	$(".add-employee-button").click(function(event) {
		$(".top").hide();
		$(".grid-table").hide();
		$(".add-employee-form").show(700);
	});

	$(".go-button").click(function(event) {
		alert("pl")
	});
	
	$("#cancel").click(function(event){
		$(".add-employee-form").hide(700);
		$(".top").show();
		$(".grid-table").show();
	});
        
        function getAllEmployee(){
		$.ajax({
			url: "getAllEmployee",
			type: "GET",
			dataType: "JSON",
			success: function(json) {
				
				for (var i = 0; i < json.length; i++) {
						var option = "<option value='"+json[i].eid+ "'>"+json[i].eid + "</option>";
						employee[i]=json[i].eName;
						
						document.getElementById('employeeid').innerHTML += option;
				}
			}
		});	
	}
	
	$('#employeeid').change(function() {
		var emplyeeid=this.value;
		document.getElementById('name').value=employee[emplyeeid-1];
	  }).change();
});



