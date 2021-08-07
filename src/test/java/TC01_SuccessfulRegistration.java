import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;


public class TC01_SuccessfulRegistration  extends BaseTest {
  private HomePage homepage;

  @Test
  public void successfulRegistration() {
    homepage = new HomePage(driver);
    homepage.open();
    makeScreenshot();
    LOG.info("Taken a screenshot");

  }

}
