package classes;

public class Employee {
	
	public Employee() {
		super();
	}
	
	public Employee(int id,String firstName,String lastName,String city) {
		//This(bu class) parametresi bu class'ın içerisindeki özelliklere erişir.Yani bu class'ın id si constructorda gönderilen parametresini alır.
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}
	//Class nedir? => Davranışları ve özellikleri olan yapılardır.
	//Class'lar 2 ye ayrılır. 1.Değer veya referans tutucu classlar ve 2.Metot tutan classlar
	//Classlar özellik tutar.örn Fiyat,Ad,Kategori
	
	//Hepimiz insan sınıfının bir örneğiyiz.(instance)
	int id; //Id employee'yi ayıran değerdir.Birden fazla aynı kişi var ise ayrışmayı sağlar.
	String firstName;
	String lastName;
	String city;
	
	//Yapılmayacak hareketler Single Responsibilty ilkesine ters
	/*
	public void add() {
		
	}
	*/
	
	

}
