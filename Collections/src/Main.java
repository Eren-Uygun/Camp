import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		//Arraylist'de çalışırken generic olarak bir veri tipi gerekir.ArrayList<String>
		//Koleksiyon yapıları dinamiktir.Biz ekledikce limiti artar.
		//Veri silindikçe limiti küçülür.
		//Tüm tipler kullanılabilir.
		
		//Arraylist bir array değil class'dır.
		ArrayList<String> list = new ArrayList<String>();
		
		//Bu listenin veri tipi Stringdir.String kabul eder;
		
		list.add("Ankara");
		list.add("İstanbul");
		
		//list.remove(0);
		//list.remove("İstanbul");
		
		//list.add(1, "İzmir"); Ekleyemez çünkü eleman yok 0 dan başlaması gerekir.
		list.add(0, "İzmir"); //Bunu yapar isek ankaranın indexi kayıcaktır.
		list.set(0, "Adana"); //Bu kod dizinin 0'ıncı indexinin değerini değiştirir. c# daki list[0]="Adana";
		
		
		
		//list.clear(); // Diziyi komple temizler.
		
		//list.clone(list) // diziyi klonlar.
		
		//list.contains(""); // bir verinin dizide olup olmadığını sorgular. boolean döner;
		
		//boolean result = list.contains("Adana");
		
		//System.out.println(result);
		
		//String ilkEleman = list.get(0); //Dizinin 0'ıncı yani ilk elemanını getirir.
		
		//Consumer action = lambda expression
		//Burdaki c takma isim. Diziyi c adıyla gezer.
		list.forEach((c)->System.out.println(c));
		
		//Her c için süslü parantez içi kod çalışır.
		list.forEach((c)->{
			System.out.println(c.toUpperCase());
			
		});
		
		//Koleksiyon yapılarının metotları incelenecek.
		//
		
		
		//Arraylist itere edilebilen yapılardır yani döngülerle dolaşılabilir.
		
		/*
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
			
		}
		*/
		/*
		for (String city : list) {
			
			System.out.println(city);
			
		}
		*/
		
		
		
		
		
		
		
		

	}

}
