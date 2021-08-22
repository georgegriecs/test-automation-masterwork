package pages;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BasePage {
  protected final WebDriver driver;
  protected final WebDriverWait wait;
  protected final Logger LOG;
  protected final Actions action;

  public BasePage( WebDriver driver, Class cls) {
    this.driver = driver;
    this.wait = new WebDriverWait( driver, 10 );
    this.LOG = LoggerFactory.getLogger(cls);
    this.action = new Actions(driver);
    PageFactory.initElements(driver, this);
  }

  public boolean isLoaded(By by) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
  }

  public boolean isLoaded( WebElement element ) {
    return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
  }

  @Attachment("Screenshot")
  public byte[] makeScreenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
}
