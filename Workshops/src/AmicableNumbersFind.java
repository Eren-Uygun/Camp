import java.util.Iterator;

public class AmicableNumbersFind {

	public static void main(String[] args) {

		for (int sayi1 = 0; sayi1 < 300; sayi1++) {

			int totalDivider = 0;

			for (int divider1 = 1; divider1 < sayi1; divider1++) {
				if (sayi1 % divider1 == 0) {
					totalDivider += divider1;
				}

			}
			
			for (int sayi2 = 0; sayi2 < 300; sayi2++) {
				int totalDivider2 = 0;
				for (int divider2 = 1; divider2 < sayi2; divider2++) {
					if (sayi2 % divider2 == 0) {
						totalDivider2 += divider2;
					}

				}

				if (sayi1 == totalDivider && sayi2 == totalDivider2 && sayi1 != sayi2) {
					System.out.println(sayi1 + "," + sayi2);
					
				}
			}
				
				
			
		}

	}

}
