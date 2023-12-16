<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./main.css">
        <script src="test.js"></script>
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
        <script>
                
        </script>
        
    </body>
        <script>
             <c:forEach items = "${list}" var="item">
                 <c:choose>
                     <c:when test = "${item.type == 'TODO'}">                     
                        addTODO("${item}");
                     </c:when>
                     <c:when test = "${item.type == 'DOING'}">
	                      const DOINGList = document.querySelectorAll(".DOING");
		                  subject = DOINGList[DOINGList.length-1]
		                  subject.insertAdjacentHTML("afterend","<li class = \"DOING content\"><span class = \"title\"> "
		                  + "${item.title}</span><br><span>등록날짜:${item.regDate}${item.name}, "
		                  + "우선순위 ${item.sequence}</span></li>"); 
                     </c:when>
                     <c:when test = "${item.type == 'DONE'}">
                         
                     </c:when>
                     <c:otherwise>
                         wrong type
                     </c:otherwise>
                 </c:choose>
             </c:forEach>
        </script>
</html>