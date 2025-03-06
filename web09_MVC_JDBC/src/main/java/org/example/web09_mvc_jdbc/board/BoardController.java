package org.example.web09_mvc_jdbc.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

//ServletPath등록(다른컨트롤러에 있는 값들과도 비교했을 때 마저 유니크해야한다.)
@WebServlet({"/b_insert.do","/b_insertOK.do",
        "/b_update.do","/b_updateOK.do","/b_delete.do","/b_deleteOK.do",
        "/b_selectOne.do","/b_selectAll.do","/b_searchList.do"})
public class BoardController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        BoardService service = new BoardService();

        response.setContentType("text/html");
        System.out.println("=======================");
        String sPath = request.getServletPath();
        System.out.println("sPath:" + sPath);

       if (sPath.equals("/b_insert.do")) {
           RequestDispatcher rd = request.getRequestDispatcher("board/insert.jsp");
           rd.forward(request, response);
       } else if (sPath.equals("/b_update.do")) {
           String num = request.getParameter("num");
           System.out.println("number : "+num);

           BoardVO vo = new BoardVO();
           vo.setNum(Integer.parseInt(num));
           BoardVO vo2 = service.selectOne(vo);
           request.setAttribute("vo2",vo2);

           RequestDispatcher rd = request.getRequestDispatcher("board/update.jsp");
           rd.forward(request, response);
       } else if (sPath.equals("/b_delete.do")) {
           RequestDispatcher rd = request.getRequestDispatcher("board/delete.jsp");
           rd.forward(request, response);
       } else if (sPath.equals("/b_selectOne.do")) {
           String num = request.getParameter("num");
           System.out.println("number : "+num);

           //MemberVO >> set >> service >> DAO >> JDBC >> return vo2

           BoardVO vo = new BoardVO();
           vo.setNum(Integer.parseInt(num));
           BoardVO vo2 = service.selectOne(vo);

           request.setAttribute("vo2",vo2);

           RequestDispatcher rd = request.getRequestDispatcher("board/selectOne.jsp");
           rd.forward(request, response);
       } else if (sPath.equals("/b_selectAll.do")) {
           String cpage =request.getParameter("cpage");
           String limit =request.getParameter("limit");
           System.out.println(cpage);
           System.out.println(limit);

           List<BoardVO> vos = service.selectAll();
           request.setAttribute("vos",vos);

           RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
           rd.forward(request, response);
       } else if (sPath.equals("/b_searchList.do")) {
           String searchKey =request.getParameter("searchKey");
           String searchWord =request.getParameter("searchWord");

           List<BoardVO> vos = service.searchList(searchKey,searchWord);
           request.setAttribute("vos",vos);

           RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
           rd.forward(request, response);
       } else if (sPath.equals("/b_deleteOK.do")) {
           String num = request.getParameter("num");
           System.out.println("num : " + num);

           BoardVO vo = new BoardVO();
           vo.setNum(Integer.parseInt(num));

           int result = service.delete(vo);
           System.out.println("b_delete result : " + result);
           if (result == 1){
               System.out.println("delete successed...");
               response.sendRedirect("b_selectALl.do");
           }else {
               System.out.println("delete failed...");
               response.sendRedirect("b_delete.do?num="+num);
           }
       } else if (sPath.equals("/b_insertOK.do")) {
           String title = request.getParameter("title");
           System.out.println("title : " + title);
           String content = request.getParameter("content");
           System.out.println("content : " + content);
           String writer = request.getParameter("writer");
           System.out.println("writer : " + writer);

           BoardVO vo = new BoardVO();
           vo.setTitle(title);
           vo.setContent(content);
           vo.setWriter(writer);

           int result = service.insert(vo) ;
           System.out.println("b_insert result : "+result);
           if (result == 1){
               System.out.println("insert successed...");
               response.sendRedirect("b_selectAll.do");
           }else {
               System.out.println("insert failed...");
               response.sendRedirect("b_insert.do");
           }
       } else if (sPath.equals("/b_updateOK.do")) {
           String num = request.getParameter("num");
           System.out.println("num : " + num);
           String title = request.getParameter("title");
           System.out.println("title : " + title);
           String content = request.getParameter("content");
           System.out.println("content : " + content);
           String writer = request.getParameter("writer");
           System.out.println("writer : " + writer);

           BoardVO vo = new BoardVO();
           vo.setNum(Integer.parseInt(num));
           vo.setTitle(title);
           vo.setContent(content);
           vo.setWriter(writer);

           int result = service.update(vo) ;
           System.out.println("b_insert result : "+result);
           if (result == 1){
               System.out.println("update successed...");
               response.sendRedirect("b_selectOne.do?num="+num);
           }else {
               System.out.println("update failed...");
               response.sendRedirect("b_update.do?num="+num);
           }
       }


    }//end doGet()
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("doPost...");
        doGet(request,response);



    }//end doPost()

}//end class
