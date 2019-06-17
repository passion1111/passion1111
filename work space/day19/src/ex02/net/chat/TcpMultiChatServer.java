package ex02.net.chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class TcpMultiChatServer {
	HashMap clients;//key,value
	public TcpMultiChatServer() {//생성자함수
		clients=new HashMap();//해쉬맵 객체생성
		Collections.synchronizedMap(clients);//동기화
		
		
	}
	public void start() {
		ServerSocket ss=null;//socket1
		Socket s=null;//socket2
		
		try {
			ss=new ServerSocket(9999);
			System.out.println("서버 시작 됐습니다");
			
			while(true) {
				s=ss.accept();
				System.out.println("["+s.getInetAddress()+":"+s.getPort()+"]에서 접속하셨습니다"); //getInetAddress IP주소 port 포트번호 알아와서 어디서 접속했는지 확인
				ServerReceiver thread=new ServerReceiver(s);//사용자클래스임
				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//start end
	
	public void sendToAll(String msg) {//user method
		Iterator it=clients.keySet().iterator();//키 값 출력
		
		while(it.hasNext()) {//요소가 있다면.
			try {
				DataOutputStream dos=(DataOutputStream)clients.get(it.next());//get은 오브젝트타입인데 그냥받아와서 오류뜸 형변환
				dos.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}//sendToAll()end
	
	
	class ServerReceiver extends Thread{//inner class
		Socket s;//클라이언트소켓
		DataInputStream dis;
		DataOutputStream dos;//위의 dos는 try안에 있어서 충돌이안남 위 try는 벗어나는순간 사라지니
		public ServerReceiver(Socket s) {
			this.s=s;
			try {
				dis=new DataInputStream(s.getInputStream());//네트워크 통해서 읽기
				dos=new DataOutputStream(s.getOutputStream());//네트워크 통해서  쓰기
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}//생성자 end

		@Override
		public void run() {//쓰레드 클래스로 썼기떄문에  run필요,쓰레드 실행부
			String name="";
			try {
				name=dis.readUTF();
				sendToAll("#"+name+"님이 입장하셨습니다");//생성자 메소드
				
				System.out.println(dos.toString().hashCode());
				clients.put(name, dos);//hashmap넣기
				System.out.println("현재 서버 접속자 수는:"+clients.size()+"입니다");//접속자수확인
				
				while(dis!=null) {
					sendToAll(dis.readUTF());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
//				sendToAll("#"+name+"님이 퇴장하셨습니다.");//생성자 메소드
				clients.remove(name);//접속자 수 제거
				System.out.println("["+s.getInetAddress()+":"+s.getPort()+"]에서 접속종료하셨습니다"); //getInetAddress IP주소 port 포트번호 알아와서 어디서 접속했는지 확인
				System.out.println("현재 서버 접속자 수는:"+clients.size()+"입니다");//접속자수확인
				
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new TcpMultiChatServer().start();
	}
}
