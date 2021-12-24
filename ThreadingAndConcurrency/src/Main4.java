
public class Main4 {

	public static void main(String[] args) {
		Runnable runnable = () ->{
			while (true) {
				sleep(1000);
				System.out.println("Running");
				
			}
		};
		
		
		//Bir thread�i daemon olarak tan�mlad���m�z zaman uygulaman�n 
		//sonlanmas� i�in engel olu�turmayan bir thread olu�turdu�umuzu ifade ederiz.
		//Bu thread�imiz �al��an ba�ka hi�bir thread kalmad���nda i�ini hen�z tamamlamam�� olsa dahi uygulamam�z sonlanacakt�r.
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
		sleep(3100);

	}
	
	
	
	public static void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
