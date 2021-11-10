public class AmicableNumbers {
	public static void main(String[] args) {
		// int sayi1=220,sayi2=284;
		// int param1=283,param2=220;
		int param1 = 1184, param2 = 1210;
		// int param1 = 17296, param2 = 18416;
		int divSum = 0, divSum2 = 0;
		//div divider(bölen) , divSum dividerSummary(bölenlerin toplamı)

		for (int div = 1; div < param1; div++) {// parametre 1 için  bölenleri toplar
			if (param1 % div == 0) {
				divSum += div;
			}
		}
		for (int div = 1; div < param2; div++) {// Parametre 2 için bölenleri toplar
			if (param2 % div == 0) {
				divSum2 += div;
			}
		}
		if (divSum == param2 && divSum2 == param1) {
			System.out.println(param1 + " & " + param2 + " arkadaş sayılardır.");
		} else {
			System.out.println(param1 + " & " + param2 + " arkadaş sayılar değildir.");
		}
	}
	
}


