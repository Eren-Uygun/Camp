public class PrimeNumber {
	public static void main(String[] args) {
		//1'in asallığı tartışılır.
		for (int sayi = 2; sayi <1000; sayi++) {// 1000'e kadar gidecek sayılarımız
			int divSum = 0; //Kaç sayının bölüneceğini öğrenmek için sayaç
			for(int divider = 1;divider<=sayi;divider++) { //Bölecek sayılarımız
				if (sayi%divider == 0) {
					divSum++;
				}
			}
			if (divSum == 2) { //Asal sayılar sadece 1'e ve kendisine bölünebilir. Onun için bölen sayısı 2 dir.
				System.out.println("Asal sayılar : "+sayi);
			}	
		}
	}
}
