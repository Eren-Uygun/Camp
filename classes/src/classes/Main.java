package classes;

public class Main {

	
	public static void main(String[] args) {
		
		//Class'lar başka yerde kullanılacağı zaman newlenir.
		//Stack ve heap'e göre class oluşurken stackde adresi tanımlanır.New lendiği anda Heap'de o adrese ait veriler tanımlanır.
		Employee employee = new Employee();
		
		//Tanımlamadan(newlemeden) employee ye özellik tanımlarsak null exception hatası alır yani heap'da odeğeri gösteren bir referans yok demektir.
		
		employee.id=1;
		employee.firstName="Eren";
		employee.lastName = "Uyğun";
		employee.city = "İstanbul";
		
		
		//Constructor class'ı newlediğinizde ilk çalısan yapıcı metotdur.
		Employee employee2 = new Employee(2,"Burak","Hamzalı","İstanbul");
		
		
		
	}

}
