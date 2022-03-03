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
		System.out.println("/banana ���ӿϷ�!");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("/banana ���ӽ� ������ ��ü�� ���� ����� �ı��մϴ�.");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/spring �ּ� ���� Ȯ��");
		// request.getParameter()�� �̿���
		// "jsp", "boot" ��� �̸����� ���� ��Ҹ� �ֿܼ� �ﵵ�� �ۼ��ϰ�
		// doGet�޼��带 �����ؼ� ������ �����ּ���.
		// Ȯ���ϴ� ����� ?jsp= ��1&boot=��2 �� �ּҵڿ� ���Դϴ�.
		String jsp = request.getParameter("jsp");
		String boot = request.getParameter("boot");
		// "jpa"��� �̸����� ���� ��Ҹ� �ֿܼ� �ﵵ�� �߰����ּ���.
		String jpa = request.getParameter("jpa");
		System.out.println(jsp);
		System.out.println(boot);
		System.out.println(jpa);
		// �����̷�Ʈ ����� �������� �̵��ϰ� �����ʹ� ���� �������� �ʽ��ϴ�.
		// response.sendRedirect("http://localhost:8181/MyFirstWeb/servletForm/bananaResult.jsp");
		// ������ �ϱ� �� request�� setAttribute()�� �̿��� �����͸� �����մϴ�.
		// request.setAttribute("�����̸�",�ڷ�);
		request.setAttribute("jsp", jsp);
		request.setAttribute("boot", boot);
		request.setAttribute("jpa", jpa);
		// ��� ������ �Բ� �����ϱ� ���� forward�� ��� ����մϴ�.
		// ������ �ּҴ� localhost:��Ʈ��ȣ/������Ʈ��/���İ�� <= /���İ�� ���� ����
		RequestDispatcher dp = request.getRequestDispatcher("/servletForm/bananaResult.jsp");
		
		dp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost�� ������� ��� ���븸 ���� �������� form���� post������� ������ �� ȣ��˴ϴ�.
		request.setCharacterEncoding("utf-8");
		System.out.println("/banana �ּ� post������� ������");
		String jsp = request.getParameter("jsp");
		String boot = request.getParameter("boot");
		String jpa = request.getParameter("jpa");
		System.out.println("post��� : " + jsp);
		// �Ʒ� sendRedirect��� ��ſ�, springpostReuslt.jsp�� �����Ѵ��� 
		// post��� ó���� ���������� jsp, boot, jpa ������ ȭ�鿡 ǥ��ǵ��� ���ּ���.
		// response.sendRedirect("http://localhost:8181/MyFirstWeb/servletForm/bananaResult.jsp");
		request.setAttribute("jsp", jsp);
		request.setAttribute("boot", boot);
		request.setAttribute("jpa", jpa);
		RequestDispatcher dp = request.getRequestDispatcher("/servletForm/bananaPostResult.jsp");
		dp.forward(request, response);
		
	}

}
