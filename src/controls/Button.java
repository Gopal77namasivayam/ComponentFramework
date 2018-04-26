package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import exception.CFException;

public class Button {
	private WebElement button;
	private String desc;
	private String buttonName;
	private By by;

	/**
	 * Constructor for button when mouse over or double click is required for
	 * the button
	 * 
	 * @author PSubramani33
	 * @param buttonID
	 * @param buttonDesc
	 * @param util
	 * @param events
	 */
	public Button(String buttonID, String buttonDesc) {
		desc=buttonDesc;
		buttonName=buttonID;
	}


	/**
	 * This method will return the By of the text field
	 * 
	 * @author Pradeep Sundaram
	 * @return By
	 */
	public By getBy() {
		return by;
	}

	/**
	 * This method will click in the button
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException 
	 */
	public void click() {
		by=getBy(buttonName);
		button=ElementUtil.findElement(by);
		if(!button.isEnabled()){
			button=ElementUtil.findElement(By.name(this.desc));
		}
		WebPage.elementList.put(button, desc);
		try {
			ElementUtil.click(button);
		} catch (CFException e) {
			System.out.println("inside exception");
			e.printStackTrace();
		}
	}

	/**
	 * this method will double click on the button
	 * 
	 * @author PSubramani33
	 */
	public void doubleClick() {
		by=getBy(buttonName);
		button=ElementUtil.findElement(by);
		WebPage.elementList.put(button, desc);
		try {
			ElementUtil.doubleClick(button);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will return the webElement of the button
	 * 
	 * @author Pradeep Sundaram
	 * @return WebElement
	 */
	public WebElement getWebElement() {
		button=ElementUtil.findElement(by);
		return button;
	}

	/**
	 * will return boolean based on the presence of the button
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		button=ElementUtil.findElement(by);
		
		Report.log("Checking whether the field "+WebPage.elementList.get(button) + " is displayed.<BR>");
		return button.isDisplayed();
	}

	/**
	 * This method will return the tool tip of the button
	 * 
	 * @author PSubramani33
	 * @return String
	 */
	public String getToolTip() {
		button=ElementUtil.findElement(by);
		Report.log("Getting the tool tip of the button "+WebPage.elementList.get(button) + ".<BR>");
		return button.getAttribute("title");
	}
	
	private By getBy(String elementName){
		By newBy=null;
		if(elementName.contains("=")){
			if (elementName.startsWith("name")) {
				newBy=ElementUtil.byName(elementName);
			} else if (elementName.startsWith("css")) {
				newBy=ElementUtil.byCss(elementName);
			}  else if (elementName.startsWith("id")) {
				newBy=ElementUtil.byID(elementName);
			}	
		}
		else if (elementName.startsWith("//")) {
			newBy=ElementUtil.byXpath(elementName);
		}
		 else{
			 newBy=ElementUtil.byIDOrName(elementName);
		}
		return newBy;
	}
}
