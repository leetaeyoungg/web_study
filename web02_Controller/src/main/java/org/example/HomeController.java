package org.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/hello-servlet","/hello-jsp","/test","/test2.do","/index.do"})
public class HomeController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        String sPath = request.getServletPath();
        System.out.println("sPath:" + sPath);
        if (sPath.equals("/hello-servlet")) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>안녕하세요</h1>");
            out.println("<h1>안녕하세요</h1>");
            out.println("</body></html>");
        } else if (sPath.equals("/hello-jsp")) {
            //request attribute 설정 (setAttribute(key,value))
            request.setAttribute("user_id", "admin");
            RequestDispatcher rd = request.getRequestDispatcher("hello.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/test")) {
            request.setAttribute("user_id", "admin");
            RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/test2.do")) {
            System.out.println("hello test2.do");
            String name = request.getParameter("name");
            System.out.println("name : " + name);
            String age = request.getParameter("age");
            System.out.println("age : " + age);
            String tel = request.getParameter("tel");
            System.out.println("tel : " + tel);

            //TestVO 클래스 만들고 값할당하기
            TestVO vo = new TestVO();
            vo.setName(name);
            vo.setAge(Integer.parseInt(age));
            vo.setTel(tel);
            System.out.println(vo);

            //insert 처리를 했다고 가정하고
            int result = 1;
            if (result == 1) {
                System.out.println("insert successed...");
                //index.jsp 페이지로 이동시키기
                response.sendRedirect("index.do");
            } else {
                System.out.println("insert failed....");
            }
        } else if (sPath.equals("/index.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

    }//end doGet()
}
