package northwind.business.concretes;


import java.util.List;


import northwind.business.abstracts.ProductService;
import northwind.core.utilities.results.DataResult;
import northwind.core.utilities.results.ErrorResult;
import northwind.core.utilities.results.Result;
import northwind.core.utilities.results.SuccessDataResult;
import northwind.core.utilities.results.SuccessResult;
import northwind.dataAccess.abstracts.ProductRepository;
import northwind.entities.concretes.Product;

public class ProductManager implements ProductService {
	
	//Katmanlar birbirleriyle soyutları üzerinden haberleşirler.
	
	private ProductRepository productRepository;
	
	
	public ProductManager(ProductRepository productRepository) {
		super();//Base anasınıfın constructorunu calıstır.
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return this.productRepository.getAll().getData();
	}
	
	@Override
	public DataResult<List<Product>> getDtAll() {
		return new SuccessDataResult<List<Product>>(this.productRepository.getAll().getData(), "Veriler getirildi.");
		
	}
	

	@Override
	public Result add(Product product) {
		
		if (checkIfProductNameExist(product)) {
			//System.out.println("Ekleme yapılamaz ürün sistemde mevcut");
			return new ErrorResult("Ekleme İşlemi başarısız");
		}else if(checkCategoryCountOfProduct(product.getCategoryId())>=5) {
			//System.out.println("Aynı kategoriden en fazla 5 adet olabilir.");
			return new ErrorResult("Ekleme İşlemi başarısız");
		}else if(checkIfUnitPriceIsBelowTen(product)) {
			//System.out.println("3 No'lu kategorinin fiyatı en küçük 10 olmalı" +product.getUnitPrice());
			return new ErrorResult("Ekleme İşlemi başarısız");
		}else if(checkIfUnitPriceIsMinus(product)) {
			//System.out.println("Ürün Fiyatı negatif olamaz : " +product.getUnitPrice());
			return new ErrorResult("Ekleme İşlemi başarısız");
		}
		else {
			this.productRepository.add(product);
			return new SuccessResult("Ekleme İşlemi başarılı");
		}
		
		/*@Override
	public void add(Product product) {
		
		if (checkIfProductNameExist(product)) {
			System.out.println("Ekleme yapılamaz ürün sistemde mevcut");
		}else if(checkCategoryCountOfProduct(product.getCategoryId())>=5) {
			System.out.println("Aynı kategoriden en fazla 5 adet olabilir.");
		}else if(checkIfUnitPriceIsBelowTen(product)) {
			System.out.println("3 No'lu kategorinin fiyatı en küçük 10 olmalı" +product.getUnitPrice());
		}else if(checkIfUnitPriceIsMinus(product)) {
			System.out.println("Ürün Fiyatı negatif olamaz : " +product.getUnitPrice());
		}
		else {
			this.productRepository.add(product);
		}
		 * */
		
	
		
	}
	//Servisler katmanlar vs newlenemez.
	//Ama entity ve domain tarzı yapılar newlenebilir;
	
	//Bu metoda String Name'de geçebiliriz.
	private boolean checkIfProductNameExist(Product product) {
		boolean isExists = false;
		for (Product iterableProduct : productRepository.getAll().getData()) {
			if (iterableProduct.getProductName().equals(product.getProductName())) {
				System.out.println("Bu veri mevcut");
				isExists = true;
				return isExists;			}
		}
		return isExists;
	}
	
	
	private Result checkIfProductNameExistResult(String productName) {
		
		for (Product iterableProduct : productRepository.getAll().getData()) {
			if (iterableProduct.getProductName().equals(productName)) {
				//return new Result(false, "Ürün ismi tekrar edemez.");
				return new ErrorResult("Ürün ismi tekrar edemez.");	}
		}
		//return new Result(true);
		return new SuccessResult();
	}
	
	
	
	
	private int checkCategoryCountOfProduct(int categoryId) {
		int categoryCount = 0;
		for (Product categoryName : productRepository.getAll().getData()) {
			if (categoryName.getCategoryId() == categoryId) {
				categoryCount++;
			}
			
			
		}
		return categoryCount;
		
	}
	
	private boolean checkIfUnitPriceIsBelowTen(Product product) {
		
		if (product.getCategoryId()==3) {
			if (product.getUnitPrice()<10) {
			System.out.println("3.Kategoriye ait ürünlerin fiyatı en düşük 10 olmalıdır.");
				return true;
			}
		}
		
		return false;
	}
	
	private boolean checkIfUnitPriceIsMinus(Product product) {
		if (product.getUnitPrice()<0) {
			System.out.println("Ürün fiyatı pozitif olmalıdır.");
			return true;
		}
		return false;
		
	}



}
