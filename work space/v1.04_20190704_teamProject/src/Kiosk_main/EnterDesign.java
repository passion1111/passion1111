package Kiosk_main;

import java.util.ArrayList;

public class EnterDesign {

	public static void main(String[] args) {

		welcome(text());

	}

	private static void welcome(ArrayList<String> array) {

		try {
			
				for (int i = 0; i < array.size(); i++) {
					System.out.println(array.get(i));
					Thread.sleep(400);
				}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static ArrayList<String> text() {
		ArrayList<String> txt = new ArrayList<String>();
//		txt.add("         กแ       กแ                                                 กแ          กแ   กแกแ                                       ");
//		txt.add("     กแกแกแกแกแกแกแกแกแกแ  กแ                    กแกแกแกแกแกแกแกแกแกแ    กแ              กแ          กแ   กแกแ                         ");
//		txt.add("        กแกแกแกแ     กแ                    กแ             กแ              กแกแกแกแกแกแกแกแกแกแกแกแ   กแกแ                         ");
//		txt.add("       กแ    กแ    กแกแกแกแ                 กแ             กแ              กแ          กแ   กแกแ                         ");
//		txt.add("       กแ    กแ    กแ                    กแ             กแกแกแกแกแกแกแ        กแ          กแ   กแกแกแกแกแกแกแกแกแ                 ");
//		txt.add("        กแกแกแกแ     กแ                    กแ             กแ              กแ          กแ   กแกแ                         ");
//		txt.add("                                      กแ             กแ              กแกแกแกแกแกแกแกแกแกแกแกแ   กแกแ                         ");
//		txt.add("         กแกแกแกแกแกแกแกแกแ                    กแกแกแกแกแกแกแกแกแกแ    กแ                             กแกแ                         ");
//		txt.add("                 กแ                                  กแ                   กแกแกแกแกแกแกแกแ                            ");
//		txt.add("                 กแ                                                    กแ         กแ                           ");
//		txt.add("                 กแ                                                    กแ         กแกแ                          ");
//		txt.add("                                                                       กแ        กแ                           ");
//		txt.add("                                                                          กแกแกแกแกแกแกแ                             ");
//		txt.add("                                                                                                             ");
		txt.add("                                                                                                             ");
		txt.add("                                                                                                             ");
		txt.add("         กแกแ      กแกแ                                                 กแกแ         กแกแ   กแกแ                                       ");
		txt.add("     กแกแกแกแกแกแกแกแกแกแ  กแกแ                   กแกแกแกแกแกแกแกแกแกแกแ    กแกแ             กแกแ         กแกแ   กแกแ                         ");
		txt.add("        กแกแกแกแ     กแกแ                   กแกแ             กแกแ             กแกแกแกแกแกแกแกแกแกแกแกแกแ   กแกแ                         ");
		txt.add("       กแ   กแกแ    กแกแกแกแ                 กแกแ             กแกแ             กแกแ         กแกแ   กแกแ                         ");
		txt.add("       กแ   กแกแ    กแกแ                   กแกแ             กแกแกแกแกแกแกแ        กแกแ         กแกแ   กแกแกแกแกแกแกแกแกแ                 ");
		txt.add("        กแกแกแกแ     กแกแ                   กแกแ             กแกแ             กแกแ         กแกแ   กแกแ                         ");
		txt.add("                                      กแกแ             กแกแ             กแกแกแกแกแกแกแกแกแกแกแกแกแ   กแกแ                         ");
		txt.add("         กแกแกแกแกแกแกแกแกแกแ                   กแกแกแกแกแกแกแกแกแกแกแ    กแกแ                             กแกแ                         ");
		txt.add("                 กแกแ                                  กแกแ                 กแกแกแกแกแกแกแกแกแ                            ");
		txt.add("                 กแกแ                                                    กแกแ       กแกแ                           ");
		txt.add("                 กแกแ                                                    กแกแ        กแกแ                          ");
		txt.add("                                                                       กแกแ        กแกแ                           ");
		txt.add("                                                                         กแกแกแกแกแกแกแกแ                            ");
		txt.add("                                                                                                             ");
		txt.add("                                                                                                             ");
		txt.add("                                                                                                             ");
	

		return txt;
	}

}
