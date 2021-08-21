import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Customer administration processes in YourStore web app")
@Feature("Product data listing")
@Story("Navigate to between next and previous page ")
public class TC07_PaginationTest extends BaseTest {

  @Test
  @DisplayName("")
  public void paginationTest (){

    homepage.open();
    makeScreenshot();
    LOG.info("Taken a screenshot");
    homepage.showAllDesktop();
    desktopPage.waitForAllProductVisibility();
    LOG.info("Show all desktop");
    LOG.info("Active page: " + desktopPage.getActivePageNumber());
    assertThat(desktopPage.getActivePageNumber()).isEqualTo("1");
    desktopPage.stepToNextPage();
    LOG.info("Active page: " + desktopPage.getActivePageNumber());
    assertThat(desktopPage.getActivePageNumber()).isEqualTo("2");
    desktopPage.stepPreviousPage();
    LOG.info("Active page: " + desktopPage.getActivePageNumber());
    assertThat(desktopPage.getActivePageNumber()).isEqualTo("1");
  }
}
