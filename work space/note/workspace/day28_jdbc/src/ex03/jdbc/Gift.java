package ex03.jdbc;

public class Gift {   // Model
	
	public final String ClassName = "Gift";
	
	//gno, gname, g_start, g_end
	private int num;
	private String gname;
	private int g_start;
	private int g_end;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getG_start() {
		return g_start;
	}
	public void setG_start(int g_start) {
		this.g_start = g_start;
	}
	public int getG_end() {
		return g_end;
	}
	public void setG_end(int g_end) {
		this.g_end = g_end;
	}
	
	public String getClassName() {
		return ClassName;
	}

}
