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

	WhoisRIR(String url) {//set과같은의미.
		this.url = url;
	}

	public String url() {//get메소드와같은의미
		return url;
	}
	public static void main(String[] args) {
		
	}
}

