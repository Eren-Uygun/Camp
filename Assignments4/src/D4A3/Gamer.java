package D4A3;

public class Gamer {
	
	private int id;
	private String firstName;
	private String lastName;
	private String nationalIdentityNumber;
	
	public Gamer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Gamer(int id, String firstName, String lastName, String nationalIdentityNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalIdentityNumber = nationalIdentityNumber;
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
	public String getNationalIdentityNumber() {
		return nationalIdentityNumber;
	}
	public void setNationalIdentityNumber(String nationalIdentityNumber) {
		this.nationalIdentityNumber = nationalIdentityNumber;
	}
	
	
	
	
	
	

}
