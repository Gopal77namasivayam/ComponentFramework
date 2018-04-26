package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import exception.CFException;

public class RadioButton {
	private WebElement radioButton;
	private By by;
	private String rbName;
	private String rbDesc;
	
	/**
	 * Constructor of radio button 
	 * 
	 * @author PSubramani33
	 * @param rbID
	 * @param desc
	 */
	public RadioButton(String rbID,String desc){
		rbName=rbID;
		rbDesc=desc;
	}
	
	/**
	 * This method will choose the radio button
	 * 
	 * @author Pradeep Sundaram
	 */
	public void choose() {
		by=getBy(rbName);
		radioButton=ElementUtil.findElement(by);
		WebPage.elementList.put(radioButton, rbDesc);
		try {
			ElementUtil.choose(radioButton);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will return the By for the Check Box
	 * 
	 * @author Pradeep Sundaram
	 * @return By
	 */
	public By getBy() {
		return by;
	}
	
	/**
	 * This method will return the webelement of the check box
	 * 
	 * @author Pradeep Sundaram
	 * @return WebElement
	 */
	public WebElement getWebElement(){
		radioButton=ElementUtil.findElement(by);
		return radioButton;
	}
	
	
	/**
	 * will return boolean based on the presence of the radio button
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		radioButton=ElementUtil.findElement(by);
		Report.log("Checking whether the field \"" + WebPage.elementList.get(radioButton)+"\" is displayed.<BR>");
      return radioButton.isDisplayed();
	}
	
	/**
	 * will return true when radio button is there in the page, will return true even it is not displayed in the page.
	 * using java script the radio button may not be visible but radio button may there in the page.
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isEnabled() {
		radioButton=ElementUtil.findElement(by);
		Report.log("Checking whether the field \"" + WebPage.elementList.get(radioButton)+"\" is enabled.<BR>");
      return radioButton.isEnabled();
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
