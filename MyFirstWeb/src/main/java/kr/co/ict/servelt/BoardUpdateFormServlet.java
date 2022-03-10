package kr.co.ict.servelt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

/**
 * Servlet implementation class BoardUpdateFormServlet
 */
@WebServlet("/boardUpdateForm")
public class BoardUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. boarddetail.jsp�� �������� ���� �������� �ϰ� post��� ������ �ϴ� form�� submit��ư "�����ϱ�" ������ּ���.
		// 2. doPost���� ������ �����ϱ⸦ �������� ������ �ִ��� üũ���ּ���.
		// 3. �ش� �۹�ȣ�� ����� ������ ������������ ä���� �ϴ� �۹�ȣ�� ���� �Ѱ������� üũ���ּ���.
	String boardnum = request.getParameter("boardnum");
	int board_num = Integer.parseInt(boardnum);
		System.out.println("���� ������ ���� ����!, �� ��ȣ : " + board_num);
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO board = dao.getBoardDetail(board_num);
		 request.setAttribute("board",board);
		
		RequestDispatcher dp = request.getRequestDispatcher("/board/boardUpdateForm.jsp");
		dp.forward(request, response);		
				
				
				
				
				
				
	}

}
