package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.*;

public class HomePage extends BasePage {

  final String baseUrl = "http://test-automation-shop2.greenfox.academy/";

  @FindBy(xpath = "//input[@name=\"search\"]")
  WebElement searchField;

  @FindBy(xpath = "//div[@id=\"top-links\"]//a[@title=\"My Account\"]")
  WebElement myAccount;

  @FindBy(xpath = "//footer//a[text()=\"My Account\"]")
  WebElement myAccountFromFooter;

  public HomePage(WebDriver driver) {
    super(driver, HomePage.class);
  }

  public void open() {
    driver.get(baseUrl);
    LOG.info("Open homepage!");
    assertThat(driver.getTitle()).isEqualTo("Your Store");
    LOG.info("Your Store downloaded !");
  }

  public boolean isLoaded() {
    return isLoaded(myAccountFromFooter);
  }

  public void clickToMyAccountLink() {
    myAccountFromFooter.click();
  }
}
