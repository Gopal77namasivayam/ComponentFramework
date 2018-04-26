package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;

public class Label {
	private By by;
	private WebElement lbl;
	private String labelName;
	private String labelDesc;
//	private ElementUtil elementUtil;
	
	public Label(String label,String description){
		
		labelName=label;
		labelDesc=description;
	}
	
	/**
	 * This method will return the content in the Label
	 * 
	 * @author Pradeep Sundaram
	 * @return String
	 * 
	 */
	public String getText() {
		by=getBy(labelName);
		lbl=ElementUtil.findElement(by);
		WebPage.elementList.put(lbl, labelDesc);
		return lbl.getText();
	}
	
	/**
	 * This method will return the By of the label
	 * @author Pradeep Sundaram
	 * @return
	 */
	public By getBy() {
		return by;
	}
	
	/**
	 * This method will return the webElement of the label
	 * @author Pradeep Sundaram
	 * @return  WebElement
	 */
	public WebElement getWebElement() {
		lbl=ElementUtil.findElement(by);
		return lbl;
	}
	
	/**
	 * will return boolean based on the presence of the label
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		lbl=ElementUtil.findElement(by);
		Report.log("Checking whether the field \"" + WebPage.elementList.get(lbl)+"\" is displayed.<BR>");
		return lbl.isDisplayed();
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
