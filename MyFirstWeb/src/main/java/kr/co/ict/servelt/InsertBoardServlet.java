package kr.co.ict.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

/**
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet("/insertBoard")
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // �⺻������, SELECT�� ������ ������ ȣ���� POST�θ� ������ �� �ְ� �մϴ�.
        // 1. DAO ����
        BoardDAO dao = BoardDAO.getInstance();
        // 2. ������ ���ƿö� ����ϴ� name�� title, content, writer�Դϴ�.
        // ������ ������ �����͸� �ڹٵ����ͷ� �������ּ���.
        request.setCharacterEncoding("utf-8");
        String title =  request.getParameter("title");
        String content = request.getParameter("content");
        String writer =  request.getParameter("writer");
        
        // insert���� ȣ��(�ʿ� �Ķ���ʹ� ������ ���ƿ´ٰ� �����ϰ� �Է����ּ���.)
        dao.insertBoard(title, content, writer);
        System.out.println(dao);
        // �� �����ٸ�, �����̷�Ʈ ������� ���� �ּ� boardlist�� �̵���ŵ�ϴ�.
        response.sendRedirect("http://localhost:8181/MyFirstWeb/boardList");
    }
}
