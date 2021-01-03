package testNg;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class TestNgTestOne {
	
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	//Setting up the chrome driver exe, the second argument is the location where you have kept the driver in your system
	  System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
	  
	//Setting the driver to chrome driver
	driver = new ChromeDriver();
	String url = "https://www.youtube.com";
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(4000);
	
	// click on the first pop up
	driver.findElement(By.xpath("/html/body/ytd-app/ytd-popup-container/paper-dialog/yt-upsell-dialog-renderer/div/div[3]/div[1]/yt-button-renderer/a/paper-button/yt-formatted-string")).click();
	// click on the first pop up
	Thread.sleep(2000);
	driver.switchTo().frame(0);
	
	// click on the second pop up
	driver.findElement(By.xpath("/html/body/div/c-wiz/div[2]/div/div/div/div/div[2]/form/div/span/span")).click();
	Thread.sleep(2000);
	driver.switchTo().parentFrame();
	
	// searching for the first video uploaded to youtube
	driver.findElement(By.name("search_query")).sendKeys("me at the zoo");
	Thread.sleep(2000);
	
	// click search
	driver.findElement(By.id("search-icon-legacy")).click();
	
	//Capturing the title and validating if expected is equal to actual  
	String expectedTitle = "Me at the zoo - Youtube";  
	String actualTitle = driver.getTitle();
	Thread.sleep(8000);       
	Assert.assertEquals(actualTitle, expectedTitle);
	
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Starting the browser session");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Closing the browser session");
	  driver.quit();
  }

}
