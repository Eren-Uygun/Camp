package interfaces;

public class DbLoggerManager implements LoggerService {

	@Override
	public void log() {
		System.out.println("Db'ye kaydedildi.");
		
	}

}
