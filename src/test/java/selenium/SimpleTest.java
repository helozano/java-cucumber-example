package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver.Options;

import support.Browser;

public class SimpleTest {

  @Test
  public void sometest() {
    chrome_options = Options();
    chrome_options.add_argument("--headless");
    chrome_options.add_argument("--no-sandbox");
    chrome_options.add_argument("--disable-dev-shm-usage");
    System.setProperty("webdriver.chrome.driver", System.getProperty("driverpath"));
    WebDriver driver = new ChromeDriver(chrome_options=chrome_options);
    driver.get("https://www.google.com");
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("Cheese!");
    element.submit();
    System.out.println("Page title is: " + driver.getTitle());
    driver.quit();
  }
  
}
