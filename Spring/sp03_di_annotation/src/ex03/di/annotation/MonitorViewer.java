package ex03.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;



public class MonitorViewer {
	//의존 관계 (객체)
	
	private Recorder recorder; //멤버필드
	
	@Autowired(required = false) /* default : required=true */	/* injection 되는 타입의 객체(bean)가 존재하지 않아도 Error 없이 실행 가능 */
	public void setRecorder(Recorder record) {
		this.recorder = record;
		System.out.println("@Autowired 자동 주입");
	}
	
		
	
	
}
