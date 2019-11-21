package selfcheck;

public class Stringreplace {

	public static void main(String[] args) {
		String str="3weifjewioj43240823r90f0wef";
		String str2=str.replaceAll("[^0-9]", "");
//		str.replace("we", "11111");
		System.out.println(str2);
	}
}
