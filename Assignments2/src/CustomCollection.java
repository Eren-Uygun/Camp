
public class CustomCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyCollection myList = new MyCollection();	
		
		myList.add("Test");
		myList.add("Test1");
		myList.add("Test2");
		myList.add("Test3");
		
		
		
		
		

		myList.remove(2);
		myList.remove(1);
		myList.remove("Test3");
		
		
		
		myList.toList(); //Boş olduğu için null pointer fırlatmaya ayarlandı.
		
		boolean result = myList.contains("test");
		System.out.println(result);
		System.out.println(myList.contains("Test"));
		
		System.out.println(myList.get(0) + " ilk eleman bu");
		
		System.out.println(myList.length());
		
	

	}
	


}

