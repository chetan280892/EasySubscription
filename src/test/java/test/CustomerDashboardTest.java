package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.OpenBrowser;
import pom.CustomerDashboard;

public class CustomerDashboardTest extends BaseTest{
@BeforeMethod
	public void launchBrowser() {
		driver=OpenBrowser.launchBrowser();
	}
	@Test(priority=0)
	public void checkLanguageCustomerPortal(){
		CustomerDashboard customerDashboard=new CustomerDashboard(driver);
		customerDashboard.clickAccount();
		customerDashboard.enterEmail("automationtesting@gmail.com");
		customerDashboard.enterPassword("123456789");
		customerDashboard.clickSign();
		customerDashboard.clickManageButton();
		BaseTest.switchToWindow("ESA Customer Portal");
		customerDashboard.waitContract(driver);
		String language=customerDashboard.checkLanguage();
		Assert.assertTrue(language.contains("Subscription L1"));
	} 
	@Test(priority=1)
	public void openContract() {
		CustomerDashboard customerDashboard=new CustomerDashboard(driver);
		customerDashboard.clickAccount();
		customerDashboard.enterEmail("automationtesting@gmail.com");
		customerDashboard.enterPassword("123456789");
		customerDashboard.clickSign();
		customerDashboard.clickManageButton();
		BaseTest.switchToWindow("ESA Customer Portal");
		customerDashboard.waitContract(driver);
		customerDashboard.clickContract(driver);
		customerDashboard.skipLanguage(driver);
		String subscription=customerDashboard.checkLanguage1();
		Assert.assertTrue(subscription.contains("Subscription L2"));
	}


	@Test(priority=2)
	public void skipContract() {
		CustomerDashboard customerDashboard=new CustomerDashboard(driver);
		customerDashboard.clickAccount();
		customerDashboard.enterEmail("automationtesting@gmail.com");
		customerDashboard.enterPassword("123456789");
		customerDashboard.clickSign();
		customerDashboard.clickManageButton();
		BaseTest.switchToWindow("ESA Customer Portal");
		customerDashboard.waitContract(driver);
		customerDashboard.clickContract(driver);
		customerDashboard.clickSkip(driver);
		customerDashboard.clickConfirm();
		String skip=customerDashboard.skipMsg(driver);
	    Assert.assertEquals(skip, "Contract Skipped.");
	}
	@Test(priority=3)
	public void verifySwapProduct() throws InterruptedException {
		CustomerDashboard customerDashboard=new CustomerDashboard(driver);
		customerDashboard.clickAccount();
		customerDashboard.enterEmail("automationtesting@gmail.com");
		customerDashboard.enterPassword("123456789");
		customerDashboard.clickSign();
		customerDashboard.clickManageButton();
		BaseTest.switchToWindow("ESA Customer Portal");
		customerDashboard.waitContract(driver);
		customerDashboard.clickContract(driver);
		customerDashboard.clickSwap(driver);
		customerDashboard.clickSwap(driver);
		customerDashboard.clickConfirm();
		String swap=customerDashboard.swapMsg(driver);
	    Assert.assertEquals(swap, "Product Swapped.");
	}
	@Test(priority=4)
	public void verifyProductAfterSwapping() throws InterruptedException {
		CustomerDashboard customerDashboard=new CustomerDashboard(driver);
		customerDashboard.clickAccount();
		customerDashboard.enterEmail("automationtesting@gmail.com");
		customerDashboard.enterPassword("123456789");
		customerDashboard.clickSign();
		customerDashboard.clickManageButton();
		BaseTest.switchToWindow("ESA Customer Portal");
		customerDashboard.waitContract(driver);
		customerDashboard.clickContract(driver);
		customerDashboard.clickSwap(driver);
		customerDashboard.clickSwap(driver);
		customerDashboard.clickConfirm();
		String product=customerDashboard.productAfterSwapping(driver);
	    Assert.assertEquals(product, "Automation Product-Bronze");
	}
	@Test(priority=5)
	public void verifyProductPriceAfterSwapping() throws InterruptedException {
		CustomerDashboard customerDashboard=new CustomerDashboard(driver);
		// Click on the "Account" button to open account settings
		customerDashboard.clickAccount();
		// Enter email for login
		customerDashboard.enterEmail("automationtesting@gmail.com");
		// Enter password for login
		customerDashboard.enterPassword("123456789");
		// Click on the "Sign In" button to log in
		customerDashboard.clickSign();
		// Click on the "Manage" button to manage account settings
		customerDashboard.clickManageButton();
		// Switch to the window with the title "ESA Customer Portal"
		BaseTest.switchToWindow("ESA Customer Portal");
		// Wait for the contract section to load
		customerDashboard.waitContract(driver);
		// Click on the contract
		customerDashboard.clickContract(driver);
		// Click on Swap button 
		customerDashboard.clickSwap(driver);
		// Again click on Swap button on swap page
		customerDashboard.clickSwap(driver);
		// Click Confirm button
		customerDashboard.clickConfirm();
		//Change price format
		double beforeSwapPrice=Double.parseDouble(customerDashboard.swapPriceMsg());
		//Print Price before swapping
		System.out.println("Before swapping price : "+ beforeSwapPrice);
		double afterSwapPrice = Double.parseDouble(customerDashboard.afterSwapPriceMsg(driver));
		//Print Price after swapping
		System.out.println("After swapping price : "+ afterSwapPrice);
		//Apply 10% Discount
		double expectedPriceAfterDiscount = beforeSwapPrice-50* 0.1;
		//Print Price after swapping with 10% Discount
	    System.out.println("After swapping price with 10% discount: "+ expectedPriceAfterDiscount);
	    //Assert Before and After Swapping Price
		Assert.assertEquals(afterSwapPrice, expectedPriceAfterDiscount);
	}
	@Test(priority=6)
	public void cancelContract() {
		CustomerDashboard customerDashboard=new CustomerDashboard(driver);
		// Click on the "Account" button to open login page
		customerDashboard.clickAccount();
		// Enter email for login
		customerDashboard.enterEmail("automationtesting@gmail.com");
		// Enter password for login
		customerDashboard.enterPassword("123456789");
		// Click on the "Sign In" button to log in
		customerDashboard.clickSign();
		// Click on the "Manage" button to manage account settings
		customerDashboard.clickManageButton();
		// Switch to the window with the title "ESA Customer Portal"
		BaseTest.switchToWindow("ESA Customer Portal");
		 // Wait for the contract section to load
		customerDashboard.waitContract(driver);
		// Click on the contract
		customerDashboard.clickContract(driver);
		// Click the "Cancel" button
		customerDashboard.clickCancel(driver);
		// Confirm the cancellation action
		customerDashboard.clickConfirm();
		// Retrieve the status of the contract to check if it was successfully canceled
		String active=customerDashboard.cancelledStatus(driver);
		//click active button
		customerDashboard.clickActive();
		// Confirm the cancellation action
		customerDashboard.clickConfirm();
		// Assert that the contract status is "Canceled L9" as expected
	    Assert.assertEquals(active, "Canceled L9");
	}
	@Test(priority=7)
	public void verifyDateAfterSkip() throws InterruptedException {
		CustomerDashboard customerDashboard=new CustomerDashboard(driver);
		// Click on the "Account" button to open login Page
		customerDashboard.clickAccount();
		// Enter email for login
		customerDashboard.enterEmail("automationtesting@gmail.com");
		// Enter password for login
		customerDashboard.enterPassword("123456789");
		// Click on the "Sign In" button to log in
		customerDashboard.clickSign();
		// Click on the "Manage" button to manage account settings
		customerDashboard.clickManageButton();
		// Switch to the window with the title "ESA Customer Portal"
		BaseTest.switchToWindow("ESA Customer Portal");
		 // Wait for the contract section to load
		customerDashboard.waitContract(driver);
		// Click on the contract
		customerDashboard.clickContract(driver);
		String beforeSkip=customerDashboard.beforeSkipOrderDate(driver);
		System.out.println("Before Skip Date :"+beforeSkip);
		//Click on skip button
		customerDashboard.clickSkip(driver);
		//Click on confirm button
		customerDashboard.clickConfirm();
		String afterSkipDate =customerDashboard.afterSkipOrderDate(driver);
		System.out.println("After Skip Date: "+afterSkipDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate beforeSkipLocalDate = LocalDate.parse(beforeSkip, formatter);
	    LocalDate adjustedDate = beforeSkipLocalDate.plusDays(14);
	    System.out.println("Adjusted Date (After Skip Frequency 2 weeks): " + adjustedDate);
	    Assert.assertEquals(afterSkipDate, adjustedDate.toString());
	}
}




