package yaya.model;

import org.springframework.stereotype.Component;

@Component
public class yayaVO {
String id;
String pwd;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
}
