package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import page.DatabasePage;
import page.LoginPage;

public class LoginPageTest extends TestBase{
 LoginPage loginpageObj;
 SoftAssert softAssert = new SoftAssert();

@BeforeMethod
public void setUp() {
	initializeDriver();
	loginpageObj = PageFactory.initElements(driver,LoginPage.class);
}

@Test(priority=1)
public void LoginTest() throws InterruptedException,ClassNotFoundException,SQLException, IOException {
	
	loginpageObj.enterUserName(DatabasePage.getData("demo@techfios.com"));
    Thread.sleep(3000);
	
	
	loginpageObj.enterPassword("abc123");
	Thread.sleep(2000);
	
	loginpageObj.clickSignInButton();
	
	takeScreenshotAtEndOfTest(driver);
	
	
}

@Test(priority=2)
public void loginpageTitleTest() throws ClassNotFoundException, SQLException, InterruptedException{
	
	loginpageObj.enterUserName(DatabasePage.getData("demo@techfios.com"));
    Thread.sleep(3000);
	
	
	loginpageObj.enterPassword("abc123");
	Thread.sleep(2000);
	
	loginpageObj.clickSignInButton();
	
	String expectedTitle="Dashboard- iBilling";
	String actualTitle=loginpageObj.getPageTitle();
	Assert.assertEquals(expectedTitle, actualTitle);
	
}

@AfterMethod
public void tearDown() {
	driver.close();
	driver.quit();
}
	
}
