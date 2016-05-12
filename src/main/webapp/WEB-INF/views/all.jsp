<%--
  Created by IntelliJ IDEA.
  User: tim
  Date: 4/28/15
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>${pageTitle}</title>
  <c:import url="fragments/common.jsp"/>
  <c:import url="fragments/header.jsp"/>
</head>
<body>
<div style="text-align: center;"><h2>All Items page</h2></div>
<div style="text-align: center;">
  <h4>Sample Item from Model List of Items</h4>
  <div><img src="${items[0].imageUrl}"></div>
  <div>${items[0].itemDescription}</div>
</div>
</body>
</html>
