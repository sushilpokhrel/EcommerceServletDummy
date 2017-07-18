<%--
  Created by IntelliJ IDEA.
  User: anish
  Date: 7/18/17
  Time: 8:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ecommerce | Admin Panel | Categories</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <c:if test = "${message != null}">

        <div class="alert alert-success">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>${message}</strong>
                ${message = null}
        </div>
    </c:if>
    <h2>All Products</h2>
    <a href="/addprod?page=add" style = "text-align:center" class = "btn btn-primary">Add New Product</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Product Name</th>
            <th>Description</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${catList}" var="cat">
            <tr>
                <td>${cat.id}</td>
                <td>${cat.name}</td>
                <td>${cat.description}</td>
                <td>${cat.quantity}</td>
                <td>${cat.price}</td>
                <td><a href="/editprod?page=edit&id=${cat.id}">Edit</a></td>
                <td><a href="/proddelete?page=delete&id=${cat.id}">Delete</a></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>

