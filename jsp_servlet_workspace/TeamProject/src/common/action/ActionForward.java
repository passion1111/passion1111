package common.action;


/**
 * ������ �̵��� ó���ϱ� ���� Ŭ����
 */
public class ActionForward {
	
	//�����̷�Ʈ���� �Ǵ��ϴ� ����
	private boolean isRedirect = false;
	
	
	private String nextPath = null; // �̵��� ���� ȭ��
	
	/**
	 * Redirect ��뿩��, false�̸� Forward ���
	 *  �� isredirect�� ���̸� setredirect�� ����
	 *  �ƴϸ� forward�� ����.
	 *  setter getter��� �����ϸ� ��.
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
