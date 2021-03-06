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
		
		//Geçici dizimize tüm içeriklerimizi atıyoruz.
		String[] tempArray = new String[myCollection.length];
		for (int i = 0; i < myCollection.length; i++) {
			tempArray[i] = myCollection[i];
		}
//Veri silindiğinde dizimizdeki eleman sayısı azalacağı için diziyi küçültüyoruz.
		myCollection = new String[myCollection.length - 1];
		for (int i = 0; i < myCollection.length; i++) {
			if (tempArray[i] == item) {
				continue;
			} else {
				myCollection[i] = tempArray[i];
				
			}
		}
		
	}
	
	//koleksiyonlarda silme yaparken eleman sayısı -1 olmalı ve eleman kaymalıdır.

	void remove(int index) {
		/*
		if (myCollection[index]!=null) { Bu bölüm dizi içinde nulların oluşmasını sağlıyor.
			myCollection[index] = null;
		}*/
		//Geçici dizimize tüm içeriklerimizi atıyoruz.
		/*
		String[] tempArray = new String[myCollection.length];
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = myCollection[i];
		}
		*/
		
		String[] tempArray =  myCollection;
		//Veri silindiğinde dizimizdeki eleman sayısı azalacağı için diziyi küçültüyoruz.
		myCollection = new String[tempArray.length - 1];
		
		
		
		
		for (int i = 0; i < myCollection.length; i++) {
			if (i == index) {
				//Null olan bölümü atamıyoruz.Bu sayede
				continue; //Şart bloklarını kırar ve sonraki for elemanına geçer.
			}else {
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
