package classes;

import java.util.List;

//Generic type
//T convention => type demekdir.Hangi nesneyi verirsen çalışır.
public class MyList<T> {
	
	Object[] genericArray;
	
	
	public MyList() {
		genericArray = new Object[0];
	}
	



	public void add(T item) {
		Object[] tempArray = new Object[genericArray.length];
		for (int i = 0; i < genericArray.length; i++) {
			tempArray[i] = genericArray[i];
		}

		genericArray = new Object[genericArray.length+1];
		for (int i = 0; i < genericArray.length-1; i++) {
			genericArray[i] = tempArray[i];
		}
		
		genericArray[genericArray.length-1] = item;
		
	}
	
	public void remove(T item) {

		Object[] tempArray = new Object[genericArray.length];
		for (int i = 0; i < genericArray.length; i++) {
			tempArray[i] = genericArray[i];
		}

		genericArray = new Object[genericArray.length - 1];
		for (int i = 0; i < genericArray.length; i++) {
			if (tempArray[i] == item) {
				continue;
			} else {
				genericArray[i] = tempArray[i];
				
			}
		}
	}
	
	public void remove(int index) {
		
		Object[] tempArray = new Object[genericArray.length];
		for (int i = 0; i < genericArray.length; i++) {
			tempArray[i] = genericArray[i];
		}

		genericArray = new Object[genericArray.length-1];
		int value = 0;
		for (int i = 0; i < genericArray.length+1; i++) {
			if (i == index) {
				continue;
			} else {
				genericArray[value] = tempArray[i];
			}
			value++;
		}
	}
	
	public void list(){
		for (Object object : genericArray) {
			System.out.println(object);
			
		}
	}
	
	public boolean contains(T item) {
		boolean isExists = false;
		for (int i = 0; i < genericArray.length; i++) {
			if (genericArray[i] == item) {
				isExists = true;
			}
			
		}
		return isExists;
	}

}
