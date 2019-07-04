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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static ArrayList<String> text() {
		ArrayList<String> txt = new ArrayList<String>();

		txt.add("                                                                                                             ");
		txt.add("                                                                                                             ");
		txt.add("         ¡á¡á      ¡á¡á                                                 ¡á¡á         ¡á¡á   ¡á¡á                                       ");
		txt.add("     ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á  ¡á¡á                   ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á    ¡á¡á             ¡á¡á         ¡á¡á   ¡á¡á                         ");
		txt.add("        ¡á¡á¡á¡á     ¡á¡á                   ¡á¡á             ¡á¡á             ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á   ¡á¡á                         ");
		txt.add("       ¡á   ¡á¡á    ¡á¡á¡á¡á                 ¡á¡á             ¡á¡á             ¡á¡á         ¡á¡á   ¡á¡á                         ");
		txt.add("       ¡á   ¡á¡á    ¡á¡á                   ¡á¡á             ¡á¡á¡á¡á¡á¡á¡á        ¡á¡á         ¡á¡á   ¡á¡á¡á¡á¡á¡á¡á¡á¡á                 ");
		txt.add("        ¡á¡á¡á¡á     ¡á¡á                   ¡á¡á             ¡á¡á             ¡á¡á         ¡á¡á   ¡á¡á                         ");
		txt.add("                                      ¡á¡á             ¡á¡á             ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á   ¡á¡á                         ");
		txt.add("         ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á                   ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á    ¡á¡á                             ¡á¡á                         ");
		txt.add("                 ¡á¡á                                  ¡á¡á                 ¡á¡á¡á¡á¡á¡á¡á¡á¡á                            ");
		txt.add("                 ¡á¡á                                                    ¡á¡á       ¡á¡á                           ");
		txt.add("                 ¡á¡á                                                    ¡á¡á        ¡á¡á                          ");
		txt.add("                                                                       ¡á¡á        ¡á¡á                           ");
		txt.add("                                                                         ¡á¡á¡á¡á¡á¡á¡á¡á                            ");
		txt.add("                                                                                                             ");
		txt.add("                                                                                                             ");
		txt.add("                                                                                                             ");
	

		return txt;
	}

}
