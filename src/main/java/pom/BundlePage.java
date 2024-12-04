package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BundlePage {
	@FindBy(xpath="//a[@class='header__icon header__icon--account link focus-inset small-hide']") private WebElement account;
	  @FindBy(xpath="//input[@id='CustomerEmail']") private WebElement email;
	  @FindBy(xpath="//input[@id='CustomerPassword']") private WebElement password;
	  @FindBy(xpath="//button[contains(text(),'Sign')]") private WebElement signIn;
	  @FindBy(xpath="//a[@id='HeaderMenu-home']") private WebElement home;
	  @FindBy(xpath="(//a[contains(text(),'Automation Fixed Bundle')][1])") private WebElement fixedBundle;
	  @FindBy(xpath="(//a[contains(text(),'Automation Dynamic Fixed Bundle')][1])") private WebElement dynamicFixedBundle;
	  @FindBy(xpath="//h5[@class='widget_heading']") private WebElement bundleLanguage;
	  @FindBy(xpath="//div[@class='Fixed_bundle']") private WebElement bundleContent;
	  @FindBy(xpath="(//button[@class='add_button'])[1]") private WebElement addButton1;
	  @FindBy(xpath="(//button[@class='add_button'])[2]") private WebElement addButton2;
	  @FindBy(xpath="//button[@class='nxt_btn']") private WebElement nextButton;
	  @FindBy(xpath="(//button[@class='esb_quantity__button right_btn'])[2]") private WebElement plusButton;
	  @FindBy(xpath="(//button[@class='esb_quantity__button right_btn'])[2]") private WebElement Button;
	  @FindBy(xpath="//button[@class='checkout_btn']") private WebElement reviewYourOrderButton;
	  public BundlePage(WebDriver driver) { 
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
		  public void clickHome() { 
			  home.click();
		   }
		  public void clickFixedBundle() { 
			  fixedBundle.click();
		   }
		  public String checkLanguage() {
				return  bundleLanguage.getText();
			  }
		  public String checkContent() {
				return  bundleContent.getText();
			  }
		  public void clickDynamicFixedBundle() { 
			  dynamicFixedBundle.click();
		   }
		  public void clickAddButton() { 
			  addButton1.click();
		   }
		  public void clickNextButton() { 
			  nextButton.click();
		   }
		  public void clickAddButton1() { 
			  addButton2.click();
		   }
		  public void clickPlusButton() { 
			  plusButton.click();
		   }
		  public String checkPrice() {
				return  reviewYourOrderButton.getText();
			  }
}
