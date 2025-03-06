<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

%>

<!DOCTYPE html>
    <html>
    <head>
        <title>회원삭제</title>
    </head>
    <body>
        <h1>회원삭제</h1>
        <jsp:include page="../top_menu.jsp"/>
        ${param.num}번 회원을 정말 삭제하시겠습니까 ?
        <a href="m_deleteOK.do?num=${param.num}">OK</a>


    </body>
</html>