package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import exception.CFException;

public class CheckBox {
	private WebElement checkBox;
	private By by;
	String checkBoxID;
	String desc;
	
	public CheckBox(String checkBoxName,String description){
		checkBoxID=checkBoxName;
		desc=description;
	}
	
	/**
	 * This method will check the check box if it is unchecked
	 * 
	 * @author Pradeep Sundaram
	 */
	public void check() {
		by=getBy(checkBoxID);
		checkBox=ElementUtil.findElement(by);
		WebPage.elementList.put(checkBox, desc);
		try {
			ElementUtil.check(checkBox);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method will uncheck the check box if it is checked, leaves it if the
	 * check box is not checked
	 * 
	 * @author Pradeep Sundaram
	 */
	public void unCheck() {
		by=getBy(checkBoxID);
		checkBox=ElementUtil.findElement(by);
		WebPage.elementList.put(checkBox, desc);
		try {
			ElementUtil.unCheck(checkBox);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will return whether the Check box is checked in the page 
	 * @throws IOException
	 */
	public boolean isChecked() {
		by=getBy(checkBoxID);
		checkBox=ElementUtil.findElement(by);
		WebPage.elementList.put(checkBox, desc);
		return checkBox.isSelected();
	}
	
	
	/**
	 * This method will return the By for the Check Box
	 * @author Pradeep Sundaram
	 * @param elem
	 * @return
	 */
	public By getBy() {
		return by;
	}
	
	/**
	 * This method will return the webelement of the check box
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public WebElement getWebElement(){
		checkBox=ElementUtil.findElement(by);
		return checkBox;
	}
	
	
	/**
	 * will return boolean based on the presence of the check box
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		checkBox=ElementUtil.findElement(by);
		Report.log("Checking whether the field \"" + WebPage.elementList.get(checkBox)+"\" is displayed.<BR>");
		return checkBox.isDisplayed();
	}
	
	private By getBy(String elementName){
		By newBy=null;
		if(checkBoxID.startsWith("name")){
			newBy=ElementUtil.byName(checkBoxID);
		}
		else if(checkBoxID.startsWith("css")){
			newBy=ElementUtil.byCss(checkBoxID);
		}
		else if(checkBoxID.startsWith("//")){
			newBy=ElementUtil.byXpath(checkBoxID);
		}
		else if(checkBoxID.startsWith("id")){
			newBy=ElementUtil.byID(checkBoxID);
		}
		else{
			newBy=ElementUtil.byIDOrName(checkBoxID);
		}
		return newBy;
	}
}
