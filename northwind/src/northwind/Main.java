package northwind;

import java.util.List;

import northwind.business.abstracts.CategoryService;
import northwind.business.abstracts.EmployeeService;
import northwind.business.abstracts.ProductService;
import northwind.business.concretes.CategoryManager;
import northwind.business.concretes.EmployeeManager;
import northwind.business.concretes.ProductManager;
import northwind.dataAccess.concretes.CategoryDao;
import northwind.dataAccess.concretes.EmployeeDao;
import northwind.dataAccess.concretes.ProductDao;
import northwind.entities.concretes.Category;
import northwind.entities.concretes.Employee;
import northwind.entities.concretes.Product;

public class Main {

	public static void main(String[] args) {
		
		//Klasik katmanlı mimaride Db -> DataAccess -> Business -> UI
		
		//DataAccess => Veri tabanı işlemlerini yaptığımız yer.
		
		//Business => İş kuralları ve validasyon yaptığımız yerdir.
		
		
		ProductService productService = new ProductManager(new ProductDao());
		productService.add(new Product(1,1,"Elma",10));
		productService.add(new Product(2,1,"Armut",20));
		productService.add(new Product(3,1,"Karpuz",30));
		productService.add(new Product(4,1,"Üzüm",40));
		productService.add(new Product(5,1,"İncir",50));
		productService.add(new Product(6,2,"Mandalina",50));
		productService.add(new Product(7,3,"Portakal",8));
		productService.add(new Product(7,3,"Nar",-50));
		productService.add(new Product(8,1,"Elma",40));
		
		
		for (Product product : productService.getAll()) {
			System.out.println(product.getProductName() +" "+ product.getUnitPrice());
		}
		
		/*
		CategoryService categoryService = new CategoryManager(new CategoryDao());
		categoryService.add(new Category(1,"Meyve"));
		categoryService.add(new Category(2,"Sebze"));
		categoryService.add(new Category(3,"Bakliyat"));
		categoryService.add(new Category(4,"Ekmek"));
		
		for (Category category : categoryService.getAll()) {
			System.out.println(category.getCategoryName());
		}
		
		
		EmployeeService employeeService = new EmployeeManager(new EmployeeDao());
		employeeService.add(new Employee(1,"Test","Employee","Toronto"));
		employeeService.add(new Employee(2,"Test1","Employee1","Newyork"));
		employeeService.add(new Employee(3,"Test2","Employee2","Tokyo"));
		employeeService.add(new Employee(4,"Test3","Employee3","Ankara"));
		employeeService.add(new Employee(5,"Test4","Employee4","Herat"));
		
		for (Employee employee : employeeService.getAll()) {
			System.out.println(employee.getId()+" "+ employee.getFirstName() + " " + employee.getLastName() + " "+ employee.getCity());
		}
		*/
		

	}

}
