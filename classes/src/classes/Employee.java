package classes;

public class Employee {
	//Class nedir? => Davranışları ve özellikleri olan yapılardır.
		//Class'lar 2 ye ayrılır. 1.Değer veya referans tutucu classlar ve 2.Metot tutan classlar
		//Classlar özellik tutar.örn Fiyat,Ad,Kategori

	
	//Bu alanlar aslında field
	//Data bu alanlarda bulunur, getter setter ile bunları yönetiriz.
	private int id; //Id employee'yi ayıran değerdir.Birden fazla aynı kişi var ise ayrışmayı sağlar.
	private String firstName;
	private String lastName;
	private String city;
	//private String fullName;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFullName() {
		return this.firstName + " "+this.lastName;
	}


	//Coding convention
	public Employee() {
		super();
	}

	public Employee(int id, String firstName, String lastName, String city) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}
	
	
	
	
	
	//Access Modifiers
	//Private = sadece kendi class'ında erişim sağlar.
	
	/*
	public Employee(int id,String firstName,String lastName,String city) {
		//This(bu class) parametresi bu class'ın içerisindeki özelliklere erişir.Yani bu class'ın id si constructorda gönderilen parametresini alır.
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}
	*/
	
	//Encapsulation kapsülleme demektir.Kapsüle koyup ne yapacağımıza karar veririz.Böylece dışarıdan müdaheleleri önlemiş oluruz.
	//Java'da kapsüllemeyi getter ve setter ile yaparız.
	

	
	
	
	
	
	
	
	
	
	//Hepimiz insan sınıfının bir örneğiyiz.(instance)

	
	//Yapılmayacak hareketler Single Responsibilty ilkesine ters
	/*
	public void add() {
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
