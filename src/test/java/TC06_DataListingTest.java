import static org.assertj.core.api.Assertions.assertThat;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import java.util.Collections;
import java.util.List;

@Epic("Customer administration processes in YourStore web app")
@Feature("Product data listing")
@Story("Listing all data in order by price")
public class TC06_DataListingTest extends BaseTest {

  @Test
  @DisplayName("")
  public void dataListingTest() {
    homepage.open();
    makeScreenshot();
    LOG.info("Taken a screenshot");
    homepage.showAllDesktop();
    LOG.info("Show all desktop");
    desktopPage.setSortByCategory("Price (Low > High)");
    LOG.info("Sort by price");
    desktopPage.setShowProductQuantity("100");
    LOG.info("Show all product");
    List<WebElement> productList = desktopPage.getProductList();
    LOG.info( "Product quantity: " + productList.size() );
    List<Float> originList = desktopPage.getFloatPriceList();
    LOG.info("Get origin price list");
    List<Float> sortedList = desktopPage.getFloatPriceList();
    Collections.sort(sortedList);
    LOG.info("Get sorted price list");
    assertThat(originList).containsExactlyElementsOf(sortedList);
    LOG.info("Does the order of the two arrays matches?");
  }
}
