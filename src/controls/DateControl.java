package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import exception.CFException;

public class DateControl {
	private WebElement dateControl;
	private By by;
	String dateName;
	String dateDesc;
//	private ElementUtil elementUtil;
	
	public DateControl(WebElement date, String desc) {
		dateControl = date;
		WebPage.elementList.put(dateControl, desc);
	}
	
	public DateControl(String dateControl,String description){
		dateName=dateControl;
		dateDesc=description;
		/*if(dateName.startsWith("name")){
			by=ElementUtil.byName(dateName);
		}
		else if(dateName.startsWith("css")){
			by=ElementUtil.byCss(dateName);
		}
		else if(dateName.startsWith("//")){
			by=ElementUtil.byXpath(dateName);
		}
		else if(dateName.startsWith("id")){
			by=ElementUtil.byID(dateName);
		}
		else{
			by=ElementUtil.byIDOrName(dateName);
		}*/
		WebPage.elementList.put(dateControl, description);
	}
	
	/**
	 * This method will select a date in Date controls
	 * 
	 * @author Pradeep Sundaram
	 */
	public void click() {
		if(dateName.startsWith("name")){
			by=ElementUtil.byName(dateName);
		}
		else if(dateName.startsWith("css")){
			by=ElementUtil.byCss(dateName);
		}
		else if(dateName.startsWith("//")){
			by=ElementUtil.byXpath(dateName);
		}
		else if(dateName.startsWith("id")){
			by=ElementUtil.byID(dateName);
		}
		else{
			by=ElementUtil.byIDOrName(dateName);
		}
		dateControl=ElementUtil.findElement(by);
		try {
			ElementUtil.click(dateControl);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method will return By of the dateControl
	 * 
	 * @author Pradeep Sundaram
	 * @return By
	 */
	public By getBy(){
		return by;
	}
	
	/**
	 * This method will return the webelement for date control
	 * @author Pradeep Sundaram
	 * @return WebElement
	 */
	public WebElement getWebElement(){
		dateControl=ElementUtil.findElement(by);
		return dateControl;
	}
}
