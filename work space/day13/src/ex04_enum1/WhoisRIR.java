package ex04_enum1;

public enum WhoisRIR {
	ARIN("whois.arin.net"), 
	RIPE("whois.ripe.net"), 
	APNIC("whois.apnic.net"), 
	AFRINIC("whois.afrinic.net"), 
	LACNIC("whois.lacnic.net"), 
	JPNIC("whois.nic.ad.jp"), 
	KRNIC("whois.nic.or.kr"), 
	CNNIC("ipwhois.cnnic.cn"), 
	UNKNOWN("");

	private String url;

	WhoisRIR(String url) {//set�������ǹ�.
		this.url = url;
	}

	public String url() {//get�޼ҵ�Ͱ����ǹ�
		return url;
	}
	public static void main(String[] args) {
		
	}
}

