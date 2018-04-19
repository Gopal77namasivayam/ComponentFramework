package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class FailureHandler implements WebDriverEventListener {
	private static String ScreenShotInitial="<a href=\"./screenshot/";
	private static String ScreenShotEnd=".png\"  target=\"_blank\"> SCREEN SHOT </a> \n";
	private static Integer failureCounter=1;
	public void onException(Throwable exception, WebDriver driver) {
		/*try {
			System.out.println("inside failure handler on exception method");
			File directory = new File (".");
			String path=directory.getCanonicalPath()+"\\test-output\\screenshot\\";
			File f=new File(path+failureCounter+".png");
			File scrFile = ((TakesScreenshot)WebPage.driver).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(scrFile, f);
			Report.log(ScreenShotInitial+"failure screen shot"+ScreenShotEnd);
			failureCounter++;
		} catch (IOException e) 
		{
			e.printStackTrace();
		}*/
	}

	
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	} 

}
