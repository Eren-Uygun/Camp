import java.util.Iterator;

public class MyHashMap<Key,Value> {
	Object[] keyArray;
	Object[] valueArray;
	Object[] array;
	
	public MyHashMap() {
		this.keyArray = new Object[0];
		this.valueArray =  new Object[0];
		this.array =  new Object[0];
	}
	
	public void put(Key key,Value value) {

		
		//Ana dizilerle de?ilde temp dizilerle i?lem yap?yoruz.
		
		Object[] tempArray = new Object[array.length+1];
		for (int i = 0; i < tempArray.length-1; i++) {
			tempArray[i] = array[i];
		}
		
		Object[] tempKeyArray = new Object[keyArray.length+1];
		for (int i = 0; i < tempKeyArray.length-1; i++) {
			tempKeyArray[i] = keyArray[i];
			
		}
		
		Object[] tempValueArray =  new Object[valueArray.length+1];
		for (int i = 0; i < tempValueArray.length-1; i++) {
			tempValueArray[i] = valueArray[i];
		}
		
		//Veri atamalar? b?l?m?
		tempArray[tempArray.length-1] = key + " : " + value;
		tempKeyArray[tempArray.length-1] = key;
		tempValueArray[tempValueArray.length-1] = value;
		
		
		
		//Temp Dizileri Olu?tururken +1 ledi?imiz i?in di?er dizilerin boyutlar?n? tempArray'in length ine tan?ml?yoruz.
		//Ekleme oldu?unda Dizi boyutu +1 art?yor.
		array = new Object[tempArray.length];					
		for (int i = 0; i < tempArray.length; i++) {			
			array[i] = tempArray[i];
		}
		
		
		keyArray = new Object[tempKeyArray.length];					

		for (int i = 0; i < tempKeyArray.length; i++) {			
			keyArray[i] = tempKeyArray[i];
		}
		
		valueArray = new Object[tempValueArray.length];					

		for (int i = 0; i < tempValueArray.length; i++) {			
			valueArray[i] = tempValueArray[i];
		}
	
		
		
		
		
		
		
		
	}
	
	public void remove(Key key) {
		
		//Bu b?l?m dizi  ve veri aktar?m?
		
		Object[] tempArray = new Object[array.length];
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = array[i];
		}
		
		Object[] tempKeyArray = new Object[keyArray.length];
		for (int i = 0; i < tempKeyArray.length; i++) {
			tempKeyArray[i] = keyArray[i];
			
		}
		
		Object[] tempValueArray =  new Object[valueArray.length];
		for (int i = 0; i < tempValueArray.length; i++) {
			tempValueArray[i] = valueArray[i];
		}
		
		//----------------------------------------------------------------
		
		
		//
		/*
		int x = 0;
		int y = -1;
		while (x < keyArray.length) {			
			//Key'in varl??? sorgulan?yor.
			if (keyArray[x] == key) {								
				y = x;											
				break;
			} else {											
				x++;
				continue;
			}
		}
		*/
		
		
		int y = -1;
		for (int i = 0; i < keyArray.length; i++) {
			if (keyArray[i] == key) {								
				y = i;											
				break;
			} else {											
				continue;
			}
			
		}

		//Silinecek Data i?in dizilerin tekrar d?zenlenme i?lemi
		//
		if (y != -1) {	
			keyArray = new Object[tempKeyArray.length - 1];
			int a = 0;
			for (int i = 0; i < keyArray.length + 1; i++) {	
				if (i == y) {
					continue;
				} else {
					keyArray[a] = tempKeyArray[i];
					a++;
				}
			}
			valueArray = new Object[tempValueArray.length - 1];
			a=0;
			for (int i = 0; i < valueArray.length + 1; i++) {		
				if (i == y) {
					continue;
				} else {
					valueArray[a] = tempValueArray[i];
					a++;
				}
			}
			array = new Object[tempArray.length - 1];
			a=0;
			for (int i = 0; i < array.length + 1; i++) {		
				if (i == y) {
					continue;
				} else {
					array[a] = tempArray[i];
					a++;
				}
			}
		}
		
		
		
 	}
	
	public void remove(Key key,Value value) {
		
		Object[] tempArray = new Object[array.length];
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = array[i];
		}
		
		Object[] tempKeyArray = new Object[keyArray.length];
		for (int i = 0; i < tempKeyArray.length; i++) {
			tempKeyArray[i] = keyArray[i];
			
		}
		
		Object[] tempValueArray =  new Object[valueArray.length];
		for (int i = 0; i < tempValueArray.length; i++) {
			tempValueArray[i] = valueArray[i];
		}
		
		int x = 0;
		int y = -1;
		while (x < keyArray.length) {								
			if (keyArray[x] == key && valueArray[x] == value) {								
				y = x;											
				break;
			} else {											
				x++;
				continue;
			}
		}

		if (y != -1) {											
			keyArray = new Object[tempKeyArray.length - 1];
			int a = 0;
			for (int i = 0; i < keyArray.length + 1; i++) {		
				if (i == y) {
					continue;
				} else {
					keyArray[a] = tempKeyArray[i];
					a++;
				}
			}
			valueArray = new Object[tempValueArray.length - 1];
			a=0;
			for (int i = 0; i < valueArray.length + 1; i++) {		
				if (i == y) {
					continue;
				} else {
					valueArray[a] = tempValueArray[i];
					a++;
				}
			}
			array = new Object[tempArray.length - 1];
			a=0;
			for (int i = 0; i < array.length + 1; i++) {		
				if (i == y) {
					continue;
				} else {
					array[a] = tempArray[i];
					a++;
				}
			}
		}
	}
	
	public Object get(Key key) {
		int tempKeyIndex = 0;
		
		//int count = 0; //Buradaki count Hashmaplerde bi key value girilen en son de?eri tutar.O bilgiye ula?mak i?in kullan?lacakt?r. Planland? ama yap?lamad?.
		
		for (int keyIndex = 0; keyIndex < array.length; keyIndex++) {
			if (key == keyArray[keyIndex]) {
				//Veriyi ?ekebilmek i?in ilgili anahtar?m?z? tempkey'e g?nderdik.Ve d?ng?den ??kt?k.
				tempKeyIndex = keyIndex;
				break;
			}
		}
		//tempKeyIndex'i d?ng?m?zdeki index ile e?itleyek verinin hangi indexde oldugunu belirleyip veriyi d?nd?r?yoruz.
		for (int valueIndex = 0; valueIndex < valueArray.length; valueIndex++) {
			if (tempKeyIndex==valueIndex) {
				return valueArray[valueIndex];
			}
			
		}
		return "Data Key Not Found Exception";
		
		
	}

	
	public int size() {
		return array.length;
	}
	
	public void clear() {
		array = new Object[0];
		keyArray = new Object[0];
		valueArray = new Object[0];
	}
	
	public void list() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
			
		}
	}
	
}
