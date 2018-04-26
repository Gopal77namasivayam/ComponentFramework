package controls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.WebPage;
import reports.Report;
import exception.CFException;

public class SelectBox {
	private Select selectBox;
	private By by;
	private String selectName;
	private String selectDesc;
	
	public SelectBox(String selectID,String fieldDesc){
		selectName=selectID;
		selectDesc=fieldDesc;
	}
	
	/**
	 * This method select the text in drop down for the passed index
	 * 
	 * @author Pradeep Sundaram
	 * @param index
	 * @throws IOException
	 */
	public void select(int index){
		by=getBy(selectName);
		selectBox=ElementUtil.findSelect(by);
		WebPage.elementList.put(selectBox, selectDesc);
		try {
			ElementUtil.select(selectBox, index);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * This method selects the text in drop down for the passed value
	 * 
	 * @author Pradeep Sundaram
	 * @param value
	 */
	public void selectByValue(String value){
		by=getBy(selectName);
		selectBox=ElementUtil.findSelect(by);
		WebPage.elementList.put(selectBox, selectDesc);
		try {
			ElementUtil.selectByValue(selectBox, value);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method selects the passed text in the drop down
	 * 
	 * @author Pradeep Sundaram
	 * @param selectString
	 */
	public void select(String selectString)  {
		by=getBy(selectName);
		selectBox=ElementUtil.findSelect(by);
		WebPage.elementList.put(selectBox, selectDesc);
		try {
			ElementUtil.selectByText(selectBox, selectString);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method will return the selected value in the select box
	 * 
	 * @author Pradeep Sundaram
	 * @return String
	 */
	public String getSelectedValue() {
		by=getBy(selectName);
		selectBox=ElementUtil.findSelect(by);
		WebPage.elementList.put(selectBox, selectDesc);
		return selectBox.getFirstSelectedOption().getText();
	}

	/**
	 * This method will return By of the passed Select
	 * 
	 * @author Pradeep Sundaram
	 * @return By
	 */
	public By getBy() {
		return by;
	}
	/**
	 * This method will return the select of the selectBox
	 * 
	 * @author Pradeep Sundaram
	 * @return Select
	 */
	public Select getSelect(){
		selectBox=ElementUtil.findSelect(by);
		return selectBox;
	}
	
	/**
	 * This method will return all the options in the select box
	 * 
	 * @author Pradeep Sundaram
	 * @return List
	 */
	public List<String> getOptions(){
		selectBox=ElementUtil.findSelect(by);
		List<String> options=new ArrayList<String>();
		List<WebElement> list=selectBox.getOptions();
		int size=list.size();
		for(int i=0;i<size;i++){
			options.add(list.get(i).getText());
		}
		return options;
	}
	
	/**
	 * This method will return the webelement of the select box
	 * 
	 * @author Pradeep Sundaram.S
	 * @return WebElement
	 */
	public WebElement getWebElement(){
		return ElementUtil.findElement(by);
	}
	
	
	/**
	 * will return boolean based on the presence of the select box
	 * 
	 * @author Pradeep Sundaram S
	 * @return boolean
	 */
	public boolean isDisplayed() {
		selectBox=ElementUtil.findSelect(by);
		Report.log("Checking whether the field \"" + WebPage.elementList.get(selectBox)+"\" is enabled.<BR>");
      return ElementUtil.findElement(by).isDisplayed();
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
