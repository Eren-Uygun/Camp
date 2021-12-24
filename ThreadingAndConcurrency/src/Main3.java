
public class Main3 {
	
	//8
	
	public static class StoppableRunnable implements Runnable {
		
		private boolean isStopRequestCalled = false;
		
		//synchronized => Ayný anda çalýþan birden fazla thread'in veya iþlemin sýralý ve iletiþim halinde çalýþmasýný saðlar.
		
		public synchronized void requestStop() {
			this.isStopRequestCalled = true;
		}
		
		public synchronized boolean isStopRequested() {
			return this.isStopRequestCalled;
		}
		
		private void Sleep(long milis) {
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		@Override
		public void run() {
			
			System.out.println("StoppableRunnable Running");
		
			while (!isStopRequested()) {
				Sleep(1000);
				System.out.println("...");
			}
			System.out.println("StoppableRunnable stopped");
			
			
		}
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		StoppableRunnable stoppableRunnable = new StoppableRunnable();
		Thread thread = new Thread(stoppableRunnable,"The Thread");
		thread.start();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("requesting stop");
		Thread.sleep(5000);
		stoppableRunnable.requestStop();
		System.out.print("Stop requested");
		
	
	}
	

}
