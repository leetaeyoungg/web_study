package org.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//ServletPath등록(다른컨트롤러에 있는 값들과도 비교했을 때 마저 유니크해야한다.)
@WebServlet({"/index.do","/insert.do","/insertOK.do","/update.do","/updateOK.do","/delete.do","/deleteOK.do",
        "/selectOne.do","/selectAll.do","/searchList.do"})
public class BoardController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        String sPath = request.getServletPath();
        System.out.println("sPath:" + sPath);

       if (sPath.equals("/index.do")) {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
       } else if (sPath.equals("/insert.do")) {
           RequestDispatcher rd = request.getRequestDispatcher("board/insert.jsp");
           rd.forward(request, response);
       } else if (sPath.equals("/update.do")) {
           String num = request.getParameter("num");
           System.out.println("number : "+num);

           //BoardVO >> set >> service >> DAO >> JDBC >> return vo2

           BoardVO vo2 = new BoardVO(1,"titleEX","ContentEX","writerEX","wdateEX");

           request.setAttribute("vo2",vo2);

           RequestDispatcher rd = request.getRequestDispatcher("board/update.jsp");
           rd.forward(request, response);
       } else if (sPath.equals("/delete.do")) {
           RequestDispatcher rd = request.getRequestDispatcher("board/delete.jsp");
           rd.forward(request, response);
       } else if (sPath.equals("/selectOne.do")) {
           String num = request.getParameter("num");
           System.out.println("number : "+num);

           //MemberVO >> set >> service >> DAO >> JDBC >> return vo2

           BoardVO vo2 = new BoardVO(1,"titleEX","ContentEX","writerEX","wdateEX");

           request.setAttribute("vo2",vo2);

           RequestDispatcher rd = request.getRequestDispatcher("board/selectOne.jsp");
           rd.forward(request, response);
       } else if (sPath.equals("/selectAll.do")) {
           String cpage =request.getParameter("cpage");
           String limit =request.getParameter("limit");
           System.out.println(cpage);
           System.out.println(limit);

           List<BoardVO> vos = new ArrayList<>();
           for (int i = 0; i < 5; i++) {
               BoardVO vo = new BoardVO(1+i,"title"+(1+i),"content"+(1+i),"lee"+(1+i),"2025-02-1"+(1+i));
               vos.add(vo);
           }
           request.setAttribute("vos",vos);

           RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
           rd.forward(request, response);
       } else if (sPath.equals("/searchList.do")) {
           String searchKey =request.getParameter("searchKey");
           String searchWord =request.getParameter("searchWord");
           System.out.println(searchKey);
           System.out.println(searchWord);

           List<BoardVO> vos = new ArrayList<>();
           for (int i = 0; i < 3; i++) {
               BoardVO vo = new BoardVO(1+i,"title"+(1+i),"content"+(1+i),"lee"+(1+i),"2025-02-1"+(1+i));
               vos.add(vo);
           }

           request.setAttribute("vos",vos);
           RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
           rd.forward(request, response);
       } else if (sPath.equals("/deleteOK.do")) {
           String num = request.getParameter("num");
           System.out.println("num : " + num);
           //MemberVO >> set >> service >> DAO >> JDBC >> RETURN 1

           int result = 1;
           if (result == 1){
               System.out.println("delete successed...");
               response.sendRedirect("index.do");
           }else {
               response.sendRedirect("delete.do?num="+num);
           }
       } else if (sPath.equals("/insertOK.do")) {
           String title = request.getParameter("title");
           System.out.println("title : " + title);
           String content = request.getParameter("content");
           System.out.println("content : " + content);
           String writer = request.getParameter("writer");
           System.out.println("writer : " + writer);
           String wdate = request.getParameter("wdate");
           System.out.println("wdate : " + wdate);

           int result = 1;
           if (result == 1){
               System.out.println("insert successed...");
               response.sendRedirect("index.do");
           }else {
               response.sendRedirect("insert.do");
           }
       } else if (sPath.equals("/updateOK.do")) {
           String num = request.getParameter("num");
           System.out.println("num : " + num);
           String title = request.getParameter("title");
           System.out.println("title : " + title);
           String content = request.getParameter("content");
           System.out.println("content : " + content);
           String writer = request.getParameter("writer");
           System.out.println("writer : " + writer);
           String wdate = request.getParameter("wdate");
           System.out.println("wdate : " + wdate);

           int result = 1;
           if (result == 1){
               System.out.println("update successed...");
               response.sendRedirect("index.do");
           }else {
               response.sendRedirect("update.do?num="+num);
           }
       }


    }//end doGet()
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("doPost...");
        doGet(request,response);



    }//end doPost()

}//end class
