<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="todoForm.css">
        <title>Insert title here</title>
    </head>
    <body>
        <form action ="http://localhost:8080/Todo/todoadd" method="post">
            <fieldset>
                <legend> 할 일 등록</legend>
                    어떤일인가요? <br>
                    <input type = "text" placeholder="swift 공부하기(24자까지)" name ="title" required><br>                   
                    <br>
                    누가 할일인가요? <br>
                    <input type = "text" placeholder="홍길동" name ="name" required><br>
                    <br>
                    우선순위를 선택하세요<br>
                    <input type = "radio" name ="sequence" value="1">1순위 <input type = "radio" name ="sequence" value="2">2순위
                    <input type = "radio" name ="sequence" value="3" required>3순위 <br>
                <a id = "back" href="/Todo/main" style= "border: solid gray;"><이전</a>
                <input type="submit">
                <input type="reset">
            </fieldset>
        </form>     
    </body>
</html>