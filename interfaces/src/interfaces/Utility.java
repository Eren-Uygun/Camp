package interfaces;

public class Utility {
	
	public static void RunLogger(LoggerService[] loggerServices) {
		for (LoggerService loggerService : loggerServices) {
			loggerService.log();
		}
		
	}

}
