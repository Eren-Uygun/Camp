package northwind.core.utilities.results;

public class DataResult<T> extends Result {
//Gelecek VEri tipini bilmediğimiz için T
	
	
	
	private T data;
	
	public DataResult(T data,boolean success) {
		super(success);
		this.data = data;
		
	}
	
	public DataResult(T data,boolean success,String message) {
		//Extend ettiğimiz class'ın içinde bunları yapmıştık Super'de bu verileri yollarsak sorunsuz sekilde çalışacaktır.
		super(success, message);
		this.data = data;
	}
	

	//Set işlemlerini constructor'dan yaptığımızı varsaydığımız için sadece getter metodu ekliyoruz.
	public T getData() {
		return data;
	}
	
}
