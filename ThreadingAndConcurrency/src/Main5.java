
public class Main5 {

	public static void main(String[] args) {
		Runnable runnable = () ->{
			for (int i = 0; i < 5; i++) {
				sleep(2000);
				System.out.println("Running");	
			}
		};
		
		
		
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
		
		
		try {
			//Thread de join methodu, bir thread iþlemini bitirmeden diðer bir thread çalýþmasý engellenir. 
			//Eþzamanlý birden fazla thread in iþ yapmasý önlenmiþ olur.
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
