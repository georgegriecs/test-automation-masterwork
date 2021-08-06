package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BasePage {
  protected final WebDriver driver;
  protected final WebDriverWait wait;
  protected final Logger LOG;

  public BasePage( WebDriver driver, Class cls) {
    this.driver = driver;
    this.wait = new WebDriverWait( driver, 10 );
    this.LOG = LoggerFactory.getLogger(cls);
    PageFactory.initElements(driver, this);
  }

  public boolean isLoaded(By by) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
  }

  public boolean isLoaded( WebElement element ) {
    return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
  }
}
