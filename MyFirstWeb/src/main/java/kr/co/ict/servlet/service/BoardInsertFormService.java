package kr.co.ict.servlet.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardInsertFormService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");
		
		System.out.println("세션아이디 확인 : " + sId);
		request.setAttribute("sId", sId);
		
		
		
	}

}
