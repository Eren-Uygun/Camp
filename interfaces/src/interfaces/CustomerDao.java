package interfaces;

import java.util.ArrayList;

//Data Access Object
//Data Access bölümünde Veri tabanıyla yapılacak işlerin implementasyonu ve imzaları tutulur.
//Veri tabanıyla direkt işlem yapılan yer dataAccess'dir.
public interface CustomerDao {
	
	void save(Customer customer);
	ArrayList<Customer> list();
	
}
//JDBC => Java database connection
//Orm => Object Relational Mapping -> veri tabanı nesnelerini classlaştıran yapıdır.
//Örnek Orm olarak -> Hibernate 
//Hibernate - Kullanan JPA -> Java Persistance Language

//Yukarıda yazılanların hepsi sürdürülebilirlik ile ilgilidir.
