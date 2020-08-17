package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeOptions
import support.Browser;

public class SimpleTest {

  @Test
  public void sometest() {
    //ChromeDriverManager.getInstance().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.add_argument("--no-sandbox");
    chromeOptions.addArguments("--headless");
    System.setProperty("webdriver.chrome.driver", System.getProperty("driverpath"));
    WebDriver driver = new ChromeDriver(chrome_options=chromeOptions);
    driver.get("https://www.google.com");
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("Cheese!");
    element.submit();
    System.out.println("Page title is: " + driver.getTitle());
    driver.quit();
  }
  
}
