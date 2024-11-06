package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.OpenBrowser;
import pom.HomePage;

public class HomePageTest extends BaseTest{
		@BeforeMethod
			public void launchBrowser() {
				driver=OpenBrowser.launchBrowser();
			}
			@Test(priority=0)
			public void checkWidgetLanguage() {
				HomePage homepage=new HomePage(driver);
				// Click on the "Account" button to open account settings
				homepage.clickAccount();
				// Enter email for login
				homepage.enterEmail("automationtesting@gmail.com");
				// Enter password for login
				homepage.enterPassword("123456789");
				// Click on the "Sign In" button to log in
				homepage.clickSign();
				//Click home button
				homepage.clickHome();
				//Click product to buy
				homepage.clickProduct();
				//Check language
				String msg=homepage.checkLanguage(driver);
				//Assert Language on widget
				Assert.assertTrue(msg.contains("Subscription Test"));
			} 
			@Test(priority=1)
			public void selectFrequecy() {
				HomePage homepage=new HomePage(driver);
				homepage.clickAccount();
				homepage.enterEmail("automationtesting@gmail.com");
				homepage.enterPassword("123456789");
				homepage.clickSign();
				homepage.clickHome();
				homepage.clickProduct();
				homepage.clickSubscription();
				homepage.clickFrequency();
				String msg=homepage.checkDiscount();
				Assert.assertTrue(msg.contains("Save 10%"));
			} 
			@Test(priority=2)
			public void verifyPrice() {
				HomePage homepage=new HomePage(driver);
				homepage.clickAccount();
				homepage.enterEmail("automationtesting@gmail.com");
				homepage.enterPassword("123456789");
				homepage.clickSign();
				homepage.clickHome();
				homepage.clickProduct();
				homepage.clickSubscription();
				homepage.clickFrequency();
				String widgetPrice=homepage.getWidgetPrice();
				String productPrice=homepage.getWidgetPrice();
				Assert.assertTrue(widgetPrice.equals(productPrice));
			} 
			@Test(priority=3)
			public void verifyBuyNowButton() {
				HomePage homepage=new HomePage(driver);
				homepage.clickAccount();
				homepage.enterEmail("automationtesting@gmail.com");
				homepage.enterPassword("123456789");
				homepage.clickSign();
				homepage.clickHome();
				homepage.clickProduct();
				homepage.clickSubscription();
				homepage.clickFrequency();
				homepage.scrollPage(driver);
				homepage.clickBuyNow(driver);
				String msg=homepage.getPayNowText(driver);
				Assert.assertTrue(msg.contains("Pay now"));
			} 
}
