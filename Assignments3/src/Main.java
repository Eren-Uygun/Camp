import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
	        MyHashMap<Object, Object> capitalCities = new MyHashMap<Object,Object>();
	        HashMap<Object, Object> hashes = new HashMap<Object,Object>();
	        
	        capitalCities.put("England", "London");
	        //capitalCities.put("England", "Manchester");
	        capitalCities.put("Germany", "Berlin");
	        capitalCities.put("Norway", "Oslo");
	        capitalCities.put("USA", "Washington DC");
	        capitalCities.put("Beer","Tuborg");
	        
	       // capitalCities.remove("USA");
	       // capitalCities.remove("Beer", "Tuborg");
	       // System.out.println(capitalCities.get("England"));
	        //capitalCities.clear();
	        capitalCities.list();
	        
	      //  hashes.replace(args, capitalCities, hashes);
	        
	        
	        

	      

	}

}
