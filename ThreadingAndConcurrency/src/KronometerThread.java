
public class KronometerThread implements Runnable  {
	
	private Thread thread;
	private String threadName;
	
	
	
	public KronometerThread(String threadName) {
		this.threadName = threadName;
		System.out.println("Thread olu�turuluyor. "+threadName);
	}



	//Runnable interface -> 

	@Override
	public void run() {
		
		System.out.println("�al��t�r�l�yor : "+threadName);
		
		try {
			for (int i = 0; i < 10;i++) {
				System.out.println(threadName+" : "+i);
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {	
			
			System.out.println("Kesildi : "+threadName);
		}
		
		
		System.out.println("Thread bitti "+threadName);
		

	}
	
	public void start() { 
		System.out.println("Thread nesnesi olu�uyor : "+threadName);
		
		if (thread == null) {
			thread = new Thread(this,threadName);
		}
		thread.start();
	}
	
	public void suspend() {
		System.out.println("Thread nesnesi duraklat�l�yor : "+ threadName);
		if (thread.isAlive()) {
			thread.suspend();
		}
	}
	
	public void resume() {
		System.out.println("Thread nesnesi devam ediyor : "+threadName);
		if (thread.isInterrupted()) {
			thread.start();
		}
	}
	public void join() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
