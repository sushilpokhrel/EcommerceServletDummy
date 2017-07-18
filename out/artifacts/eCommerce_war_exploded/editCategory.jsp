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
    <title>Ecommerce | Admin Panel | Edit Category</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <h3>Edit Category</h3>
    <div class="container">
        <form action="/updatecat" method="post">
            <input type="hidden" name = "page" value="update">
            <input type="hidden" name = "id" value="${cat.id}">
            <div class="form-group">
                <label for="name">Category Name:</label>
                <input type="text" class="form-control" id = "name" name = "name" value = ${cat.name}>
            </div>
            <div class="form-group">
                <label for="comment">Description:</label>
                <textarea class="form-control" rows="5" id="comment" name = "description">${cat.description}</textarea>
            </div>
            <input type="submit" class = "btn btn-primary" value = "Update">
        </form>

    </div>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>

