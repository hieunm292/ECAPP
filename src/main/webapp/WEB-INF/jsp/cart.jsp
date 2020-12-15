<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/9/2020
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
    <h2>Shopping Cart</h2>
    <table>
        <thead>
        <tr>
            <th>Product Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="orderDetails" items="${cart.orderDetailsList}">
            <tr>
                <td>${orderDetails.product.name}</td>
                <td>${orderDetails.product.description}</td>
                <td>${orderDetails.product.price}</td>
                <td>${orderDetails.quantity}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
