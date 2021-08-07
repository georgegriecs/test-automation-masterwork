package pages;

import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.*;

public class HomePage extends BasePage {

  final String baseUrl = "http://test-automation-shop2.greenfox.academy/";

  public HomePage(WebDriver driver) {
    super(driver, HomePage.class);
  }

  public void open() {
    driver.get(baseUrl);
    LOG.info("Open homepage!");
    assertThat(driver.getTitle()).isEqualTo("Your Store");
    LOG.info("Your Store downloaded !");
  }




}
