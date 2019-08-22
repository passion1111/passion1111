package ex02.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



public class MonitorViewer {
	//의존 관계 (객체)
	
	private Recorder recorder; //멤버필드
	@Autowired
	@Qualifier("cord")
	public void setRecorder(Recorder record) {
		this.recorder = record;
		System.out.println("@Autowired 자동 주입");
	}
	
		
	
	
}
