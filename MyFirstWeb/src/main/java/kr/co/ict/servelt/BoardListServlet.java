package kr.co.ict.servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getInstance();
		// 2. BoardDAO�� getAllBoardList() ȣ���� �Խñ� ���� �޾ƿ���
		List<BoardVO> boardList = dao.getAllBoardList();
		// 3. request.setAttribute�� ���ε��ϱ�
		request.setAttribute("boardList",boardList);
		
		// 4. /board/boardlist.jsp�� �������ϱ�
		// ������ ��  el�� ���ε��� �ڷḦ ȭ�鿡 �ѷ�������
		RequestDispatcher dp = request.getRequestDispatcher("/board/boardlist.jsp");
		dp.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
