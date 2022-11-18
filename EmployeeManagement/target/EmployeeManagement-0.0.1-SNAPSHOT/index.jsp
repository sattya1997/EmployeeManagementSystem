<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMS</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js  "></script>

</head>
<body>
	<div class="main">
	<div class="add-employee-form">
		<div class="form-input">
			<label>Add employee</label><br>
			<label>Employee ID </label>
				<select class="input"  name="employeeid" id="employeeid">
				<option>Select any Id</option>
				</select><br><br>
				<label>Employee Name </label><input type="text" id="name" class="input" readonly="readonly" /><br><br>
				<label>Year of experience </label><input type="text" id="name" class="input" /><br><br>
				<label>Designation </label><input type="text" id="name" class="input" />
		</div>
		<div class="form-button">
			<div><input type="button" id="save" value="Save"></div>
			<div><input type="button" id="cancel" value="cancel"></div>
		</div>
	</div>
		
		<div class="top">
			<div class="search-box">
				<div class="search">
					<input type="text" class="searchTerm"
						placeholder="What are you looking for?">
					<button type="submit" class="go-button">
						<i class="a-search">Go</i>
					</button>
				</div>
			</div>
			<div class="add-button">
				<button type="button" class="add-employee-button">Add
					employee</button>
			</div>
		</div>


		<div class="grid-table">
			<div class="eid">eid</div>
			<div class="ename">ename</div>
			<div class="doj">doj</div>
			<div class="yoe">yoe</div>
			<div class="designation">designation</div>
		</div>
	</div>

	<script src="js/index.js"></script>
</body>
</html>
