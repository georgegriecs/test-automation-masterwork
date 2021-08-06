import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.groups.Properties;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
  protected static WebDriver driver = null;
  protected static WebDriverWait wait = null;
  protected static JavascriptExecutor js = null;
  protected static final Logger LOG = LoggerFactory.getLogger( BaseTest.class);


  @BeforeAll
  public static void setup() throws IOException {
    Properties properties = new Properties();
    //InputStream propertiesResourceAsStream = this.getClass().getResourceAsStream( "/browser.properties");
    //properties.load(propertiesResourceAsStream);

    WebDriverManager.chromedriver().setup();

    ChromeOptions chromeOptions = new ChromeOptions();

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

}
