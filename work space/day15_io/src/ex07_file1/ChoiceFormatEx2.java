package ex07_file1;

import java.text.ChoiceFormat;

public class ChoiceFormatEx2 {
	public static void main(String[] args) {
		
			String pattern = "50#F|60#D|70#C|80#B|90#A" ;
			
			int[] scores = { 91, 88, 52, 100, 95, 70, 55, 60, 70 };
			
			ChoiceFormat form = new ChoiceFormat(pattern);
			for(int i=0; i< scores.length;  i++) {
				System.out.println(scores[i] + " : "  + form.format(scores[i]));
			}
	}
}
