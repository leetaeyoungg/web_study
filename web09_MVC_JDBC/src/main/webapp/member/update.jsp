<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
    <html>
    <style>
            table{
                width: 500px;
            }
            input[type=text],
            input[type=password],
            input[type=tel],
            textarea{
                width: 100%;
                padding: 8px 8px;
                margin: 8px 0px;
                display: inline-block;
                border: 2px solid #054a98;
                border-radius: 10px;
            }
            input[type=submit]{
                width: 30%;
                padding: 8px 8px;
                margin: 8px 0px;
                border-radius: 10px;
                background-color: #054a98;
                color: rgb(255, 255, 255);
            }
            input[type=submit]:hover{
                background-color: rgb(151, 151, 151);
                color: black;
            }
            h1{
                text-align: center;
                color: #054a98
            }
            </style>
    <head>
        <title>회원정보수정</title>
    </head>
    <body>
        <h1>회원정보수정</h1>
        <jsp:include page="../top_menu.jsp"/>
<h1 align="center">회원정보수정</h1>

            <form action="m_updateOK.do" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <label for="num">NUMBER</label> <input type="text" name="num" id="num" value="${param.num}" readonly><br>
                            <label for="id">ID</label> <input type="text" name="id" id="id" value="${vo2.id}"><br>
                            <label for="pw">PASSWORD</label> <input type="password" name="pw" id="pw" value="${vo2.pw}"><br>
                            <label for="name">이름</label> <input type="text" name="name" id="name" value="${vo2.name}"><br>
                            <label for="tel">전화번호<input type="text" name="tel" id="tel"value="${vo2.tel}"></label><br>
                            <input type="submit" value="수정">

                        </td>
                    </tr>
               </table>
            </form>
    </body>
</html>