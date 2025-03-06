<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
    <html>
    <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: Arial, sans-serif;
                background-color: #f9f9f9;
                color: #333;
                line-height: 1.6;
                padding: 2rem;
            }

            .container {
                max-width: 600px;
                margin: 0 auto;
                background: #fff;
                padding: 2rem;
                border-radius: 8px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            }

            h1 {
                text-align: center;
                margin-bottom: 1.5rem;
                color: #555;
            }

            form {
                display: flex;
                flex-direction: column;
                margin: 0 auto;
            }

            label {
                margin-bottom: 0.5rem;
                font-weight: bold;
                display: block;
                text-align : center;
            }

            input, textarea, button {
                margin-bottom: 1rem;
                padding: 0.75rem;
                font-size: 1rem;
                border: 1px solid #ddd;
                border-radius: 4px;
                margin: 0 auto;
                display: block;
            }

            input:focus, textarea:focus, button:focus {
                outline: none;
                border-color: #007BFF;
                box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
            }

            textarea {
                resize: vertical;
                min-height: 150px;
            }

            button {
                background-color: #007BFF;
                color: #fff;
                border: none;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            button:hover {
                background-color: #0056b3;
            }

            .message {
                text-align: center;
                margin-top: 1rem;
                font-size: 1rem;
            }
            </style>
    <head>
        <title>게시글수정</title>
    </head>
    <body>
        <h1>게시글수정</h1>
        <jsp:include page="../top_menu.jsp"/>
        <h1 align="center">게시글수정</h1>

            <form action="b_updateOK.do" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <label for="num">게시글번호</label> <input type="text" name="num" id="num" value="${param.num}" readonly><br>
                            <label for="title">제목</label> <input type="text" name="title" id="title" value="${vo2.title}"><br>
                            <label for="content">내용</label> <textarea name="content" id="content" rows="5" cols="40">${vo2.content}</textarea><br>
                            <label for="writer">작성자 ID</label> <input type="text" name="writer" id="writer" value="${vo2.writer}" readonly><br>
                            <input type="submit" value="수정">

                        </td>
                    </tr>
               </table>
            </form>
    </body>
</html>