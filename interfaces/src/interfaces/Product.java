package interfaces;

public class Product {
	private int id;
	private String productName;
	private double unitPrice;
	private int quantity;
	
	public Product() {
		super();
	}

	public Product(int id, String productName, double unitPrice, int quantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	//Yönetim diyorki bazı operasyonlarımızı birden fazla yere aynı anda loglayalım.Aynı anda hem file logger,
	//hemde db logger ve ilerle de yep yeni loogerlar olan bir sistem yapmamız gerkeiyor.
	
	
	
	
	
	
	
	
	

}
