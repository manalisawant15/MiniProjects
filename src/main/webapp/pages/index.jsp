<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored ="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" 
    crossorigin="anonymous">
   <style type="text/css">
    card{
    webkit-box-shadow: -1px -2px 40px 5px rgba(232,28,14,1);
	-moz-box-shadow: -1px -2px 40px 5px rgba(232,28,14,1);
	box-shadow: -1px -2px 40px 5px rgba(232,28,14,1);
    }
   </style> 
  
</head>
<body>
<div class = "row">
	<div class="col-2"></div>
	<div class="col-8"><br>
		<div class="card">
		<h3>Report App</h3>
		<br>
		<form:form action="search" modelAttribute="search" method="POST">
		<table>
			<tr>
			<td>Plan Name : </td>
			<td>
				<form:select path="planName">
					<form:option value="">--Select--</form:option>
					<form:options items="${names}"/>
				</form:select>
			</td>
			
			<td>Plan Status : </td>
			<td>
				<form:select path="planStatus">
					<form:option value="">--Select--</form:option>
					<form:options items="${status}"/>
				</form:select>
			</td>
			 
			 <td>Gender : </td>
			<td>
				<form:select path="gender">
					<form:option value="">--Select--</form:option>
					
					<form:option value="1">Male</form:option>
					<form:option value="2">Fe-Male</form:option>
				</form:select>
			</td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><form:input type="date" path="startDate"/>
				</td>
				<td>End Date</td>
				<td><form:input type="date" path="endDate"/>
				</td>
				<td>
				<a href="/" class="btn btn-danger">Reset</a></td>
				
				<td><input type="submit" value="search" class="btn btn-primary"/>
				</td>
			</tr>
			
		</table>
			<hr>
			<table class="table table-striped">
				<thead>
				<tr>
					<th>Id</th>
					<th>Holder Name</th>
					<th>Gender</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Benefit Amount</th>
					</tr>
				</thead>
				<tbody>
					
						<c:forEach var="plan" items="${plans}" varStatus="index">
						<tr>
							<td>${index.count}</td>
   						    <td>${plan.citizenName}</td>
   						    <td>${plan.gender}</td> 
   						    <td>${plan.planName}"</td>
   						    <td>${plan.planStatus}"</td>
   						    <td>${plan.planStartDate}"</td>
   						    <td>${plan.planEndDate}"</td>
   						    <td>${plan.benefitAmt }</td>
   						  </tr> 
						</c:forEach>
						<tr>
							<c:if test = "${empty plans}">
								<td colspan="8" style="text-align: center">No Record Found</td>
							</c:if>	
						</tr>
				</tbody>
			</table> 
			<hr>
			<h6 style ="text-align:center">Export : <a href="excel">Excel</a> <a href="pdf">Pdf</a> </h6>
		</form:form>
		</div>
	</div>
	<div class="col-2"></div>
</div>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" 
 integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" 
 crossorigin="anonymous"></script>
</body>
</html>