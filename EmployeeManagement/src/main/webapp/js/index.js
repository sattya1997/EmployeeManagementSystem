$(document).ready(function() {
	$(".add-employee-form").hide();
	var employee = [];
	var employeeid = [];
	var ids = document.getElementsByClassName("eid");
	var coloredItem=0;
	getAllEmployee();

	$(".add-employee-button").click(function(event) {
		$(".top").hide();
		$("#grid-table").hide();
		$(".add-employee-form").show(350);
	});

	$(".go-button").click(function(event) {
		
		removeColor();
		var searchItem = $("#search-item").val();
		
		for(var i=0;i<employee.length;i++){
			if(employeeid[i]== searchItem){
				for(var j=0;j<ids.length;j++){
					if(ids[j].innerHTML==searchItem){
						console.log("ok")
						ids[j].classList.add("yellow");
						coloredItem=j;
					}	
				}	
			}
		}
	});

	$("#cancel").click(function(event) {
		$(".add-employee-form").hide(200);
		$(".top").show(400);
		$("#grid-table").show(400);
	});

	function getAllEmployee() {
		$.ajax({
			url: "getAllEmployee",
			type: "GET",
			dataType: "JSON",
			success: function(json) {

				for (var i = 0; i < json.length; i++) {
					var option = "<option value='" + json[i].eid + "'>" + json[i].eid + "</option>";
					employee[json[i].eid] = json[i].eName;
					employeeid[json[i].eid] = json[i].eid;
					document.getElementById('employeeid').innerHTML += option;
				}
				
				for(var i = 0; i < json.length; i++){
					
					if(json[i].designation !=null){
						addEmployee(json[i]);
					}
					
				}
			}
		});
	}

	$('#employeeid').change(function() {
		var emplyeeid = this.value;
		document.getElementById('name').value = employee[emplyeeid];
	}).change();


	$("#save").click(function(event) {
		event.preventDefault();
		var eid = $('#employeeid').find(":selected").text();
		var designation = $("#designation").val();
		var yoe = $("#yoe").val();
		var eName = $("#name").val();
		var data = {};
		data["eid"] = eid;
		data["designation"] = designation;
		data["yoe"] = yoe;
		data["eName"] = eName;
		
		$.ajax({
			url: "addEmployee",
			type: 'POST',
			dataType: 'json',
			data: JSON.stringify(data),
			contentType: 'application/json',
			mimeType: 'application/json',
			success: function(result) {
				if (result == 0) {
					$("#msg").html("<span style='color: red'>Employee Already exist.Could not save</span>");
					setTimeout(removeMessage, 3000);
				}
				else {
					addEmployee(result);

					$("#msg").html("<span style='color: white'>Employee saved</span>");
					setTimeout(removeMessage, 3000);
				}
			},
			error: function(err) {
				console.log(err);
				$("#msg").html("<span style='color: red'>Could not save employee data</span>");
				setTimeout(removeMessage, 3000);
			}
		});
		$(".add-employee-form").hide();
		$(".top").show();
		$("#grid-table").show();

	});

	function removeMessage() {
		$("#msg").html("<span></span>");
	}

	function addEmployee(result) {
		var div1 = document.createElement('div');
		div1.className = 'eid'
		div1.innerHTML = result.eid;
		document.getElementById('grid-table').appendChild(div1);

		var div2 = document.createElement('div');
		div2.className = 'ename'
		div2.innerHTML = result.eName;
		document.getElementById('grid-table').appendChild(div2);

		var div3 = document.createElement('div');
		div3.className = 'doj'
		div3.innerHTML = result.DOJ;
		document.getElementById('grid-table').appendChild(div3);

		var div4 = document.createElement('div');
		div4.className = 'yoe'
		div4.innerHTML = result.yoe;
		document.getElementById('grid-table').appendChild(div4);

		var div5 = document.createElement('div');
		div5.className = 'designation'
		div5.innerHTML = result.designation;
		document.getElementById('grid-table').appendChild(div5);
	}
	
	function removeColor(){
		ids[coloredItem].classList.remove("yellow");
		}

});



