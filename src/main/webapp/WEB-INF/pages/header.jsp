<%--
  Created by IntelliJ IDEA.
  User: ozlemcerensahin
  Date: 21.10.2018
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/css/header.css"/>">

</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <img class="navbar-brand"
                 src="<c:url value="/resources/images/book.png"/>"
                 href="<c:url value="/products"/>" width="90px" height="40px" style="padding-top: 10px;"
                 alt="logo-image">
            </img>
            <a class="navbar-brand" href="<c:url value="/products" />" style="color: #8f9296">BookStore</a>
        </div>
    </div>
</nav>



</body>
</html>