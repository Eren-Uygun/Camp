import java.util.Iterator;

public class Main {
	
	
	//Thread Nedir ->

	public static void main(String[] args) throws InterruptedException {

		
		/*Değişik bir yapı*/
		
        Runnable runnable = () -> System.out.println("Lambda ile newlenen bir runnable sınıfı -> 1");
        Runnable runnable2 = () -> System.out.println("Lambda ile newlenen bir runnable sınıfı -> 2");
        Runnable runnable3 = () -> System.out.println("Lambda ile newlenen bir runnable sınıfı -> 3");
        Runnable runnable4 = () -> System.out.println("Lambda ile newlenen bir runnable sınıfı -> 4");
        
        Runnable runnable5 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Lambda olmadan override edilerek gelen bir runnable sınıfı -> 5");
				
			}
		};

		
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);
        Thread thread4 = new Thread(runnable4);
        Thread thread5 = new Thread(runnable5);
       
        
        System.out.println("-----------start() metodu ----------------");
        
        thread1.start();
        thread2.start();

        thread3.start();
        thread4.start();
        thread5.start();
        
        
        System.out.println("---------- Run() metodu -----------------");
        thread1.run();
        thread2.run();
        thread3.run();
        thread4.run();
        thread5.run();
        
      
		
		
		
		
		
		
		KronometerThread kronometerThread1 = new KronometerThread("Thread1");
		KronometerThread kronometerThread2 = new KronometerThread("Thread2");
		KronometerThread kronometerThread3 = new KronometerThread("Thread3");
		
		kronometerThread1.start();
		kronometerThread2.start();
		kronometerThread2.join();
		//kronometerThread2.suspend();
		//Burada kronometrenin devam etmeme sebebi metod'a ait 
		//suspend  ve resume metotlarını kullandığımızda nerde kaldığını bilmediğinden tanımsız moda girip threadi bitirir. resume çalışır ancak iptal olur
		kronometerThread2.resume();
		kronometerThread3.start();
		
		
        
        
        
    
        
        

        
        
        
        
        
	
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

	}

}

