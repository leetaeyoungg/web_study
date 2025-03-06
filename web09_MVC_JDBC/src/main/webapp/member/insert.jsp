<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

%>

<!DOCTYPE html>
    <html>
    <head>
        <title>회원가입</title>
        <link rel="stylesheet" href="../css/style.css">
        <style>
            table{
                width: 500px;
            }
            input[type=text],input[type=textarea],input[type=password]{
                width: 100%;
                padding: 8px 8px;
                margin: 8px 0px;
                display: inline-block;
                border: 2px solid #054a98;
                border-radius: 10px;

            }
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
    </head>
    <body>
        <h1>회원가입</h1>
        <jsp:include page="../top_menu.jsp"/>

        <h1 align="center">회원가입</h1>

            <form action="m_insertOK.do" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <label for="id">ID</label> <input type="text" name="id" id="id" value="abcde"><br>
                            <label for="pw">PASSWORD</label> <input type="password" name="pw" id="pw" value="abcde"><br>
                            <label for="name">이름</label> <input type="text" name="name" id="name" value="LEETAEYOUNG"><br>
                            <label for="tel">전화번호<input type="text" name="tel" id="tel"value="010-1234-5678"></label><br>
                            <input type="submit" value="회원가입">

                        </td>
                    </tr>
               </table>
            </form>
    </body>
</html>