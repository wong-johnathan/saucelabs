import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import java.net.URL;


public class BrokenSauce {

  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

  public static void main(String[] args) throws Exception {

	/**
	* Run this test before working on the problem.
        * When you view the results on your dashboard, you'll see that the test "Failed".
	* Your job is to figure out why the test failed and make the changes necessary to make the test pass.
	*
	* Bonus: Once you get the test working, update the code so that when the test runs, it 
	* can reach the Sauce Labs homepage 
	* and then open the Docs page
	*/

    DesiredCapabilities caps = DesiredCapabilities.chrome();
    caps.setCapability("platform", "Windows 7");
    caps.setCapability("browserName", "chrome");
    caps.setCapability("version", "48");
    caps.setCapability("name", "Broken Google Search");

    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    driver.get("www.google.com/");
    WebElement search = driver.findElement(By.name("Search"));

    search.sendKeys("Sauce Labs");
    search.submit();

    WebElement page = driver.findElement(By.partialLinkText("Sauce"));

    driver.quit();
  }
}
