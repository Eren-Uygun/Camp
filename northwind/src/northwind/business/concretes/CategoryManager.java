package northwind.business.concretes;

import java.util.List;

import northwind.business.abstracts.CategoryService;
import northwind.core.utilities.results.DataResult;
import northwind.core.utilities.results.Result;
import northwind.dataAccess.abstracts.CategoryRepository;
import northwind.entities.concretes.Category;

public class CategoryManager implements CategoryService {
	
	private CategoryRepository categoryRepository;

	public CategoryManager(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Result add(Category category) {
	return	this.categoryRepository.add(category);
		
	}

	@Override
	public DataResult<List<Category>> getAll() {
		// TODO Auto-generated method stub
		return categoryRepository.getAll();
	}

}
