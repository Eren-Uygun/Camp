package interfaces;

public class Slf4jLoggerManager implements LoggerService {

	@Override
	public void log() {
		System.out.println("Slf4j ile loglandı.");
		
	}

}
