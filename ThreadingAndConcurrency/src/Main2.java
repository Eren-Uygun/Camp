
public class Main2 {
	
	public static class CustomRunnable implements Runnable{

		//Runnable interface Thread tarafýndan çalýþacak sýnýflara implement edilir.
		//Çalýþtýðý zaman override edilen run metodu çalýþýr.
		
		@Override
		public void run() {
			
			System.out.println("Class CustomRunnables Is Working");
			System.out.println("Class CustomRunnables Is Finished");
			
			
		}
		
	}
	

	public static void main(String[] args) {
		
		//Thread çaðýrma Yöntemleri
		
		//1
		Thread thread = new Thread();
		thread.run();
		
		//2
		CustomRunnable customRunnable = new CustomRunnable();
		customRunnable.run();
		
		//3 
		Thread threadNewClass = new Thread(new CustomRunnable());
		threadNewClass.run();
		
		
		//4 interface çaðýrmak
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Interface CustomRunnable Is Working");
				System.out.println("Interface CustomRunnable Is Finished");
				
			}
		};
		
		Thread interfaceThread = new Thread(runnable);
		interfaceThread.run();
		
		
		//5
		Runnable runnable2 = () ->{
			System.out.println("Lambda CustomRunnable Is Working");
			System.out.println("Lambda CustomRunnable Is Finished");
		};
		
		Thread lambdaThread = new Thread(runnable2);
		lambdaThread.start();
		
		//6 Thread with name
		Runnable runnable3 = () ->{
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " 6 is running");
			
		};
		
		Thread thread2 = new Thread(runnable3,"The Thread");
		thread2.start();
		
		//7 Thread with sleep
		
		Runnable runnable4 = () ->{
			String threadName = Thread.currentThread().getName();
			try {
				System.out.println(threadName + "  7 is running");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(threadName + " 7 is finished");
			
			
		};
		
		Thread thread3 = new Thread(runnable4,"The Thread");
		thread3.start();
		
		
		
		
	}
}
