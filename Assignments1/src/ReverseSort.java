

public class ReverseSort {
	public static void main(String[] args) {
		
		int[] numbers = {2,40,14,33,21,55,9};
		int arrLength = numbers.length-1;
		
		int temp = 0;
		
		for (int i = 0; i < arrLength; i++) { //Bu bölüm diziyi gezmesi için
			
			for (int j = 0; j <arrLength; j++) {
				//BubbleSort sıralama algoritması 
				if (numbers[j]<numbers[j+1]) {
					temp = numbers[j+1];
					numbers[j+1]=numbers[j];
					numbers[j]=temp;
				}
				
			}
			
		}
		
		for (int i : numbers) {
			System.out.println(i);
		}
		
		
	}

}
