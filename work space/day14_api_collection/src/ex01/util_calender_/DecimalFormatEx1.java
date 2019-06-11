package ex01.util_calender_;
import java.text.*;

class DecimalFormatEx1 
{
	public static void main(String[] args) throws Exception
	{
		double number  = 1234567.89;

		String[] pattern = {
			"0",
			"#",
			"0.0",
			"#.#",
			"0000000000.0000",
			"##########.####",
			"#.#-",
			"-#.#",
			"#,###.##",
			"#,####.##",
			"#E0",
			"0E0",
			"##E0",
			"00E0",
			"####E0",
			"0000E0",
			"#.#E0",
			"0.0E0",
			"0.000000000E0",
			"00.00000000E0",
			"000.0000000E0",
			"#.#########E0",
			"##.########E0",
			"###.#######E0",
			"#,###.##+;#,###.##-",
			"#.#%",
			"#.#\u2030",
			"\u00A4 #,###",
			"'#'#,###",
			"''#,###",
		};
		
		for(int i=0; i < pattern.length; i++) {//한바퀴 다 돌면서 dateformat에 맞는 형식에 맞게 
//												출력하는 함수.
		    DecimalFormat df = new DecimalFormat(pattern[i]);
		    System.out.printf("%19s : %s\n",pattern[i], df.format(number));//19자리에 맞게 출력
		}
	} // main
}