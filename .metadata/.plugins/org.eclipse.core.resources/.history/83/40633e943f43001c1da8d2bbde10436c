import java.util.Iterator;

public class MyCollection {

	String[] myCollection;

	public MyCollection() {
		// Program çalıştığında hiç eleman tutamayan bir dizimiz olacak.
		myCollection = new String[0];
	}

	void add(String value) {
		// Dizimiz eleman tutamayacağı için geçici bir dizi oluşturuyoruz.
		// Dizimizin adreslerini yeni oluşturduğumuz diziye atıyoruz.
		String[] tempArray = myCollection;
		// Adresini kopyalasakda eleman ekleyemeyeceğimiz dizi olacağı için
		// Dizimizi new liyoruz ve boyutunu 1 arttırıyoruz.
		myCollection = new String[myCollection.length + 1];
		
		for (int i = 0; i < tempArray.length; i++) {
			myCollection[i] = tempArray[i];
		}
		// Dizilerin indeksleri 0 dan başladığı için dizinin uzunluğu - 1 yapıyoruz.
		myCollection[myCollection.length - 1] = value;

	}

	void remove(String item) {
		int nullcount = 0;
		for (int i = 0; i < myCollection.length-1; i++) {
			if (myCollection[i] == item) {
				myCollection[i] = null;
				nullcount++;
			}
			
		}
		
		String[] tempArray = myCollection;
		myCollection = new String[myCollection.length-nullcount];
		
		for (int i = 0; i < tempArray.length-1; i++) {
			if (tempArray[i]!=null) {
				myCollection[i] = tempArray[i];
			}
		}
		
		
	}

	void remove(int index) {
		int nullcount = 0;
		
		for (int i = 0; i < myCollection.length-1; i++) {
			if (myCollection[i] == myCollection[index]) {

				myCollection[index] = null;
				nullcount++;
			}
			
		}
		
		String[] tempArray = myCollection;
		myCollection = new String[myCollection.length-nullcount];
		
		for (int i = 0; i < myCollection.length-1; i++) {
			if (tempArray[i]!=null) {
				myCollection[i] = tempArray[i];
			}
		}
		
		
		

	}

	String get(int index) {
		return myCollection[index];

	}

	void toList() {
		
		for (String list : myCollection) {
			System.out.println(list);
			/*
			 * if (list != null) { System.out.println(list); }
			 */

		}

	}

	boolean contains(String item) {
		boolean found = false;
		for (int j = 0; j < myCollection.length; j++) {
			if (myCollection[j] == item) {
				found = true;
				return found;
			}

		}
		return found;
	}

	int length() {
		return myCollection.length;
	}


}
