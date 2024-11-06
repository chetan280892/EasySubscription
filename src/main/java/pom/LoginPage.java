
  package pom;
  
  import org.openqa.selenium.WebDriver; 
  import org.openqa.selenium.WebElement; import org.openqa.selenium.support.FindBy;
  import org.openqa.selenium.support.PageFactory;
  
  public class LoginPage { 
  @FindBy(xpath="//a[@class='header__icon header__icon--account link focus-inset small-hide']") private WebElement account;
  @FindBy(xpath="//input[@id='CustomerEmail']") private WebElement email;
  @FindBy(xpath="//input[@id='CustomerPassword']") private WebElement password;
  @FindBy(xpath="//button[contains(text(),'Sign')]") private WebElement signIn;
  @FindBy(xpath="//a[@href='#recover']") private WebElement forgotPassword;
  @FindBy(xpath="//a[@href='/account/logout']") private WebElement logout;
  @FindBy(xpath="//li[text()='Incorrect email or password.']") private WebElement errorMsg;
  @FindBy(xpath="//input[@id='RecoverEmail']") private WebElement recoverMail;
  @FindBy(xpath="//button[contains(text(),'Submit')]") private WebElement submit;
  @FindBy(xpath="//h3[@class='form__message']") private WebElement updatePasswordMsg;
  @FindBy(xpath="//a[contains(@href,'/account/register')]") private WebElement createAccount;
  @FindBy(xpath="//input[@id='RegisterForm-FirstName']") private WebElement createAccountFirstName;
  @FindBy(xpath="//input[@id='RegisterForm-LastName']") private WebElement createAccountLastName;
  @FindBy(xpath="//input[@id='RegisterForm-email']") private WebElement createAccountEmail;
  @FindBy(xpath="//input[@id='RegisterForm-password']") private WebElement createAccountPassword;
  @FindBy(xpath="//button[contains(text(),'Create')]") private WebElement createButton;
  @FindBy(xpath="//li[contains(text(),'This email address is already associated')]") private WebElement alreadyAccount;
  @FindBy(xpath="//a[@href='#RegisterForm-email']") private WebElement blankMsg;
  public LoginPage(WebDriver driver) { 
  PageFactory.initElements(driver, this); } 
  
  public void clickAccount() {
  account.click(); }
  
  public void enterEmail(String emailInput) { 
	  email.sendKeys(emailInput); 
	  }
  public void enterPassword(String passwordInput) {
  password.sendKeys(passwordInput); 
  }
  public void clickSign() { 
	  signIn.click();
  }
  public String logoutButton() {
	return  logout.getText();
  }
  public String getErrorMsg() {
	return  errorMsg.getText();
  }
  public void clickForgotPassword() {
	  forgotPassword.click();
  }
  public void enterRecoverEmail(String recoverEmail1) {
	  recoverMail.sendKeys(recoverEmail1);
  }
  public void clickSubmitButton() {
	  submit.click();
  }
  public String emailSentMsg() {
	  return  updatePasswordMsg.getText();
  }
  public void clickCreateAccount() {
	  createAccount.click();
  }
  public void enterFirstName(String firstname) {
	  createAccountFirstName.sendKeys(firstname);
  }
  public void enterLastName(String lastname) {
	  createAccountLastName.sendKeys(lastname);
  }
  public void enterCreateAccountEmail(String email) {
	  createAccountEmail.sendKeys(email);
  }
  public void enterCreateAccountPassword(String password) {
	  createAccountPassword.sendKeys(password);
  }
  public void clickCreateButton() {
	  createButton.click();
  }
  public String alreadyAccountMsg() {
	  return  alreadyAccount.getText();
  }
  public String blankFieldMsg() {
	  return  blankMsg.getText();
  }
}
  