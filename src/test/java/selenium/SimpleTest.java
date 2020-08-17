package selenium;

 

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

 

import io.github.bonigarcia.wdm.WebDriverManager;

 

import support.Browser;

 

public class SimpleTest {

 

  @Test
  public void sometest() {
    //http://www.seleniumhq.org/download/maven.jsp
    //https://code.google.com/p/selenium/wiki/GettingStarted
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    //options.addArguments("--no-sandbox");
    options.addArguments("--headless"); 
    options.addArguments("--disable-gpu");
    //options.addArguments("--disable-dev-shm-usage");
    //options.addArguments("--remote-debugging-port=9222");
    System.setProperty("webdriver.chrome.driver", System.getProperty("driverpath"));
   // WebDriver driver = Browser.launch(options);
    WebDriver driver = new ChromeDriver(options);
    driver.get("https://www.google.com");
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("Cheese!");
    element.submit();
    System.out.println("Page title is: " + driver.getTitle());
    driver.quit();
  }
  
}
