package northwind.dataAccess.abstracts;

import java.util.ArrayList;
import java.util.List;

import northwind.entities.concretes.Product;

public interface ProductRepository extends DaoRepository<Product> {
	
	//Repository Veri tabanına erişim için yaptığımız çalışmaları koyduğumuz sınıfdır.
	//List arraylist'in base sınıfıdır.
	
	/* Generic yapı koyduk daoRepository burdakileri karşılıyor. Dao'da verdiğimiz product yetiyor.
	void add(Product product);
	void update(Product product);
	void delete(Product product);
	Product getById(int id);
	List<Product> getAll();
	*/
	
	//..burayı kullanmak zorundayız çünkü buraya özel metotlar yazılması gerekebilir.
	//Bu ayın en popüler ürünü
	

	//Bu prensibin adı solidde interface segregation principle
}
