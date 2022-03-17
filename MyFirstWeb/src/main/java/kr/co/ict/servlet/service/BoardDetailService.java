package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

public class BoardDetailService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String sbNum = request.getParameter("board_num");
		int bNum = Integer.parseInt(sbNum);
		
		
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardVO board = dao.getBoardDetail(bNum);
		
		request.setAttribute("board", board);
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");
		
		System.out.println("세션아이디 확인 : " + sId);
		request.setAttribute("sId", sId);
		
	}

}
