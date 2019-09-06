package kr.co.dept.model;

public class Dept2DTO {
	private int dcode;
	private String dname, pdept, area;

	public Dept2DTO(int dcode, String dname, String pdept, String area) {
		super();
		this.dcode = dcode;
		this.dname = dname;
		this.pdept = pdept;
		this.area = area;
	}

	public Dept2DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDcode() {
		return dcode;
	}

	public void setDcode(int dcode) {
		this.dcode = dcode;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getPdept() {
		return pdept;
	}

	public void setPdept(String pdept) {
		this.pdept = pdept;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Dept2DTO [dcode=" + dcode + ", dname=" + dname + ", pdept=" + pdept + ", area=" + area + "]";
	}

}
