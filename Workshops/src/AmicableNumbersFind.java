import java.util.Iterator;

public class AmicableNumbersFind {

	public static void main(String[] args) {

		for (int param1 = 0; param1 < 300; param1++) {
			for (int param2 = 0; param2 < 300; param2++) {
				int totalDivider1 = 0, totalDivider2 = 0;

				for (int divider = 1; divider < param1; divider++) {
					if (param1 % divider == 0) {
						totalDivider1 += divider;

					}

				}

				for (int divider2 = 1; divider2 < param2; divider2++) {
					if (param2 % divider2 == 0) {
						totalDivider2 += divider2;

					}
				}
				
				
				if (totalDivider1 == param2 && totalDivider2 == param1 && param1!=param2) {
					System.out.println(param1 + " - "+param2 + " arkadaş sayılardır.");
				}
				
				

			}

		}

	}

}
