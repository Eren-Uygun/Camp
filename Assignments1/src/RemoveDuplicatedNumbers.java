import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class RemoveDuplicatedNumbers {

	public static void main(String[] args) {

		// Amacımız tekrar eden sayıları diziden çıkarıp yeni bir dizi oluşturmak.
		int[] numbers = { 10, 32, 21, 44, 10, 32, 93, 71, 66, 44, 10 };
		int[] newNumbersArr;
		for (int i = 0; i < numbers.length - 1; i++) { // Bu bölüm diziyi gezmesi için
			int dupliCount = 0;

			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) {
					dupliCount++; //Tekrar edenlerin sayısı
				}

			}
			newNumbersArr = new int[numbers.length-1-dupliCount]; //Bu sistemi yapma fikri dizide bulunan 0 ları gizlemek yerine ,tekrar eden sayıların işgal ettiği indekslerinde silmek
			
			if (dupliCount == 0) {
					newNumbersArr[i] = numbers[i];
					System.out.println(newNumbersArr[i]);
				}
				
			

		}
		

	}

}
