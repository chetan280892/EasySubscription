package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.OpenBrowser;
import pom.LoginPage;

public class LoginPageTest extends BaseTest{
@BeforeMethod
	public void launchBrowser() {
		driver=OpenBrowser.launchBrowser();
	}
	@Test(priority=0)
	public void loginWithValidCredentials() {
		LoginPage loginPage=new LoginPage(driver);
		// Click on the "Account" button to open the login form
		loginPage.clickAccount();
		// Enter valid email for login
		loginPage.enterEmail("automationtesting@gmail.com");
		// Enter valid password for login
		loginPage.enterPassword("123456789");
		// Click on the "Sign In" button to initiate the login process
		loginPage.clickSign();
		// Retrieve the text or element indicating the presence of the "Log out" button
		String logout1=loginPage.logoutButton();
		// Assert that the "Log out" button is displayed, indicating successful login
		Assert.assertTrue(logout1.contains("Log out"));
	}
	@Test(priority=1)
	public void loginWithInValidCredentials() {
		LoginPage loginPage=new LoginPage(driver);
		// Click on the "Account" button to open account settings
		loginPage.clickAccount();
		// Enter valid email for login
		loginPage.enterEmail("automationtesting@gmail.com");
		// Enter an invalid password for login (this is expected to fail)
		loginPage.enterPassword("123456");
		// Click on the "Sign In" button to attempt logging in with invalid credentials
		loginPage.clickSign();
		// Retrieve the error message displayed after the failed login attempt
		String error=loginPage.getErrorMsg();
		// Assert that the error message matches the expected message for incorrect credentials
		Assert.assertEquals(error,"Incorrect email or password.");
	}
	@Test(priority=2)
	public void loginWithBlankCredentials() {
		LoginPage loginPage=new LoginPage(driver);
		// Click on the "Account" button to open account settings
		loginPage.clickAccount();
		// Click on the "Sign In" button without entering any credentials (blank credentials)
		loginPage.clickSign();
		// Retrieve the error message displayed after attempting to log in with blank credentials
		String blank=loginPage.getErrorMsg();
		 // Assert that the error message matches the expected message for blank login fields
		Assert.assertEquals(blank,"Incorrect email or password.");
	}
	@Test(priority=3)
	public void forgotYourPassword() {
		LoginPage loginPage=new LoginPage(driver);
		// Click on the "Account" button to open account settings
		loginPage.clickAccount();
		//Click on forgot password
        loginPage.clickForgotPassword();
        //Enter Email
        loginPage.enterRecoverEmail("automationtesting@gmail");
     // Enter the email address for password recovery
        loginPage.clickSubmitButton();
     // Retrieve the message confirming that a password reset email has been sent
        String emailSent=loginPage.emailSentMsg();
     // Assert that the confirmation message contains the expected text indicating the email was sent
        Assert.assertTrue(emailSent.contains("sent you an email with a link to update your password"));
	}
	@Test(priority=4)
	public void alreadyAccountCreated() {
		LoginPage loginPage=new LoginPage(driver);
		//Click on Account button
		loginPage.clickAccount();
		//Click on create account button
		loginPage.clickCreateAccount();
		//Enter First name
		loginPage.enterFirstName("chetan");
		//Enter Last Name
		loginPage.enterLastName("patidar");
		// Enter an email address that is already associated with an existing account
		loginPage.enterCreateAccountEmail("automationtesting@gmail.com");
		// Enter a password for the new account (though the email is already in use)
		loginPage.enterCreateAccountPassword("123456789");
		//Click on create button
		loginPage.clickCreateButton();
		// Retrieve the error message indicating that the email address is already associated with an account
		String already=loginPage.alreadyAccountMsg();
		// Assert that the error message contains the expected text for an already existing account
		Assert.assertTrue(already.contains("This email address is already associated with an account."));
	}
	@Test(priority=5)
	public void createAccountBlankCredentials() {
		LoginPage loginPage=new LoginPage(driver);
		// Click on the "Account" button to open the login or account creation screen
		loginPage.clickAccount();
		// Click on the "Create Account" button to start the account registration process
		loginPage.clickCreateAccount();
		// Click on the "Create" button without entering any credentials (email, name, or password)
		loginPage.clickCreateButton();
		// Retrieve the error message displayed for the blank email field
		String blank=loginPage.blankFieldMsg();
		// Assert that the error message indicates that the email field cannot be blank
		Assert.assertTrue(blank.contains("Email can't be blank"));
	}
}
