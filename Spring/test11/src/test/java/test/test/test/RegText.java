package test.test.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegText {

	
	
	@Test
	public void regtest() {
		String value="qwfqwfqfq23131313123";
		Pattern p=Pattern.compile("([0-9]{3})");
		Matcher m=p.matcher(value);
		System.out.println(m.find());
		if(m.find()) {
			System.out.println(m.group());
			
		}
	}
	@Test
	public void regtest2() {
			 Pattern datePattern = Pattern.compile("([a-z0-9_]*)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6}$)");
				Matcher dateMacher = datePattern.matcher("#dsadasfefewdd@!!naver.qwd");
				if(dateMacher.find()){
					System.out.println(dateMacher.group()); // 2018-01-01
				
		}
	}
	}

