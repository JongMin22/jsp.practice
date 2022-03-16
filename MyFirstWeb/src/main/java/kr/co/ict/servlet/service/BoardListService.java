package kr.co.ict.servlet.service;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BoardDAO;
import kr.co.ict.BoardVO;

public class BoardListService implements IBoardService{

	@Override
	// boardlistservlet에서 바인딩 까지만 복사
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// ected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 접속시 BoardDAO생성
		BoardDAO dao = BoardDAO.getInstance();
		// 2. BoardDAO의 getAllBoardList() 호출해 전체 게시글 정보 받아오기
		List<BoardVO> boardList = dao.getAllBoardList();
		// 3. request.setAttribute로 바인딩하기
		// List<BoardVO> boardList를 바로 바인딩할수도 있습니다. 
		request.setAttribute("boardList", boardList);
		
		// 로그인 여부는 세션값을 저장한 다음, 바인딩해서 jsp페이지에서 확인합니다.
		// 서블릿 내부에서 세션쓰는법 
		// 1.세션 객체 생성
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");
		System.out.println("로그인 여부: " + sId);
		// 세션값 체킹이 확인되면 바인딩해주기.
		
		request.setAttribute("sId", sId);
		
		
		
	}

}
