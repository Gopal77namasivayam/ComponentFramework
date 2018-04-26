package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import exception.CFException;

public class Image {
	private WebElement image;
	private String desc;
	private String imageName;
	private By by;

	/**
	 * Constructor for button when mouse over or double click is required for
	 * the button
	 * 
	 * @author PSubramani33
	 * @param imageName
	 * @param imageDesc
	 * @param util
	 * @param events
	 */
	public Image(String imageID, String imageDesc) {
		desc=imageDesc;
		imageName=imageID;
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
		by=getBy(imageName);
		image=ElementUtil.findElement(by);
		WebPage.elementList.put(image, desc);
		try {
			ElementUtil.click(image);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method will double click on the button
	 * 
	 * @author PSubramani33
	 */
	public void doubleClick() {
		by=getBy(imageName);
		image=ElementUtil.findElement(by);
		WebPage.elementList.put(image, desc);
		try {
			ElementUtil.doubleClick(image);
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
		image=ElementUtil.findElement(by);
		return image;
	}

	/**
	 * will return boolean based on the presence of the button
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		image=ElementUtil.findElement(by);
		Report.log("Checking whether the field "+WebPage.elementList.get(image) + " is displayed.<BR>");
		return image.isDisplayed();
	}

	/**
	 * This method will return the tool tip of the button
	 * 
	 * @author PSubramani33
	 * @return String
	 */
	public String getToolTip() {
		image=ElementUtil.findElement(by);
		Report.log("Getting the tool tip of the image "+WebPage.elementList.get(image) + ".<BR>");
		return image.getAttribute("title");
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
