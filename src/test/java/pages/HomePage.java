package pages;

import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.*;

public class HomePage extends BasePage {

  public static final baseUrl = "http://test-automation-shop2.greenfox.academy/";

  public HomePage(WebDriver driver) {
    super(driver, LoginPage.class);
  }

  public void openHomePage() {
    driver.get("http://test-automation-shop2.greenfox.academy/");
    LOG.info("Open homepage!");
    assertThat(driver.getTitle()).isEqualTo("Your Store");
    LOG.info("Your Store downloaded !");
  }


}
