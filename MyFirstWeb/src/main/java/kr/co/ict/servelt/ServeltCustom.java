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
 * Servlet implementation class ServeltCustom
 */
@WebServlet("/banana")
public class ServeltCustom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeltCustom() {
        super();
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("/banana 접속완료!");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("/banana 접속시 생성된 객체는 서버 종료로 파기합니다.");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/spring 주소 접속 확인");
		// request.getParameter()를 이용해
		// "jsp", "boot" 라는 이름으로 들어온 요소를 콘솔에 찍도록 작성하고
		// doGet메서드를 복사해서 저한테 보내주세요.
		// 확인하는 방법은 ?jsp= 값1&boot=값2 를 주소뒤에 붙입니다.
		String jsp = request.getParameter("jsp");
		String boot = request.getParameter("boot");
		// "jpa"라는 이름으로 들어온 요소를 콘솔에 찍도록 추가해주세요.
		String jpa = request.getParameter("jpa");
		System.out.println(jsp);
		System.out.println(boot);
		System.out.println(jpa);
		// 리다이렉트 방식은 페이지만 이동하고 데이터는 같이 전송하지 않습니다.
		// response.sendRedirect("http://localhost:8181/MyFirstWeb/servletForm/bananaResult.jsp");
		// 포워딩 하기 전 request에 setAttribute()를 이용해 데이터를 저장합니다.
		// request.setAttribute("보낼이름",자료);
		request.setAttribute("jsp", jsp);
		request.setAttribute("boot", boot);
		request.setAttribute("jpa", jpa);
		// 상단 변수를 함께 전달하기 위해 forward를 대신 사용합니다.
		// 목적지 주소는 localhost:포트번호/프로젝트명/이후경로 <= /이후경로 부터 복붙
		RequestDispatcher dp = request.getRequestDispatcher("/servletForm/bananaResult.jsp");
		
		dp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost는 현재까지 배운 내용만 놓고 봤을때는 form에서 post방식으로 제출할 때 호출됩니다.
		request.setCharacterEncoding("utf-8");
		System.out.println("/banana 주소 post방식으로 접속함");
		String jsp = request.getParameter("jsp");
		String boot = request.getParameter("boot");
		String jpa = request.getParameter("jpa");
		System.out.println("post방식 : " + jsp);
		// 아래 sendRedirect방식 대신에, springpostReuslt.jsp를 생성한다음 
		// post방식 처리시 포워딩으로 jsp, boot, jpa 변수가 화면에 표출되도록 해주세요.
		// response.sendRedirect("http://localhost:8181/MyFirstWeb/servletForm/bananaResult.jsp");
		request.setAttribute("jsp", jsp);
		request.setAttribute("boot", boot);
		request.setAttribute("jpa", jpa);
		RequestDispatcher dp = request.getRequestDispatcher("/servletForm/bananaPostResult.jsp");
		dp.forward(request, response);
		
	}

}
