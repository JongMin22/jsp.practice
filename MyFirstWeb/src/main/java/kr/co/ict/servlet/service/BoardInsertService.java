package kr.co.ict.servlet.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BoardDAO;

// IBoardService를 구현해서 서블릿 기능을  서비스로 옮긴 다음 
// insertservlet.do 패턴에서 실행하도록 기능이전을 해주세요
public class BoardInsertService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = BoardDAO.getInstance();
		
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		
		dao.insertBoard(title, content, writer);
		
	}

}
