package kr.co.ict.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("수정창에서 --> 수정로직 진입완료");
		String boardnum = request.getParameter("boardnum");
		int board_num = Integer.parseInt(boardnum);
		
	
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDAO dao = BoardDAO.getInstance();
		dao.updateBoard(board_num, title, content);
		response.sendRedirect("http://localhost:8181/MyFirstWeb/boarddetail?"+board_num + "=" +board_num);
	}

}
