package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import exception.CFException;

public class TextField {
	
	private WebElement textField;
	private By by;
	String txtDescription;
	String txtID;
	
	
	/**
	 * This method will return the By of the text field
	 * @author Pradeep Sundaram
	 * @return
	 */
	public By getBy(){
		return by;
	}
	
	/**
	 * This method will return the webElement of the text field
	 * @author Pradeep Sundaram
	 * @return 
	 */
	public WebElement getWebElement(){
		textField=ElementUtil.findElement(by);
		return textField;
	}
	
	public TextField(String textID,String fieldDesc){
		txtID=textID;
		txtDescription=fieldDesc;
		
		/*
		 * removed this part to identify the element only when action is performed on webelement
		 * if(txtID.startsWith("id")){
			by=ElementUtil.byID(txtID);
		}
		else if(txtID.startsWith("name")){
			by=ElementUtil.byName(txtID);
		}
		else if(txtID.startsWith("css")){
			by=ElementUtil.byCss(txtID);
		}
		else if(txtID.startsWith("//")){
			System.out.println("inside xpath");
			by=ElementUtil.byXpath(txtID);
		}
		else{
			System.out.println("inside TF else for id or name");
			by=ElementUtil.byIDOrName(textID);
			System.out.println("by is - "+by);
		}*/
	}
	
	/**
	 * This method will type the text in Text Field
	 * 
	 * @author Pradeep Sundaram
	 * @param text
	 */
	public void type(String text){
		by=getBy(txtID);
		System.out.println("text field by is "+by);
		textField=ElementUtil.findElement(by);
		WebPage.elementList.put(textField, txtDescription);
		try {
			ElementUtil.type(textField, text);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will click in the Text Field for Date controls
	 * 
	 * @author Pradeep Sundaram
	 */
	/*public void click()  {
		Events.click(textField);
	}*/
	
	/**
	 * This method will return the text in the text field
	 * 
	 * @author Pradeep Sundaram
	 * @return String
	 */ 
	public String getText(){
		textField=ElementUtil.findElement(by);
		return textField.getAttribute("value");	
	}
	
	/**
	 * will return boolean based on the presence of the text field
	 * 
	 * @author Pradeep Sundaram S
	 * @return boolean
	 */
	public boolean isDisplayed() {
		textField=ElementUtil.findElement(by);
		Report.log("Checking whether the field \"" + WebPage.elementList.get(textField)+"\" is displayed.<BR>");
		return textField.isDisplayed();
	}	
	/**
	 * will return true if the text field is enabled else false will be returned
	 * 
	 * @author Pradeep Sundaram 
	 * @return boolean
	 */
	public boolean isEnabled() {
		textField=ElementUtil.findElement(by);
		Report.log("Checking whether the field \"" + WebPage.elementList.get(textField)+"\" is displayed.<BR>");
		return textField.isEnabled();
	}
	
	private By getBy(String elementName){
		By newBy=null;
		if (elementName.startsWith("name")) {
			newBy = ElementUtil.byName(elementName);
		} else if (elementName.startsWith("css")) {
			newBy = ElementUtil.byCss(elementName);
		} else if (elementName.startsWith("id")) {
			newBy = ElementUtil.byID(elementName);
		} else if (elementName.startsWith("//")) {
			newBy = ElementUtil.byXpath(elementName);
		} else {
			newBy = ElementUtil.byIDOrName(elementName);
		}
		return newBy;
	}
	
}
