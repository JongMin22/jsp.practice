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
		
	  // request.getParmeter를 이용해 글번호를 가져옵니다.
	  // board_num으로 가져옵니다. int로 바꿔주세요
		String boardnum = request.getParameter("board_num");
		int board_num = Integer.parseInt(boardnum);
		
		// dao 생성
		BoardDAO dao = BoardDAO.getInstance();
		// dao에서 해당 글번호에 대한 정보를 가져오고 
		BoardVO board = dao.getBoardDetail(board_num);
		// 정보가 들어왔는지 디버깅
		 System.out.println(board);
		// 디테일페이지로 포워딩(조금이따)
		 request.setAttribute("board",board);
			
			// 4. /board/boardlist.jsp로 포워딩하기
			// 포워딩 후  el로 바인딩한 자료를 화면에 뿌려보세요
			RequestDispatcher dp = request.getRequestDispatcher("/board/boarddetail.jsp");
			dp.forward(request, response);
			
	}

}
