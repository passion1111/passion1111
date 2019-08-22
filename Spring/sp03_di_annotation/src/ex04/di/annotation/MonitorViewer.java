package ex04.di.annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



public class MonitorViewer {
	//의존 관계 (객체)
	
	private Recorder recorder; //멤버필드
	
	@Resource(name="record1") 
	public void setRecorder(Recorder record) {
		this.recorder = record;
		
//		if (Resource.class.getTypeName().equals("record1")) {
//			System.out.println("record1 @Resource  주입");
//			
//		} else if (record.equals("record2")) {
//			System.out.println("record1 @Resource  주입");
//			
//		}else if (record.equals("record3")) {
//			System.out.println("record3 @Resource  주입");
//		}

		System.out.println("@Resource  주입");
	}
	
		
	
	
}
