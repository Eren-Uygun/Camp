package classes;

import java.util.ArrayList;

public class Main {

	
	public static void main(String[] args) {
		//Kaynak seviyelendirme => Bildiğin know how ları takımla paylaşıp onların da bilmesini sağlamak.
		
		//Class'lar başka yerde kullanılacağı zaman newlenir.
		//Stack ve heap'e göre class oluşurken stackde adresi tanımlanır.New lendiği anda Heap'de o adrese ait veriler tanımlanır.
		Employee employee = new Employee();
		
		//Tanımlamadan(newlemeden) employee ye özellik tanımlarsak null exception hatası alır yani heap'da odeğeri gösteren bir referans yok demektir.
		
		employee.setId(1);
		employee.setFirstName("Eren");
		employee.setLastName("Uyğun");
		employee.setCity("İstanbul");
		
//	System.out.println(employee.getFullName());
		
		
		//Constructor class'ı newlediğinizde ilk çalısan yapıcı metotdur.
		Employee employee2 = new Employee(2,"Burak","Hamzalı","İstanbul");
		
	//	System.out.println(employee2.getCity());
		
		
		//Generic type = Array liste ne verirsen onla çalışır.
		ArrayList<Employee> employees = new ArrayList<Employee>();
	
		
		
		MyList<String>  myList = new MyList<String>();		
		myList.add("Ankara");
		myList.add("İstanbul");
		myList.add("İzmir");
		myList.add("Adana");
		myList.add("Sinop");
		
		myList.remove("Sinop");
		myList.remove(1);
		
		myList.list();
		
		//İpucu bütün veri tipleri objedir.
		
		
	}

}
