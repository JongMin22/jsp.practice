package kr.co.ict;

public class UserVO {
	// VO�� Ư�� ���̺��� �ڷḦ �ڹ��������� �����ϱ� ���� �����մϴ�.
	// �׷��� SQ�����͸� �ڹٷ� �Űܿ��� ���ؼ�
	// 1.����� ���̺��� �÷��� ���� ������ ����ϴ�.
	private String uName;
	private String uId;
	private String uPw;
	private String uEmail;
	// 2. getter, setter, �����ڸ� ������ּ���.
	public UserVO(String uName, String uId, String uPw, String uEmail) {
		super();
		this.uName = uName;
		this.uId = uId;
		this.uPw = uPw;
		this.uEmail = uEmail;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	// 3. ���� toString�����
	
}
