import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.comparable;


public class TC13_LogoutTest extends BaseTest {
  private HomePage homepage = null;
  private AccountLoginPage accountLoginPage = null;
  private AddAddressPage addAddressPage = null;
  private LogoutPage logoutPage = null;

  public TC13_LogoutTest() {
  }
  @Test
  public void logoutTest() throws InterruptedException {

    homepage = new HomePage(driver);
    accountLoginPage = new AccountLoginPage(driver);
    addAddressPage = new AddAddressPage(driver);
    logoutPage = new LogoutPage(driver);

    homepage.open();
    makeScreenshot();
    LOG.info("Taken a screenshot");
    homepage.clickToMyAccountLink();
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
