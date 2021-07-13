<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<body>

	<%@include file="header.jsp" %>
		<div class="container" style="margin-left: 20%; padding-top:5%">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="updateres" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insertres" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit Restaurant Order
            		</c:if>
						<c:if test="${user == null}">
            			Add New Restaurant Order
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}'/>" />
				</c:if>

				<fieldset class="form-group">
					<label> User Name</label> <input type="text"
						value="<c:out value='${user.user}' />" class="form-control"
						name="user" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> Juice</label> <input type="text"
						value="<c:out value='${user.juice}' />" class="form-control"
						name="juice">
				</fieldset>

				<fieldset class="form-group">
					<label> Main Dish</label> <input type="text"
						value="<c:out value='${user.main}' />" class="form-control"
						name="main">
				</fieldset>
				<fieldset class="form-group">
					<label> Dessert</label> <input type="text"
						value="<c:out value='${user.dessert}' />" class="form-control"
						name="dessert" required="required">
				</fieldset>


				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>