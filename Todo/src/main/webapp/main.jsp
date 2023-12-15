<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./main.css">
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>

    <body>
    <div>안녕</div>
    <br>
    <c:forEach items = "${list}" var="item">
    ${item}<br>
    </c:forEach>
    ${v1} + ${v2} = ${result} <br><br>
    </body>
    
</html>