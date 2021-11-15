package interfaces;

public class Customer {
	
	private int id;
	private String firstName;
	private String lastName;
	private String city;
	private String nationalIdentity;
	
	
	
	public Customer() {
		super();
	}

	public Customer(int id, String firstName, String lastName, String city, String nationalIdentity) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.nationalIdentity = nationalIdentity;
	}
	
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
	public String getNationalIdentity() {
		return nationalIdentity;
	}
	public void setNationalIdentity(String nationalIdentity) {
		this.nationalIdentity = nationalIdentity;
	}
	
	//Üzerinde matematiksel işlem yapılmayacaksa int yerine String ile yazılmalıdır.

}
