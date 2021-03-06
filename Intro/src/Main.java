import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Merhaba Etiya Akademi");
		//sysout control + space tuşuna basarsak ekrana yazdırma komutu ortaya çıkar.
		//Kodların sonunda ; olmak zorundadır.
		//Kelimelerin baş harfi büyük olursa CapitalCase
		//Kelimenin ilk harfi küçük kalan kelimelerin baş harfi büyükse camelCase
		
		//Uygulama geliştirmeleri iki gruba ayırabiliriz.
		//Back-end , Front-end
		
		//String metinsel Veri tipimiz. String javada S si büyük yazılır. Değer çift tırnak içinde yazılır.
		//Değer tekli tırnak içinde yazılır ise bu char olur.

		String news1 = "Yeni kredi geldi.";
		
		//integer(int) veri tipi sayısal bir veri tipidir.
		//Virgüllü sayıları yani ondalık sayıları tutmaz.
		
		int age = 24;
		
		
		//Ondalıklı sayılar için double - float kullanılabilir.
		double dolarYesterday = 9.55;
		double dolarToday = 9.65;
		
		//boolean mantıksal veri tipidir. True veya false döner. Bu 1 ve ya 0 a eşittir.
		//Karşılaştırma yapmak için genelde boolean kullanılır.
		
		boolean isIncreased = false;
		
		// <,>,>= , <= , !=  gibi operatörlerimiz vardır.
		//Buradaki mantık hatası büyük değilse tüm şartlarda else bloğunu çalıştırır. Ancak else if ekleyerek sorunu çözmüş olduk.
		
		if(dolarToday>dolarYesterday) {
		
			System.out.println("up.svg");
		}else if(dolarToday<dolarYesterday) {
			
			System.out.println("down.svg");
		}
		else {

			System.out.println("equal.svg");
		}
		
		
		//Karakter veri tipimiz Char
		char firstLetter = 'A';
		
		//Stringler aslında birer char array'dir.
		
		//Arrayler aynı tipdeki verileri bir arada tutabilen yapılardır.
		
		String[] credits = {"Emekli Kredisi","Çalışan Kredisi","Genel Ihtiyaç Kredisi"};
		
		//Döngüler aynı işlemler tekrar tekrar yapabilen programlardır.
		
		//For'un kaç veri için döneceğini dizilerin length(uzunluğu) ile düzgün hale getirebiliriz.
		for(int i=0;i<credits.length;i++) {
			//credits[i] bu şekilde kredilerin elemanlarına erişebilir. Index 0'dan başlar.
			System.out.println(credits[i]);
		}
		
		//Foreach for ile benzerdir ancak dolaştığı her elamana credit adı verir.
		for (String credit : credits) {
			System.out.println(credit);
		}
		
		//While şart sağlandığı sürece dönmeye devam eden döngüdür.Diğer döngüler ile benzerdir.
		//While döngüsünde dikkat edilmesi gereken şartı sağlayacak değerin artışının döngü içinde yapılması gerekir.
		//Yoksa sonsuz döngüye girer.
		int index = 0;
		while(index<credits.length) {
			System.out.println(credits[index]);
			index++; //index+=1 ve index = index+1 le aynıdır.
			
		}
		
		//Do while döngüsü günümüzde pek kullanılmayan bi döngü çeşididir.
		//Şart sağlama bile verilen ilk işlemi yapar.
		
		int index2=0;
		//int index2=10;
		do {
			System.out.println(credits[index2]);
			index2++;
		} while (index2<credits.length);
		
		//break ve continue
		//break =>
		
		for (int i = 1; i <= 10; i++) {
			if(i==5) {
				break;
			}
			System.out.println(i);
		}
		

		//continue =>
		for (int i = 1; i <= 10; i++) {
			if(i==5) {
				continue;
			}
			System.out.println(i);
		}
		
		
		//Değer ve referans tipler detaylıca araştırılacak.
		
		int sayi1=20;
		int sayi2=30;
		sayi1 = sayi2;
		sayi2=40;
		System.out.println(sayi1);
		
		//30 olmasının sebebi değer tiplerin sadece değer tutmasıdır.
		
		
		int[] sayilar1 = {1,2,3,4,5,6};
		int[] sayilar2 = {10,20,30,40,50,60};
		sayilar1=sayilar2;
		sayilar1[0] = 100;
		System.out.println(sayilar2[0]);
		
		//100 olmasının sebebi arraylerin değer değil adres tutmasıdır.
		// sayilar1=sayilar2 dediğimizde sayilar1 artık sayılar2 nin adresini tutar.Atama yaptığımızda adresler değiştiği için doğal olarak sayilar1[10] olur.
		//Sayilar1[0] da bir değer atadığımızda adresler aynı olduğu için sayilar[2] de değişir.
		//Sayısal veri tipleri : değer tipdir.int,float,boolean,enum,double,decimal
		//DEğer tiplerde olay değerden yürütülür herşey stack üzerinde gerçekleşir.
		
		//Array referans tipdir.Adres tutar.Adresin gösterdiği değer heap da tutulur.
		
		//REferans tiplerde atama referans numarası üzerinden yapılır.
		//sayilar1=sayilar2; yaptığımızda artık sayılar1 sayılar2 nin adresini tutar.
		
		//String referans tipdir. ancak değer tip gibi davranır.
		
		
		

		doSomething(sayi1);
		System.out.println(sayi1);
		
		doSomething(sayilar1);
		System.out.println(sayilar2[0]);
		
		String[] cities = {"Ankara","İstanbul"};
		
		String[] result = addCity(cities, "İzmir");
		
		for (String city : result) {
			System.out.println(city);
		}
		
		
		
		 
		
	
	}
	


	//Burda değerin 50 olarak dönmemesi sebebi voidlerin dönüşü yoktur.
	//parametrede verilen sayi1'in değeri maindeki sayı1 le ilişkili değildir.


	//Pass by value
	public static void doSomething(int sayi1)
	{
		sayi1=50;
		
	}
	
	//Adresin gösterdiği yere değeri atıyoruz.
	//Pass by referance
	public static void doSomething(int[] sayilar1)
	{
		sayilar1[0] = 200;
		
	}
	
	
	
	
	//Elimizde String Array var , bunu ekleyen fonksiyon
	/*
	bu kodda referans kayboluyor.
	public static void addCity(String[] cities,String cityName) {
		
		//String[] newArray = new String[cities.length+1];
		String[] newArray =  new String[cities.length+1];
		
		//cities = new String[cities.length+1];//102
		
		for (int i = 0; i <cities.length; i++) {		

				newArray[i]=cities[i];	
			}
		
		newArray[newArray.length-1] = cityName;	
	}
	*/
	public static String[] addCity(String[] cities,String cityName) {
		//String[] newArray = new String[cities.length+1];
				String[] newArray =  new String[cities.length+1];
				
				//cities = new String[cities.length+1];//102
				
				for (int i = 0; i <cities.length; i++) {		

						newArray[i]=cities[i];	
					}
				
				newArray[newArray.length-1] = cityName;	
				return newArray;
	}
	
	//Değişiklikleri bildirmek için bir dönüş ifadesi kullanıyoruz.
	//Bu sayede adresler kaybolmamış oluyor.
	
	
	//Collections arraylerin geliştirilmiş versiyonudur.
	
	//Günümüzde array kullanımı azalmıştır.Array'yerine daha çok colletion yapıları kullanılmaktadır.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
