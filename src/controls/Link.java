package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import exception.CFException;

public class Link {
	private WebElement link;
	private By by;
	private String linkName;
	private String linkDesc;
	

	public Link(String linkText,String desc){
		linkDesc=desc;
		linkName=linkText;
	}
	
	public Link(String linkText){
		link=ElementUtil.findElementByLinkText(linkText);
		WebPage.elementList.put(link, linkText);
	}
	
	/**
	 * This method will click in the link passed as argument
	 * 
	 * @author Pradeep Sundaram
	 */
	public void click(){
		by=getBy(linkName);
		link=ElementUtil.findElement(by);
		WebPage.elementList.put(link, linkDesc);
		try {
			ElementUtil.click(link);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will return the By for the button
	 * 
	 * @author Pradeep Sundaram
	 * @return By
	 */
	public By getBy() {
		return by;
	}
	
	/**
	 * This method will return the text displayed in the text
	 * 
	 * @author Pradeep Sundaram
	 * @return String
	 */
	public String getText(){
		by=getBy(linkName);
		link=ElementUtil.findElement(by);
		WebPage.elementList.put(link, linkDesc);
		return link.getText();
	}
	/**
	 * This method will return the webelement of the link
	 * @author Pradeep Sundaram
	 * @return WebElement
	 */
	public WebElement getWebElement(){
		by=getBy(linkName);
		link=ElementUtil.findElement(by);
		WebPage.elementList.put(link, linkDesc);
		return link;
	}
	
	
	/**
	 * will return boolean based on the presence of the link
	 * 
	 * @author Pradeep Sundaram 
	 * @return boolean
	 */
	public boolean isDisplayed() {
		link=ElementUtil.findElement(by);
		WebPage.elementList.put(link, linkDesc);
		Report.log("Checking whether the field \"" + WebPage.elementList.get(link)+"\" is displayed.<BR>");
		return link.isDisplayed();
	}

	
	private By getBy(String elementName){
		By newBy=null;
		if (linkName.startsWith("id")) {
			newBy = ElementUtil.byID(linkName);
		}
		else if (linkName.startsWith("css")) {
			newBy = ElementUtil.byCss(linkName);
		}
		else if (linkName.startsWith("//")) {
			newBy = ElementUtil.byXpath(linkName);
		}
		else if (linkName.startsWith("link")) {
			newBy = ElementUtil.byLinkText(linkName);
		} else {
			newBy = ElementUtil.byIDOrName(linkName);
		}
		return newBy;
	}
}
