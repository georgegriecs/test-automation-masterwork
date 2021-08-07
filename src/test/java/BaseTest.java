import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class BaseTest {
  protected static WebDriver driver = null;
  protected static WebDriverWait wait = null;
  protected static JavascriptExecutor js = null;
  protected final Logger LOG = LoggerFactory.getLogger( BaseTest.class);
  private static Properties props = new Properties();


  @BeforeAll
  public static void setup() throws IOException {
    /*
    Properties properties = new Properties();
    InputStream propertiesResourceAsStream = BaseTest.class.getResourceAsStream( "/browser.properties");
    properties.load(propertiesResourceAsStream);
*/
    WebDriverManager.chromedriver().setup();

    ChromeOptions chromeOptions = new ChromeOptions();
    //chromeOptions.addArguments(props.getProperty("chrome.arguments"));

    driver = new ChromeDriver(chromeOptions);
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    wait = new WebDriverWait( driver, 10 );
    js = (JavascriptExecutor)driver;
  }
  @AfterAll
  public static void cleanup() {
    driver.quit();
  }

  @Attachment("Screenshot")
  public byte[] makeScreenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
}
