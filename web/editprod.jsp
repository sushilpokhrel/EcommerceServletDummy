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
    <title>Ecommerce | Admin Panel | Edit Product</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <h3>Edit Product</h3>
    <div class="container">
        <form action="/updateprod" method="post">
            <input type="hidden" name = "page" value="update">
            <input type="hidden" name = "id" value="${prod.id}">
            <div class="form-group">
                <label for="name">Product Name:</label>
                <input type="text" class="form-control" id = "name" name = "name" value = ${prod.name}>
            </div>
            <div class="form-group">
                <label for="comment">Description:</label>
                <textarea class="form-control" rows="5" id="comment" name = "description">${prod.description}</textarea>
            </div>
            <div class="form-group">
                <label for="category">Select Category:</label>
                <select name = "cat_id" class="form-control" id="category">
                    <c:forEach var="cat" items="${catList}">
                        <option value="${cat.id}"
                                <c:if test = "${prod.cat_id == cat.id}">
                                    selected
                                </c:if>
                        >${cat.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="qty">Quantity:</label>
                <input name = "quantity" type="number" value = "${prod.quantity}" min = 0 class="form-control" id="qty">
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="text" value = "${prod.price}" class="form-control" id = "price" name = "price">
            </div>
            <input type="submit" class = "btn btn-primary" value = "submit">
        </form>

    </div>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>

