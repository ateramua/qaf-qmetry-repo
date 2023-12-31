package com.qmetry.qaf.Utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class Utilities {
	
	/*
	 * Method - Scroll to the Element and Click
	 */
	public static void scrollAndClick(QAFExtendedWebDriver driver, QAFWebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Reporter.log(element.isPresent()+ element.getText() +" is present");
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("arguments[0].click();", element);
		
	}
	
	
	public static void switchToNewTab(QAFExtendedWebDriver driver) {
		ArrayList<String> tabs = new ArrayList<String>();
		Reporter.log(tabs.size() + " How many tabs are open");
		driver.switchTo().window(tabs.get(1));
	}
	
	/*
	 * Method - select from dropdown
	 */
	public static void selectFromDropdown(QAFWebElement dropDown, String dropDownValue) {
		List<WebElement> ddList = dropDown.findElements(By.xpath(dropDownValue));
		for(WebElement ele:ddList) {
			if(ele.getText().trim().equalsIgnoreCase(dropDownValue)) {
				ele.click();
				Validator.assertTrue(dropDown.getText().trim().equalsIgnoreCase(dropDownValue), "User failed to select " + dropDownValue, "Use successfully selected "+dropDownValue);
			}
		}
	}

}
