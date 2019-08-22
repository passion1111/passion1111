package ex06.diannotation;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SalaryMan implements Person {
	
	SalaryMan salaryman;
	

	@Autowired
	@Qualifier("salaryman")
	public void setSalaryman(SalaryMan salaryman) {
		this.salaryman = salaryman;
	}

	@Override
	public void info() {
		
		System.out.println("회사원 나이는 13살  성별 남자 이름 떙떙이.");
	}

	

}
