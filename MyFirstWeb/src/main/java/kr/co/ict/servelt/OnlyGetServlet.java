package kr.co.ict.servelt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OnlyGetServlet
 */
@WebServlet("/getServlet")
public class OnlyGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnlyGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("/getServlet 최초 접속");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("/getServlet 접속시 생성된 객체는 서버 종료로 인해 파기됩니다.");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		RequestDispatcher dp = request.getRequestDispatcher("/servletForm/onlyGetResult.jsp");
		dp.forward(request, response);
		System.out.println(name);
	}

}
