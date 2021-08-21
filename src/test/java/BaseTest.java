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
import pages.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class BaseTest {
  protected static WebDriver driver = null;
  protected static WebDriverWait wait = null;
  protected static JavascriptExecutor js = null;
  protected final Logger LOG = LoggerFactory.getLogger( BaseTest.class);
  private static Properties props = new Properties();
  protected final String REGISTRATED_EMAIL = "test_35306163@test.hu";
  protected final String REGISTRATED_PASSWORD = "test_psw";
  protected final String UNSUCCESSFUL_REGISTRATION_MESSAGE = "Warning: E-Mail Address is already registered!";
  protected final String WARNING_MESSAGE_NO_MATCH_EMAIL_PASSWORD = "Warning: No match for E-Mail Address and/or Password.";

  AccountLoginPage accountLoginPage = new AccountLoginPage(driver);
  AddAddressPage addAddressPage = new AddAddressPage(driver);
  AddressBookEntriesPage addressBookEntriesPage = new AddressBookEntriesPage(driver);
  AddressBookPage addressBookPage = new AddressBookPage(driver);
  DesktopPage desktopPage = new DesktopPage(driver);
  EditAddressPage editAddressPage = new EditAddressPage(driver);
  HomePage homepage = new HomePage(driver);
  LoginPage loginPage = new LoginPage(driver);
  LogoutPage logoutPage = new LogoutPage(driver);
  PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
  RegisterAccountPage registerAccountPage = new RegisterAccountPage(driver);


  @BeforeAll
  public static void setup() throws IOException {
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

  @Attachment("Screenshot")
  public byte[] makeScreenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
}
