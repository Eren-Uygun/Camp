
public class Main4 {

	public static void main(String[] args) {
		Runnable runnable = () ->{
			while (true) {
				sleep(1000);
				System.out.println("Running");
				
			}
		};
		
		
		//Bir thread’i daemon olarak tanýmladýðýmýz zaman uygulamanýn 
		//sonlanmasý için engel oluþturmayan bir thread oluþturduðumuzu ifade ederiz.
		//Bu thread’imiz çalýþan baþka hiçbir thread kalmadýðýnda iþini henüz tamamlamamýþ olsa dahi uygulamamýz sonlanacaktýr.
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
