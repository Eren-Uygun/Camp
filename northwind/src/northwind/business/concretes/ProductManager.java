package northwind.business.concretes;

import java.util.Iterator;
import java.util.List;

import northwind.business.abstracts.ProductService;
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
		return this.productRepository.getAll();
	}

	@Override
	public void add(Product product) {
		
		if (isExists(product)) {
			System.out.println("Ekleme yapılamaz ürün sistemde mevcut");
		}else if(categoryCount(product.getCategoryId())>=5) {
			System.out.println("Aynı kategoriden en fazla 5 adet olabilir.");
		}else if(checkKnownProduct(product)) {
			System.out.println("3 No'lu kategorinin fiyatı en küçük 10 olmalı" +product.getUnitPrice());
		}else if(checkProductPrice(product)) {
			System.out.println("Ürün Fiyatı negatif olamaz : " +product.getUnitPrice());
		}
		else {
			this.productRepository.add(product);
		}
		
	
		
	}
	
	private boolean isExists(Product product) {
		boolean isExists = false;
		for (Product iterableProduct : productRepository.getAll()) {
			if (iterableProduct.getProductName().equals(product.getProductName())) {
				System.out.println("Bu veri mevcut");
				isExists = true;
				return isExists;			}
		}
		return isExists;
	}
	
	
	private int categoryCount(int categoryId) {
		int categoryCount = 0;
		for (Product categoryName : productRepository.getAll()) {
			if (categoryName.getCategoryId() == categoryId) {
				categoryCount++;
			}
			
			
		}
		return categoryCount;
		
	}
	
	private boolean checkKnownProduct(Product product) {
		
		if (product.getCategoryId()==3) {
			if (product.getUnitPrice()<10) {
			System.out.println("3.Kategoriye ait ürünlerin fiyatı en düşük 10 olmalıdır.");
				return true;
			}
		}
		
		return false;
	}
	
	private boolean checkProductPrice(Product product) {
		if (product.getUnitPrice()<0) {
			System.out.println("Ürün fiyatı pozitif olmalıdır.");
			return true;
		}
		return false;
		
	}
	

}
