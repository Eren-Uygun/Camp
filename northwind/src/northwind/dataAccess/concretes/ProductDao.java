package northwind.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import northwind.core.utilities.results.DataResult;
import northwind.core.utilities.results.Result;
import northwind.core.utilities.results.SuccessDataResult;
import northwind.core.utilities.results.SuccessResult;
import northwind.dataAccess.abstracts.ProductRepository;
import northwind.entities.concretes.Product;

public class ProductDao implements ProductRepository {
	
	//Dao data access object 
	
	
	List<Product> products;
	

	public ProductDao() {
		this.products = new ArrayList<Product>();
	}

	@Override
	public Result add(Product product) {
		products.add(product);
		return new SuccessResult("Ürün eklendi");
		
	}

	@Override
	public Result update(Product product) {
		products.set(product.getId(), product);
		return new SuccessResult("Ürün güncellendi.");
		
	}

	@Override
	public Result delete(Product product) {
		products.remove(product);
		return new SuccessResult("Ürün silindi.");
		
	}

	@Override
	public DataResult<Product> getById(int id) {
		
		return new SuccessDataResult<Product>(this.products.get(id),"Ürün getirildi.");
	}

	@Override
	public DataResult<List<Product>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(products,"Ürünler getirildi.");
	}
	


}
