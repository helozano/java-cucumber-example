package selenium;

 

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

String browser = "chrome";
public static String hubAddress = "http://localhost:4444/wd/hub

 public class SimpleTest {
  @Test
  public void sometest() {
    //http://www.seleniumhq.org/download/maven.jsp
    //https://code.google.com/p/selenium/wiki/GettingStarted
    // WebDriver driver = Browser.launch(options);
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(ChromeOptions.CAPABILITY,  chromeOpts);
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
