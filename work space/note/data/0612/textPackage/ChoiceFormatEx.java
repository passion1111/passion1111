package ex02.textPackage;

import java.text.ChoiceFormat;

import javax.jws.soap.SOAPBinding;

public class ChoiceFormatEx {
	public static void main(String[] args) {
		double[]  limits = {50, 60, 70, 80, 90 }; // ���� ������ ū ���� ������ ������
		String[]  grades = { "F", "D", "C", "B", "A" };
		
		int[] scores = { 100, 95, 70, 55, 60, 70  };
		
		ChoiceFormat  form = new ChoiceFormat(limits,  grades);
		for(int i=0; i< scores.length;  i++) {
			System.out.println(scores[i] + " : "  + form.format(scores[i]));
		}
	}
}
