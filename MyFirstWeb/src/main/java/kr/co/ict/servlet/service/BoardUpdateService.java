package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;

public class BoardUpdateService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		
		String sbNum = request.getParameter("board_num");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int bNum = Integer.parseInt(sbNum);
		BoardDAO dao = BoardDAO.getInstance();
		dao.boardUpdate(title, content, bNum);
		
	}

}
