import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Customer administration processes in YourStore web app")
@Feature("Customer Login")
@Story("Unsuccessful login")
public class TC04_LoginUnsuccessful extends BaseTest {

  @Test
  @DisplayName("")
  public void loginUnsuccessful() {
    homepage.open();
    makeScreenshot();
    LOG.info("Taken a screenshot");
    homepage.openAccountLoginPage();
    LOG.info("Load account login page");
    makeScreenshot();
    LOG.info("Take a screenshot");
    accountLoginPage.loginReturningCustomer( REGISTRATED_EMAIL, REGISTRATED_PASSWORD + "_", false);
    assertThat( accountLoginPage.getWarningMessageNoMatchEmailOrPassword().getText()).isEqualTo(WARNING_MESSAGE_NO_MATCH_EMAIL_PASSWORD);
  }

}
