package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {
	
	public static WebDriver launchBrowser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://esa-indore-4.myshopify.com/?_bt=eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaEpJaDlsYzJFdGFXNWtiM0psTFRRdWJYbHphRzl3YVdaNUxtTnZiUVk2QmtWVSIsImV4cCI6IjIwMjQtMTEtMThUMTA6Mjc6MDkuODU2WiIsInB1ciI6InBlcm1hbmVudF9wYXNzd29yZF9ieXBhc3MifX0%3D--7ff10e1c28c3851770fec719738c8580717806a9");
		return driver;
	}
}
