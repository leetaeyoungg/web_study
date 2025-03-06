package org.example.web09_mvc_jdbc.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({"/m_insert.do","/m_insertOK.do",
        "/m_selectAll.do","/m_selectOne.do","/m_update.do","/m_updateOK.do",
        "/m_delete.do","/m_deleteOK.do","/m_searchList.do"})
public class MemberController extends HttpServlet {

private MemberService service = new MemberService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("===================");
        String sPath = request.getServletPath();
        System.out.println(sPath);

        if(sPath.equals("/m_insert.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("member/insert.jsp");
            rd.forward(request, response);

        } else if (sPath.equals("/m_insertOK.do")) {
            String id = request.getParameter("id");
            System.out.println("id : " + id);
            String pw = request.getParameter("pw");
            System.out.println("pw : " + pw);
            String name = request.getParameter("name");
            System.out.println("name : " + name);
            String tel = request.getParameter("tel");
            System.out.println("tel : " + tel);

            MemberVO vo = new MemberVO();
            vo.setId(id);
            vo.setPw(pw);
            vo.setName(name);
            vo.setTel(tel);

            int result = service.insert(vo);
            System.out.println("m_insert result : "+result);
            if (result == 1){
                System.out.println("m_insert successed...");
                response.sendRedirect("index.do");
            }else {
                System.out.println("m_insert failed...");
                response.sendRedirect("m_insert.do");
            }

        } else if(sPath.equals("/m_selectAll.do")){

            String cpage = request.getParameter("cpage");
            String limit = request.getParameter("limit");
            System.out.println("cpage : "+cpage);
            System.out.println("limit : "+limit);

            List<MemberVO> vos = service.selectAll();
            request.setAttribute("vos", vos);

            RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request,response); // 제일 밑줄
        } else if(sPath.equals("/m_selectOne.do")){
            String num = request.getParameter("num");
            System.out.println("num : "+num);

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));
            MemberVO vo2 = service.selectOne(vo);

            request.setAttribute("vo2", vo2);


            RequestDispatcher rd = request.getRequestDispatcher("member/selectOne.jsp");
            rd.forward(request,response);
        } else if (sPath.equals("/m_delete.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("member/delete.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/m_deleteOK.do")) {
            String num = request.getParameter("num");
            System.out.println("num : " + num);

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));

            int result = service.delete(vo);
            System.out.println("m_delete result : "+result);

            if (result == 1) {
                System.out.println("m_delete successed...");
                response.sendRedirect("index.do");
            } else {
                System.out.println("m_delete failed...");
                response.sendRedirect("m_delete.do?num=" + num);
            }
        } else if (sPath.equals("/m_update.do")) {
            String num = request.getParameter("num");
            System.out.println("number : "+num);


            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));
            MemberVO vo2 = service.selectOne(vo);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("member/update.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/m_updateOK.do")) {
            String num = request.getParameter("num");
            System.out.println("num : " + num);
            String id = request.getParameter("id");
            System.out.println("id : " + id);
            String pw = request.getParameter("pw");
            System.out.println("pw : " + pw);
            String name = request.getParameter("name");
            System.out.println("name : " + name);
            String tel = request.getParameter("tel");
            System.out.println("tel : " + tel);

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));
            vo.setId(id);
            vo.setPw(pw);
            vo.setName(name);
            vo.setTel(tel);

            int result = service.update(vo);
            System.out.println("m_update result : "+result);
            if (result == 1) {
                System.out.println("m_update successed...");
                response.sendRedirect("m_selectOne.do?num="+num);
            } else {
                System.out.println("m_update failed...");
                response.sendRedirect("m_update.do?num=" + num);
            }
        } else if (sPath.equals("/m_searchList.do")) {
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<MemberVO> vos = service.searchList(searchKey, searchWord);
            request.setAttribute("vos", vos);

            RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request, response);
        }
    }//end doGet

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);


    }//end doPost


}