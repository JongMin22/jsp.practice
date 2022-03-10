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
		//1. boarddetail.jsp에 목적지를 현재 서블릿으로 하고 post방식 전달을 하는 form과 submit버튼 "수정하기" 만들어주세요.
		// 2. doPost에서 실제로 수정하기를 눌렀을때 반응이 있는지 체크해주세요.
		// 3. 해당 글번호에 저장된 정보로 수정페이지를 채워야 하니 글번호도 같이 넘겨지는지 체크해주세요.
	String boardnum = request.getParameter("boardnum");
	int board_num = Integer.parseInt(boardnum);
		System.out.println("수정 페이지 접근 성공!, 글 번호 : " + board_num);
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO board = dao.getBoardDetail(board_num);
		 request.setAttribute("board",board);
		
		RequestDispatcher dp = request.getRequestDispatcher("/board/boardUpdateForm.jsp");
		dp.forward(request, response);		
				
				
				
				
				
				
	}

}
