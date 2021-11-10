import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Loto {

	// Yaptığım testler doğrultusunda tekrar eden sayı göremedim. Ancak incelerken denk gelirseniz lütfen haber veriniz.S
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); // Kolon sayımız için java.util.Scanner kütüphanesini kullanıyoruz.Ve
												// scannerin input olduğunu belirtiyoruz.

		System.out.print("Kaç kolon oynayacaksınız: ");

		int kolon = input.nextInt();

		System.out.println(" \n");

		for (int i = 0; i < kolon; i++) {
			int[] nums = new int[6]; // Her kolon için 6 sayı tutabilen ayrı ayrı diziler üretiyoruz.
			Random rnd = new Random(); // Loto için üreteceğimiz sayılar için java.util.Random kütüphanesini
										// kullanıyoruz. Random türünde bir rnd oluşturuyoruz.
			System.out.println(" \n");
			System.out.println(i + 1 + ". Kolon ----------------- \n");

			for (int j = 0; j < nums.length; j++) {
				int assignedNum = rnd.nextInt(48) + 1; // 0 gelmemesi için
				nums[j] = assignedNum;
				
				 for (int k = 0; k < j; k++) { //Diziyi gezmek için
					 if (nums[k] == assignedNum) { //Dizinin indeksindeki eleman atanacak sayıya eşit mi ?
						 assignedNum = rnd.nextInt(48)+1; // Sonuç true olursa yeni sayı üretilecek.
						 nums[j] = assignedNum; //k' j ye kadar döneceği için tekrar kontrolü yapılmış oluyor.Var ise yeni numara atanıyor.
						
					}
					
				}
				
			
				System.out.println(nums[j]);

			}

		}
		System.out.println(" ");

	}
		
	

}
