import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountLoginPage;
import pages.HomePage;
import pages.RegisterAccountPage;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Customer administration processes in YourStore web app")
@Feature("Customer registration")
@Story("Successful registration")
public class TC01_SuccessfulRegistration  extends BaseTest {

  private final String SUCCESSFUL_REGISTRATION_MESSAGE = "Your Account Has Been Created!";

  @Test
  @DisplayName("")
  public void successfulRegistration() {
    homepage.open();

    homepage.openAccountLoginPage();
    LOG.info("Load account login page");
    makeScreenshot();
    LOG.info("Take a screenshot");
    accountLoginPage.clickToNewCustomerButton();
    LOG.info("Click to New Customer Continue button");
    makeScreenshot();
    LOG.info("Take a screenshot");
    registerAccountPage.registerNewCustomer( "test_fname", "test_lname", generateEmail(), "+361234566", REGISTRATED_PASSWORD );
    makeScreenshot();
    LOG.info("Take a screenshot");
    assertThat(driver.getTitle()).isEqualTo(SUCCESSFUL_REGISTRATION_MESSAGE);
    LOG.info("Verify successful registration: PASSED");
  }

  public String generateEmail() {
    return "test_" + ((int)( Math.random() * 100000000 )) + "@test.hu";
  }
}
