package controls;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementFinder {
	
	WebDriver driver;

	public ElementFinder(WebDriver webDriver){
		driver=webDriver;
	}
	
	public WebElement findElementByXpath(String elementXpath){
		return driver.findElement(By.xpath(elementXpath));
	}
	
	public ArrayList<Object> findElementByXpath1(String elementXpath){
		ArrayList<Object> element=new ArrayList<Object>();
		element.add(driver.findElement(By.xpath(elementXpath)));
		element.add(By.xpath(elementXpath));
		return element;
	}
	
	public WebElement findElementByID(String elementID){
		String []eleID= elementID.split("=");
		return driver.findElement(By.id(eleID[1]));
	}
	
	 public WebElement findElementByName(String elementName){
		String []elementID= elementName.split("=");
		return driver.findElement(By.name(elementID[1]));
	}
	
	 public WebElement findElementByCss(String elementCss){
		String []elementID= elementCss.split("=");
		return driver.findElement(By.cssSelector(elementID[1]));
	}
	
	 public WebElement findElementByLinkText(String elementLinkText){
		String []elementID= elementLinkText.split("=");
		return driver.findElement(By.linkText(elementID[1]));
	}
	
	 public Select findSelectByXpath(String elementXpath){
		return new Select(driver.findElement(By.xpath(elementXpath)));
	}
	
	 public Select findSelectByID(String elementID){
		String []eleID= elementID.split("=");
		return new Select(driver.findElement(By.id(eleID[1])));
		
	}
	
	 public Select findSelectByName(String elementName){
		String []elementID= elementName.split("=");
		return new Select(driver.findElement(By.name(elementID[1])));
	}
	
	 public Select findSelectByCss(String elementCss){
		String []elementID= elementCss.split("=");
		return new Select(driver.findElement(By.cssSelector(elementID[1])));
	}
	 
	 
	 
}

