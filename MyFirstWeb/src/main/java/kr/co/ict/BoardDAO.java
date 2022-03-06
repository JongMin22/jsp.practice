package kr.co.ict;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	// DAO코드 재활용하기.
	// 1. UserDAO에서 주석처리가 안 된 부분만 
	// getInstance() 메서드까지 가져옴
	
	// 2. ~~~DAO로 되어있는 부분을 전부 현재 DAO클래스명으로 변경
	// ex) UserDAO -> BoardDAO로 전환중이므로 UserDAO라고 적힌 부분을 전부  BoardDAO로 변경
	private DataSource ds = null;
	
	// 생성할 때 자동으로 Class.forName()을 실행하게 만듭니다.
		// public UserDAO() {
		// 	try {
		//		Class.forName(dbType);
		//		} catch(Exception e) {
		//		e.printStackTrace();
		//	}
		// }
		//  싱글턴 패턴 처리.
		//  DAO 내부에 3. 멤버변수로 UserDAO를 하나 생성해줍니다.
		private static BoardDAO dao = new BoardDAO();
		//  싱글턴은 요청시마다 DAO를 새로 생성하지 않고, 먼저 하나를 생성해둔 다음
		//  사용자 요청때는 이미 생성된 DAO의 주소값만 공유해서
		//  DAO생성에 필요한 시간을 절약하기 위해 사용합니다.
		//  1.생성자는 private으로 처리해 외부에서 생성명령을 내릴 수 없게 처리합니다.
		private BoardDAO() {

		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		}	 
		catch (Exception e) {
			e.printStackTrace();
}
		}
		
		// 2. static 키워드를 이용해서 단 한번만 생성하고, 그 이후로는
		// 주소를 공유하는 getInstance 메서드를 생성합 니다.
		public static BoardDAO getInstance() {
			if(dao == null) {
				dao = new BoardDAO();
			}
				
			return dao;
		}
		// 3. 필요로 하는 로직과 유사한 메서드를 복사해옵니다
		// 게시판 글 전체목록 가져오기 = > 회원 전체 목록 가져오기를 이용해 수정
		// 회원 전체 목록을 가져오는 getAllUserList를 수정해 getAllBoardList()를 생성합니다.
		public List<BoardVO> getAllBoardList(){
			// try 블럭 진입 전 Connection, PrepareStatement, ResultSet 선언
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				List<BoardVO> boardList = new ArrayList<>();
			// Connection, PreparedStatement, ResultSet을 선언합니다.
				try {
					con = ds.getConnection();
				String sql = "SELECT * FROM boardinfo";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				//UserVO ArrayList에 rs에 든 모든 자료를 저장해주세요.
				// int board_num, String title, String content, String writer, Date bdate, Date mdate, int hit
				// 해당 변수를 이용해 BoardVO를 생성하면 됩니다.
				while(rs.next()) {
				int boardNum = rs.getInt("board_num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date bdate = rs.getDate("bdate");
				Date mdate = rs.getDate("mdate");
				int hit = rs.getInt("hit");
				BoardVO boardData = new BoardVO(boardNum,title,content,writer,bdate,mdate,hit);
				boardList.add(boardData);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
				finally{
					try {
					con.close();
					pstmt.close();
					rs.close();
					} catch(SQLException se) {
						se.printStackTrace();
					}
				}
			return boardList;
			}	
}
