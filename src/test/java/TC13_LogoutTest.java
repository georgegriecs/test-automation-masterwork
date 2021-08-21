import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Epic("Your Store online webaruhaz felhasznaloinak kezelese")
@Feature("Kilepes a webaruhazbol")
@Story("Belepes majd kilepes a webaruhazba")
public class TC13_LogoutTest extends BaseTest {

  @Test
  @Description("Sikeres belepes utan kilepunk a webaruhazbol")
  public void logoutTest() throws InterruptedException {
    homepage.open();
    LOG.info("A homepage betoltodott");
    homepage.openAccountLoginPage();
    LOG.info("A login page betoltodott");
    accountLoginPage.loginReturningCustomer( REGISTRATED_EMAIL, REGISTRATED_PASSWORD, true);
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    addAddressPage.getLogoutMenu().click();
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    wait.until(ExpectedConditions.elementToBeClickable(logoutPage.getContinueButton()));
    logoutPage.getContinueButton().click();
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
  }
}
