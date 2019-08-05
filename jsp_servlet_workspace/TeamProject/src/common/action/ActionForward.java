package common.action;


/**
 * 페이지 이동을 처리하기 위한 클래스
 */
public class ActionForward {
	
	//리다이렉트할지 판단하는 변수
	private boolean isRedirect = false;
	
	
	private String nextPath = null; // 이동할 다음 화면
	
	/**
	 * Redirect 사용여부, false이면 Forward 사용
	 *  즉 isredirect가 참이면 setredirect가 실행
	 *  아니면 forward로 보냄.
	 *  setter getter라고 생각하면 됨.
	 */
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getNextPath() {
		return nextPath;
	}
	public void setNextPath(String nextPath) {
		this.nextPath = nextPath;
	}
}
