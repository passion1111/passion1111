package ex01.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;


public class MonitorViewer {
	//의존 관계 (객체)
	
	/*
	//1번 : member field 설정( memberfield 의존관계 자동 주입 )
	@Autowired 
	private Recorder recorder; //멤버필드 
	
	public Recorder getRecorder() {
		return recorder;
	}

	*/
	/*
	//2번 : setter 를 통한 자동 주입
	
	private Recorder recorder; //멤버필드
	public Recorder getRecorder() {
			return recorder;
		}
	
	@Autowired
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("@Autowired 자동 주입");
	}
}
*/
	
	//3번 일반 method를 통한 자동 주입
   	 
	private Recorder recorder;
	public Recorder getRecorder() {
			return recorder;
		}
	@Autowired
	public void RecorderMethod(Recorder recorder){
		this.recorder = recorder;
	}
	public void RecorderMethodPrint(){
		System.out.println("method 주입 : " + this.recorder);
	}
	
	
}
