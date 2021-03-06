package northwind.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import northwind.core.utilities.results.DataResult;
import northwind.core.utilities.results.Result;
import northwind.core.utilities.results.SuccessDataResult;
import northwind.core.utilities.results.SuccessResult;
import northwind.dataAccess.abstracts.CategoryRepository;
import northwind.entities.concretes.Category;

public class CategoryDao implements CategoryRepository {
	
	List<Category> categories;
	
	public CategoryDao() {
		categories = new ArrayList<Category>();
	}

	@Override
	public Result add(Category category) {
		this.categories.add(category);
		return new SuccessResult("Kategori eklendi.");
		
	}

	@Override
	public Result update(Category entity) {
		// TODO Auto-generated method stub
		this.categories.set(entity.getId(), entity);
		return new SuccessResult("Kategori gŁncellendi.");
		
	}

	@Override
	public Result delete(Category entity) {
		// TODO Auto-generated method stub
		this.categories.remove(entity);
		return new SuccessResult("Kategori Silindi.");
		
	}

	@Override
	public DataResult<Category> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Category>(categories.get(id));
	}

	@Override
	public DataResult<List<Category>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Category>>(categories,"Kategoriler getirildi.");
	}

}
