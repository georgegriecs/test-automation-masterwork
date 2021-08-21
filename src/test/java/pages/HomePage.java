package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.*;

public class HomePage extends BasePage {

  final String baseUrl = "http://test-automation-shop2.greenfox.academy/";

  @FindBy(xpath = "//input[@name=\"search\"]")
  WebElement searchField;

  @FindBy(xpath = "//div[@id=\"top-links\"]//a[@title=\"My Account\"]")
  WebElement myAccount;

  @FindBy(xpath = "//footer//a[text()=\"My Account\"]")
  WebElement myAccountFromFooter;

  @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
  WebElement menuDesktops;

  @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")
  WebElement menuShowAllDesktops;

  @FindBy( xpath = "//*[@id=\"content\"]/div[5]/div[2]" )
  WebElement pageCounterText;


  public HomePage(WebDriver driver) {
    super(driver, HomePage.class);
  }

  public void open() {
    driver.get(baseUrl);
    LOG.info("A weboldal megnyitása");
    assertThat(driver.getTitle()).isEqualTo("Your Store");
    makeScreenshot();
    LOG.info("Képernyőkép készítés");
  }

  public void openAccountLoginPage() {
    myAccountFromFooter.click();
    assertThat(driver.getTitle()).isEqualTo("Account Login");
    makeScreenshot();
    LOG.info("Képernyőkép készítés");
  }

  public boolean isLoaded() {
    return isLoaded(myAccountFromFooter);
  }


  public void waitForClickableDesktop() {
    wait.until(ExpectedConditions.elementToBeClickable(menuDesktops));
  }
  public void moveToDesktops() {  action.moveToElement(menuDesktops).perform(); }
  public void clickToAllDesktops() {
    menuShowAllDesktops.click();
  }

  public void showAllDesktop() {
    waitForClickableDesktop();
    moveToDesktops();
    makeScreenshot();
    LOG.info("Take a screenshot");
    clickToAllDesktops();
    makeScreenshot();
    LOG.info("Take a screenshot");
  }
}
