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
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/boarddetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  // request.getParmeter�� �̿��� �۹�ȣ�� �����ɴϴ�.
	  // board_num���� �����ɴϴ�. int�� �ٲ��ּ���
		String boardnum = request.getParameter("board_num");
		int board_num = Integer.parseInt(boardnum);
		
		// dao ����
		BoardDAO dao = BoardDAO.getInstance();
		// dao���� �ش� �۹�ȣ�� ���� ������ �������� 
		BoardVO board = dao.getBoardDetail(board_num);
		// ������ ���Դ��� �����
		 System.out.println(board);
		// �������������� ������(�����̵�)
		 request.setAttribute("board",board);
			
			// 4. /board/boardlist.jsp�� �������ϱ�
			// ������ ��  el�� ���ε��� �ڷḦ ȭ�鿡 �ѷ�������
			RequestDispatcher dp = request.getRequestDispatcher("/board/boarddetail.jsp");
			dp.forward(request, response);
			
	}

}
