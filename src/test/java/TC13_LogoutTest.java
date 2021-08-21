import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Epic("")
@Feature("")
@Story("")
public class TC13_LogoutTest extends BaseTest {

  @Test
  @DisplayName("")
  public void logoutTest() throws InterruptedException {
    homepage.open();
    makeScreenshot();
    LOG.info("Taken a screenshot");
    homepage.openAccountLoginPage();
    LOG.info("Load account login page");
    makeScreenshot();
    LOG.info("Take a screenshot");
    accountLoginPage.loginReturningCustomer( REGISTRATED_EMAIL, REGISTRATED_PASSWORD);
    makeScreenshot();
    LOG.info("Take a screenshot");
    addAddressPage.getLogoutMenu().click();
    makeScreenshot();
    LOG.info("Take a screenshot");
    wait.until(ExpectedConditions.elementToBeClickable(logoutPage.getContinueButton()));
    logoutPage.getContinueButton().click();
    makeScreenshot();
    LOG.info("Take a screenshot");
  }
}
