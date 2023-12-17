<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./main.css">
        <script src="main.js"></script>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>

    <body>
        <header>
            <div id = headerwrap>
                <a id = "header" href="/Todo/todoform">새로운 TODO 등록</a>
            </div>
        </header>
          
        <section>
            <div class = "left">
                <ul>
                    <li class = "TODO header">TODO</li>                    
                </ul>
            </div>

            <div class = "middle">
                <ul>
                    <li class = "DOING header">DOING</li>
                    
                </ul>
            </div>

            <div class = "right">
                <ul >
                    <li class = "DONE header">DONE</li>
                
                </ul>
            </div>
        </section>
    </body>
        <script>
        	var json =${json};
            addTODO(json); // 서블릿에서 처음 실행할때만 나오게 하기?
        </script>
</html>