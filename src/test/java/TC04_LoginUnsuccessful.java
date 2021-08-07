import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.AccountLoginPage;
import pages.HomePage;
import pages.RegisterAccountPage;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Customer administration processes in YourStore web app")
@Feature("Customer Login")
@Story("Unsuccessful login")
public class TC04_LoginUnsuccessful extends BaseTest {
  private HomePage homepage = null;
  private AccountLoginPage accountLoginPage = null;
  private RegisterAccountPage registerAccountPage = null;

  @Test
  public void loginSuccessful() {

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
    accountLoginPage.loginReturningCustomer( REGISTRATED_EMAIL, REGISTRATED_PASSWORD + "_");
    makeScreenshot();
    LOG.info("Take a screenshot");
    assertThat( accountLoginPage.getWarningMessageNoMatchEmailOrPassword().getText()).isEqualTo(WARNING_MESSAGE_NO_MATCH_EMAIL_PASSWORD);
  }

}
