package selenium;

 

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



 public class SimpleTest {
	
	 public WebDriver driver;
	 public String browser = "chrome";  
	 public  String hubAddress = "http://localhost:4444/wd/hub";
	 
  @Test
  public void sometest() throws MalformedURLException {
	  
	  
    //http://www.seleniumhq.org/download/maven.jsp
    //https://code.google.com/p/selenium/wiki/GettingStarted
    // WebDriver driver = Browser.launch(options);
    DesiredCapabilities caps = new DesiredCapabilities();
    System.setProperty("webdriver.chrome.driver", System.getProperty("driverpath"));
    caps.setCapability("browserName", "googlechrome");
    caps.setCapability("browserVersion", "latest");
    String sauceUrl = "http://localhost:4444/wd/hub";
    URL url = new URL(sauceUrl);
    driver = new RemoteWebDriver(url, caps);
    driver.get("https://www.google.com");
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("Cheese!");
    element.submit();
    System.out.println("Page title is: " + driver.getTitle());
    driver.quit();
  }
  
}
