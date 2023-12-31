package com.qmetry.qaf.github.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.annotations.PageIdentifier;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class GithubLoginPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@PageIdentifier 
	@FindBy(locator="xpath=//*[@name='login']")
	public QAFWebElement username;
	
	@PageIdentifier 
	@FindBy(locator="xpath=//*[@name='password']")
	public QAFWebElement password;
	
	@PageIdentifier 
	@FindBy(locator="xpath=//*[@name='commit']")
	public QAFWebElement signIn;
	
	
	
	@FindBy(locator="xpath=//*[@aria-label='Homepage ']")
	public QAFWebElement gitHubHomeHeader;
	
	
	
	
	public void openPage(PageLocator locator, Object... args) {
		driver.get("/");
		driver.manage().window().maximize();
		clearBrowserCache(getDriver());
		driver.manage().deleteAllCookies();
		
		
	}
	
    public static void clearBrowserCache(WebDriver driver) {
        if (driver instanceof JavascriptExecutor) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            
            // Execute JavaScript to clear the browser cache
            jsExecutor.executeScript("window.location.reload(true);");
        } else {
            System.out.println("Warning: WebDriver does not support JavaScript execution.");
        }
    }

	
	public void invoke() {
		launchPage(null);
	}
	
	public QAFExtendedWebDriver getDriver() {
		return ((QAFExtendedWebDriver) getTestBase().getDriver());
	}
	
	public void waitForPageToLoad() {
	    super.waitForPageToLoad();
	}
	

	


}
