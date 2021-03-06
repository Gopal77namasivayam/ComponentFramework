package reports;

import org.testng.Reporter;

public class Report {
	
	/**
	 * writes the mesage to report
	 * 
	 * @author Pradeep Sundaram
	 * @param logMessage
	 */
	public static void log1(String logMessage){
		Reporter.log(logMessage+"<BR>");
	}
	
	/**
	 * writes the message to console
	 * 
	 *  @author Pradeep Sundaram
	 * @param logMessage
	 * @param toStandardOutput
	 */
	public static void log2(String logMessage, boolean toStandardOutput){
		Reporter.log(logMessage+"<BR>",toStandardOutput);
	}
	

	/**
	 * writes the mesage to report
	 * 
	 * @author Pradeep Sundaram
	 * @param logMessage
	 */
	public static void log(String logMessage){
		LogHelper.Logger.log(logMessage);
		
	}
	
	/**
	 * writes the message to console
	 * 
	 *  @author Pradeep Sundaram
	 * @param logMessage
	 * @param toStandardOutput
	 */
	public static void log(String logMessage, boolean toStandardOutput){
		LogHelper.Logger.log(logMessage,toStandardOutput);
	}
	
}
