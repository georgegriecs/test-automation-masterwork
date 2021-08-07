import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountLoginPage;
import pages.HomePage;
import pages.RegisterAccountPage;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Customer administration processes in YourStore web app")
@Feature("Customer registration")
@Story("Unsuccessful registration")
public class TC02_UnsuccessfulRegistration  extends BaseTest {
  private HomePage homepage = null;
  private AccountLoginPage accountLoginPage = null;
  private RegisterAccountPage registerAccountPage = null;

  @Test
  public void successfulRegistration() {
    homepage = new HomePage(driver);
    accountLoginPage = new AccountLoginPage(driver);
    registerAccountPage = new RegisterAccountPage(driver);

    homepage.open();
    makeScreenshot();
    LOG.info("Taken a screenshot");
    homepage.clickToMyAccountLink();
    LOG.info("Load account login page");
    makeScreenshot();
    LOG.info("Take a screenshot");
    accountLoginPage.clickToNewCustomerButton();
    LOG.info("Click to New Customer Continue button");
    makeScreenshot();
    LOG.info("Take a screenshot");
    registerAccountPage.registerNewCustomer("test_fname", "test_lname", REGISTRATED_EMAIL, "+361234566", REGISTRATED_PASSWORD);
    makeScreenshot();
    LOG.info("Take a screenshot");
    assertThat(registerAccountPage.getWarningMessage()).isEqualTo(UNSUCCESSFUL_REGISTRATION_MESSAGE);
    LOG.info("Email already registered message!");
  }


}