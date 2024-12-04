package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.OpenBrowser;
import pom.BundlePage;

public class BundlePageTest extends BaseTest{
	@BeforeMethod
	public void launchBrowser() {
		driver=OpenBrowser.launchBrowser();
	}
	@Test(priority=0)
		public void verifyFixedBundleLanguage() throws InterruptedException {
			BundlePage bundlePage=new BundlePage(driver);
			// Click on the "Account" button to open account settings
			bundlePage.clickAccount();
			// Enter email for login
			bundlePage.enterEmail("automationtesting@gmail.com");
			// Enter password for login
			bundlePage.enterPassword("123456789");
			// Click on the "Sign In" button to log in
			bundlePage.clickSign();
			//Click home button
			bundlePage.clickHome();
			//Click product to buy
			bundlePage.clickFixedBundle();
			//Wait for 5 Seconds
			Thread.sleep(5000);
			//Get Bundle Language
			String text=bundlePage.checkLanguage();
			//Assert Bundle Language
			Assert.assertTrue(text.contains("Purchase Option Test"));
}
	@Test(priority=1)
	public void verifyFixedBundleContent() {
		BundlePage bundlePage=new BundlePage(driver);
		// Click on the "Account" button to open account settings
		bundlePage.clickAccount();
		// Enter email for login
		bundlePage.enterEmail("automationtesting@gmail.com");
		// Enter password for login
		bundlePage.enterPassword("123456789");
		// Click on the "Sign In" button to log in
		bundlePage.clickSign();
		//Click home button
		bundlePage.clickHome();
		//Click product to buy
		bundlePage.clickFixedBundle();
		String content=bundlePage.checkContent();
		System.out.println(content);
		Assert.assertTrue(content.contains("Automation Product"));
}
	@Test(priority=2)
	public void verifyDynamicBundlePrice() throws InterruptedException {
		BundlePage bundlePage=new BundlePage(driver);
		// Click on the "Account" button to open account settings
		bundlePage.clickAccount();
		// Enter email for login
		bundlePage.enterEmail("automationtesting@gmail.com");
		// Enter password for login
		bundlePage.enterPassword("123456789");
		// Click on the "Sign In" button to log in
		bundlePage.clickSign();
		//Click home button
		bundlePage.clickHome();
		//Click dynamic fixed bundle
		bundlePage.clickDynamicFixedBundle();
		//Step 1 Add product
		bundlePage.clickAddButton();
		//Click next Button
		bundlePage.clickNextButton();
		//Step 2 Add product
	    bundlePage.clickAddButton1();
	    //Increase Quantity
	    bundlePage.clickPlusButton();
	  //Increase Quantity
	    bundlePage.clickPlusButton();
	    //Get Fixed Bundle Price
	    String price=bundlePage.checkPrice();
		System.out.println(price);
		//Assert review your order price 
		Assert.assertTrue(price.contains("199"));
}
	@Test(priority=3)
	public void verifyDynamicBundle() throws InterruptedException {
		BundlePage bundlePage=new BundlePage(driver);
		// Click on the "Account" button to open account settings
		bundlePage.clickAccount();
		// Enter email for login
		bundlePage.enterEmail("automationtesting@gmail.com");
		// Enter password for login
		bundlePage.enterPassword("123456789");
		// Click on the "Sign In" button to log in
		bundlePage.clickSign();
		//Click home button
		bundlePage.clickHome();
		//Click dynamic fixed bundle
		bundlePage.clickDynamicFixedBundle();
		//Step 1 Add product
		bundlePage.clickAddButton();
		//Click next Button
		bundlePage.clickNextButton();
		//Step 2 Add product
	    bundlePage.clickAddButton1();
	    //Increase Quantity
	    bundlePage.clickPlusButton();
	  //Increase Quantity
	    bundlePage.clickPlusButton();
	    //Get Fixed Bundle Price
	    String price=bundlePage.checkPrice();
		System.out.println(price);
		//Assert review your order price 
		Assert.assertTrue(price.contains("199"));
}
}