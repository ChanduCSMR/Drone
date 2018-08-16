<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/images/favicon.ico">

<title>Dashboard</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>

<!-- Custom styles for this template -->
<link href="css/dashboard.css" rel="stylesheet">
</head>

<body>
	<nav
		class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
	<button class="navbar-toggler navbar-toggler-right hidden-lg-up"
		type="button" data-toggle="collapse"
		data-target="#navbarsExampleDefault"
		aria-controls="navbarsExampleDefault" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="#">Drones Delivery</a>

	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">Dashboard
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Settings</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Profile</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Help</a></li>
		</ul>
	</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
			<ul class="nav nav-pills flex-column">
				<li class="nav-item"><a class="nav-link active" href="#">Overview
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Reports</a></li>
			</ul>

			</nav>

			<main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
			<h1>Dashboard</h1>
			<h2>Drones</h2>

			<section class="row text-center placeholders"> <c:forEach
				var="drone" items="${drones}">
				<div class="col-6 col-sm-3 placeholder">
					<img
						src="data:image/gif;base64,R0lGODlhAQABAIABAAJ12AAAACwAAAAAAQABAAACAkQBADs="
						width="200" height="200" class="img-fluid rounded-circle"
						alt="Generic placeholder thumbnail">
					<h4>${drone.droneName}</h4>
					<div class="text-muted">${drone.versionNumber} |
						<p id="droneId${drone.id}">${drone.status}</p></div>


				</div>
			</c:forEach> </section>

			<h2>Products</h2>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Serial Number</th>
							<th>Name</th>
							<th>Address</th>
							<th>Status</th>
							<th>Added Date</th>
							<th>Delivered Date</th>
							<th>Delivered By</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
							int i = 1;
						%>
						<c:forEach var="product" items="${products}">
							<tr>
								<td><%=i++%></td>
								<td>${product.serialNumber}</td>
								<td>${product.productName}</td>
								<td>${product.address}</td>
								<td id="productstatus${product.id}">${product.productStatus}</td>
								<td>${product.productAddedDate}</td>
								<td>${product.productDeliveredDate}</td>
								<td>${product.deliveredBy}</td>
								<c:choose>
									<c:when test="${product.productStatus == 'InStock'}">
										<td><button class="btn btn-outline-success my-2 my-sm-0"
												onclick="initiateDelivery(${product.id})"
												id="button${product.id}">Initiate Shipment</button></td>

									</c:when>
									<c:when test="${product.productStatus == 'OutForDelivery'}">
										<td><button class="btn btn-outline-success my-2 my-sm-0">Out
												For Delivery</button></td>

									</c:when>
									<c:otherwise>
										<td><button class="btn btn-outline-success my-2 my-sm-0">Delivered</button></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
			</main>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">

					<h4 class="modal-title">Shipment Details</h4>
				</div>
				<div class="modal-body">
					<p id="modaldata"></p>
				</div>
				<div class="modal-footer" id="modalbutton"></div>
			</div>

		</div>
	</div>

	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
	<script src="js/dashboard.js"></script>

</body>
</html>
