package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommandPatternServlet
 */
@WebServlet("*.test")
public class CommandPatternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandPatternServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(".test 패턴으로 접속 감지됨.");
		String uri = request.getRequestURI();
		System.out.println(uri);
		if(uri.equals("/MyFirstWeb/main.test")) {
			System.out.println("메인페이지로 이동합니다");
			response.sendRedirect("http://localhost:8181/MyFirstWeb/");
			}
		else if(uri.equals("/MyFirstWeb/board.test")) {
			System.out.println("게시판페이지로 이동합니다.");
		}
		else if(uri.equals("/MyFirstWeb/boardlist.test")) {
			response.sendRedirect("http://localhost:8181/MyFirstWeb/boardList");
		}
		else if(uri.equals("/MyFirstWeb/login.test")) {
			response.sendRedirect("http://localhost:8181/MyFirstWeb/users/login_form.jsp");
		}
		else {
			System.out.println("메인페이지로 이동합니다");
			response.sendRedirect("http://localhost:8181/MyFirstWeb/");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
