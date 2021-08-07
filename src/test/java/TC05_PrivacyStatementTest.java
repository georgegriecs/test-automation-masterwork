import org.junit.jupiter.api.Test;
import pages.AccountLoginPage;
import pages.HomePage;
import pages.RegisterAccountPage;
import static org.assertj.core.api.Assertions.assertThat;

public class TC05_PrivacyStatementTest extends BaseTest {

  private HomePage homepage = null;
  private AccountLoginPage accountLoginPage = null;
  private RegisterAccountPage registerAccountPage = null;

  @Test
  public void privacyStatementTest() throws InterruptedException {

    homepage = new HomePage(driver);
    accountLoginPage = new AccountLoginPage(driver);
    registerAccountPage = new RegisterAccountPage(driver);

    navigateToRegisterAccountPage();
    makeScreenshot();
    LOG.info("Taken a screenshot");
    registerAccountPage.openPrivacyPolicy();
    makeScreenshot();
    LOG.info("Taken a screenshot");
    assertThat(registerAccountPage.getPrivacyPolicyModalText()).isEqualTo("Privacy Policy");
    registerAccountPage.closePrivacyPolicyModalForm();
    makeScreenshot();
    LOG.info("Taken a screenshot");
    registerAccountPage.clickToPrivacyPolicyCheckBox();
    makeScreenshot();
    LOG.info("Taken a screenshot");
    assertThat( registerAccountPage.getPrivacyPolicyState() ).isTrue();
  }

  private void navigateToRegisterAccountPage() {
    homepage.open();
    makeScreenshot();
    LOG.info("Taken a screenshot");
    homepage.clickToMyAccountLink();
    LOG.info("Load account login page");
    makeScreenshot();
    LOG.info("Take a screenshot");
    accountLoginPage.clickToNewCustomerButton();
    LOG.info("Click to New Customer Continue button");
  }
}
