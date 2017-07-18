<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
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
    <%--<%@ page isELIgnored="false" %>--%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <title>Ecommerce | Index</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="mainnavbar.jsp" />
<div class="container">
    <h3>Products</h3>
    <hr>
    <h2 style="color:blue;text-align: center">Latest Arrival</h2>
    <div class="row">
        <c:forEach items="${prodList}" var="prod">
            <div class="col-md-4">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">${prod.name}</h3>
                    </div>
                    <div class="panel-body">
                        <div style = "tex-align:center">
                            <img src="public/img/dummy.jpg" alt="">
                        </div>
                        <div class="desc">
                            <p>${prod.description}</p>
                        </div>
                        <hr>
                        Price : $ ${prod.price}
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
