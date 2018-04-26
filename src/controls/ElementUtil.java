package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Events;
import exception.CFException;

public class ElementUtil {

	static WebDriver driver;
	static Events events;
	public ElementUtil(WebDriver webDriver) {
		driver = webDriver;
		events=new Events(driver);
	}

	public static WebElement findElement(By by) {
		return driver.findElement(by);
	}

	public static WebElement findElementByID(String elementID) {
		return driver.findElement(By.id(elementID));
	}
	
	public static WebElement findElementByName(String elementID) {
		return driver.findElement(By.name(elementID));
	}
	
	public static Select findSelect(By by) {
		return new Select(driver.findElement(by));
	}
	
	public static WebElement findElementByLinkText(String elementLinkText) {
		String[] elementID = elementLinkText.split("=");
		return driver.findElement(By.linkText(elementID[1]));
	}

	public static By byXpath(String elementXpath) {
		return By.xpath(elementXpath);
	}

	public static By byID(String elementID) {
		String[] eleID = elementID.split("=");
		System.out.println("element id is "+eleID[1]);
		return By.id(eleID[1]);

	}

	public static By byIDOrName(String elementID) {
		By by=null;
		try{
			by=By.id(elementID);
			driver.findElement(by);	
		}
		catch(NoSuchElementException e){
			by=By.name(elementID);	
		}
		return by;
	}
	
	public static By byName(String elementName) {
		String[] elementID = elementName.split("=");
		return By.name(elementID[1]);
	}
	
	public static By byNameNew(String elementName) {
		return By.name(elementName);
	}

	public static By byCss(String elementCss) {
		String[] elementID = elementCss.split("=");
		return By.cssSelector(elementID[1]);
	}

	public static By byLinkText(String elementLinkText) {
		String[] elementID = elementLinkText.split("=");
		return By.linkText(elementID[1]);
	}
	
	/**
	 * This method will click the link with its ID
	 * 
	 * @author Pradeep Sundaram
	 * @param elementLinkText
	 * @return
	 */
	public static By byLink(String elementLinkText) {
		return By.linkText(elementLinkText);
	}
	
	public static By selectByXpath(String elementXpath) {
		return By.xpath(elementXpath);
	}

	public static By selectByID(String elementID) {
		String[] eleID = elementID.split("=");
		return By.id(eleID[1]);

	}

	public static By selectByName(String elementName) {
		String[] elementID = elementName.split("=");
		return By.name(elementID[1]);
	}

	public static By selectByCss(String elementCss) {
		String[] elementID = elementCss.split("=");
		return By.cssSelector(elementID[1]);
	}
	
	public static void click(WebElement webElement) throws CFException {
		 events.click(webElement);
	 }
	
	 public  static void type(WebElement webElement, String text) throws CFException {
		 events.type(webElement, text);
	 }
	 
	 public static void select(Select selectField,
				int index) throws CFException {
		 events.select(selectField, index);
	 }
	 
	 public static void selectByValue(Select selectField, String value) throws CFException {
		 events.selectByValue(selectField, value);
	 }
	 
	 public static void selectByText(Select selectField,
				String selectString) throws CFException {
		 events.selectByText(selectField, selectString);
	 }
	 
	 public static void check(WebElement webElement) throws CFException {
		 events.check(webElement);
	 }
	 public static void unCheck(WebElement webElement) throws CFException {
		 events.unCheck(webElement);
	 }
	 
	 public static void choose(WebElement webElement) throws CFException {
		 events.choose(webElement);
	 }
	 
	 public static void doubleClick(WebElement webElement) throws CFException {
		 events.doubleClick(webElement);
	 }
	 
}
