package Kiosk_main;

import java.util.ArrayList;

public class EnterDesign {

	public static void main(String[] args) {

		welcome(text());

	}

	private static void welcome(ArrayList<String> array) {

		try {
			while (true) {
				for (int i = 0; i < array.size(); i++) {
					System.out.println(array.get(i));
					Thread.sleep(400);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static ArrayList<String> text() {
		ArrayList<String> txt = new ArrayList<String>();

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
