package kr.co.ict.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("삭제 페이지 접근 성공");
		String boardnum = request.getParameter("boardnum");
		int board_num = Integer.parseInt(boardnum);
		System.out.println(board_num);
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(board_num);
		response.sendRedirect("http://localhost:8181/MyFirstWeb/boardList");
		
	}

}
