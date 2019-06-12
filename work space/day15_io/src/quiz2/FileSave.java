package quiz2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Set;

public class FileSave{

	FileSave(){
		try {
			OutputStream os = new FileOutputStream("memo2.txt"); //상대경로 현재 작업하는 폴더에 파일 생성
			while(true) {
				Bmi b=new Bmi();
				
				
				Set<String> set=b.map.keySet();
				for(String set2:set ) {
					String name=b.map.get(set2).name;
					String sex=b.map.get(set2).sex;
					Integer weight=b.map.get(set2).weight;
					Integer height=b.map.get(set2).height;
					String status=b.map.get(set2).status;
					Double bmi=b.map.get(set2).bmi;
					String weight1=Integer.toString(weight);
					String height1=Integer.toString(height);
					String bmi1=Double.toString(height)+"\r";
					String null1=""+"\r\n";
					
					os.write(name.getBytes());
					os.write(sex.getBytes());
					os.write(weight);
					os.write(height);
					os.write(bmi1.getBytes());
					os.write(sex.getBytes());
					os.write(status.getBytes());
					os.write(null1.getBytes());
				}
				break;
				 
			} //end while
			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}		 catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

	

	}
}
	

