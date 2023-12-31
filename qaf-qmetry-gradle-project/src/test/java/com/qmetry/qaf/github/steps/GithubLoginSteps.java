package com.qmetry.qaf.github.steps;

import com.qmetry.qaf.github.page.GithubLoginPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class GithubLoginSteps extends WebDriverTestCase {

	GithubLoginPage login = new GithubLoginPage();

	@QAFTestStep(description = "user is on github login page")
	public void navToGithubLoginPage() {

		login.openPage(null, "");
		login.waitForPageToLoad();
		Reporter.log("Page have loaded************************");
		login.username.waitForPresent(100000);
		Reporter.log(login.username.isDisplayed()+" User name field is present");
		Reporter.log(login.password.isDisplayed()+" Passowrd field is present");
		Reporter.log(login.signIn.isDisplayed()+" sign in button is present");
		Validator.assertTrue(login.username.isDisplayed(), "User failed to navigate to login page",
				"User successfully navigated to github login page");

	}
	
	@QAFTestStep(description = "user enters user name {username} and password {password}")
	public void enterLoginCredential(String username, String password) {
		login.username.waitForPresent(4000);
		login.username.sendKeys(username);
		login.password.waitForPresent(4000);
		login.password.sendKeys(password);	}
	
	@QAFTestStep(description = "user clicks on sign in button")
	public void clickSignIn() {
		login.signIn.waitForPresent(4000);
		login.signIn.click();
		login.gitHubHomeHeader.waitForPresent(4000);
		Validator.assertTrue(login.gitHubHomeHeader.isDisplayed(), "User failed to login to Github", "User successfully logged in to Github");
		
	}
	
	

}
