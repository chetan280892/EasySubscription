package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {
	
	public static WebDriver launchBrowser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://esa-indore-4.myshopify.com/?_bt=eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaEpJaDlsYzJFdGFXNWtiM0psTFRRdWJYbHphRzl3YVdaNUxtTnZiUVk2QmtWVSIsImV4cCI6IjIwMjQtMTEtMDVUMTU6MTE6MzYuNTkyWiIsInB1ciI6InBlcm1hbmVudF9wYXNzd29yZF9ieXBhc3MifX0%3D--b2345b4504ced73b14547f9a7738bf64fec96001");
		return driver;
	}
}
