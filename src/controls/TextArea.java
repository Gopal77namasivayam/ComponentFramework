package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import exception.CFException;

public class TextArea {
	private WebElement textArea;
	private By by;
	private String taName;
	private String taDesc;
	
	public TextArea(String taID,String desc){
		taName=taID;
		taDesc=desc;
	}
	
	/**
	 * This method will type the passed text in TextArea
	 * 
	 * @author Pradeep Sundaram
	 * @param text
	 * @throws IOException
	 */
	public void type(String text){
		by=getBy(taName);
		textArea=ElementUtil.findElement(by);
		WebPage.elementList.put(textArea, taDesc);
		try {
			ElementUtil.type(textArea, text);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will return the By for the Text Area
	 * 
	 * @author Pradeep Sundaram
	 * @return By
	 */
	public By getBy() {
		return by;
	}
	
	/**
	 * This method will return the webelement of the textarea
	 * @author Pradeep Sundaram
	 * @return WebElement
	 */
	public WebElement getWebElement(){
		textArea=ElementUtil.findElement(by);
		return textArea;
	}
	
	/**
	 * will return boolean based on the presence of the text area
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		textArea=ElementUtil.findElement(by);
		Report.log("Checking whether the field \"" + WebPage.elementList.get(textArea)+"\" is displayed.<BR>");
		return textArea.isDisplayed();
	}
	
	private By getBy(String elementName){
		By newBy=null;
		if (elementName.startsWith("name")) {
			by=ElementUtil.byName(elementName);
		} else if (elementName.startsWith("css")) {
			by=ElementUtil.byCss(elementName);
		} else if (elementName.startsWith("//")) {
			by=ElementUtil.byXpath(elementName);
		} else if (elementName.startsWith("id")) {
			by=ElementUtil.byID(elementName);
		} else{
			by=ElementUtil.byIDOrName(elementName);
		}
		return newBy;
	}
}
