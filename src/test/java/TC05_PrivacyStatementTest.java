import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.AccountLoginPage;
import pages.HomePage;
import pages.RegisterAccountPage;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Customer administration processes in YourStore web app")
@Feature("Customer registration")
@Story("Open privacy statement and set checkbox")
public class TC05_PrivacyStatementTest extends BaseTest {

  @Test
  public void privacyStatementTest() throws InterruptedException {
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
    homepage.openAccountLoginPage();
    LOG.info("Load account login page");
    makeScreenshot();
    LOG.info("Take a screenshot");
    accountLoginPage.clickToNewCustomerButton();
    LOG.info("Click to New Customer Continue button");
  }
}
