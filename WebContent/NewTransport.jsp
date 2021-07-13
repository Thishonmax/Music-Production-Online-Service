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

	<%@include file="header.jsp"%>
	<div class="container" style="margin-left: 20%; padding-top: 5%">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="updatetransport" method="post" >
				</c:if>
				<c:if test="${user == null}">
					<form action="inserttransport" method="post"  enctype="multipart/form-data">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="text" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Veichles Name</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="veichlename" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> Veichle Facilities</label> <input type="text"
						value="<c:out value='${user.facilities}' />" class="form-control"
						name="facilities">
				</fieldset>


				<fieldset class="form-group">
					<label> cost Per Day</label> <input type="number"
						value="<c:out value='${user.cost}' />" class="form-control"
						name="cost" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label> Veichle type</label> <input type="text"
						value="<c:out value='${user.type}' />" class="form-control"
						name="type">
				</fieldset>
						<fieldset class="form-group">
					<label> Image</label> <input type="file" class="form-control"
						name="file">
				
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>