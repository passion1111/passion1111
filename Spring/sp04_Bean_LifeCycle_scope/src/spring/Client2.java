package spring;

public class Client2 {

	private String host;
	
	public void setHost(String host) {  //DI
		this.host = host;
		System.out.println("Client2.setHost() 실행");
	}

	
	public void connect() throws Exception {
		System.out.println("Client2.connect() 실행");
	}

	public void send() {
		System.out.println("Client2.send() to " + host);
	}

	//사용자가 만든 close() 
	public void close() throws Exception {
		System.out.println("Client2.close() 실행");
	}

}
