<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	
	crossorigin="anonymous">
</head>
<body>
<%@include file="header.jsp" %>
		<div class="container" style="margin-left: 20%; padding-top:5%">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="updateveichleBook" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insertveichleBook" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit Veichle Booking
            		</c:if>
						<c:if test="${user == null}">
            			Add New Veichle Booking
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User  Name</label> <input type="text"
						value="<c:out value='${user.user}' />" class="form-control"
						name="user" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> Nic</label> <input type="text"
						value="<c:out value='${user.nic}' />" class="form-control"
						name="nic">
				</fieldset>

				<fieldset class="form-group">
					<label> Mobile </label> <input type="text"
						value="<c:out value='${user.mobile}' />" class="form-control"
						name="mobile">
				</fieldset>
				<fieldset class="form-group">
					<label> Email</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> Check In</label> <input type="text"
						value="<c:out value='${user.checkin}' />" class="form-control"
						name="checkin">
				</fieldset>

				<fieldset class="form-group">
					<label> Requsted Km</label> <input type="text"
						value="<c:out value='${user.km}' />" class="form-control"
						name="km">
				</fieldset>
						<fieldset class="form-group">
					<label> cost</label> <input type="text"
						value="<c:out value='${user.cost}' />" class="form-control"
						name="cost">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>