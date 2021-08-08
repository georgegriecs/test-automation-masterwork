package pages;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends BasePage {

  @FindBy(id = "input-sort")
  WebElement sortSelectComponent;

  @FindBy(id = "input-limit")
  WebElement showQuantitySelectComponent;

  @FindBy(className = "price-tax")
  List<WebElement> pricesTax;

  @FindBy (className = "product-layout")
  WebElement productLayout;

  public DesktopPage(WebDriver driver) {
    super(driver, DesktopPage.class);
  }

  public void setSortByCategory( String category ) {
    Select selectedCategory = new Select(sortSelectComponent);
    selectedCategory.selectByVisibleText(category);
  }

  public void setShowProductQuantity(String category) {
    Select selectedCategory = new Select(showQuantitySelectComponent);
    selectedCategory.selectByVisibleText(category);
  }

  public List<WebElement> getProductList() {
    return driver.findElements(By.className("product-layout"));
  }

  public List<Float> getFloatPriceList() {
    List<Float> resultList = new ArrayList<>();
    for (WebElement price : pricesTax) {
      Float priceFloat = Float.parseFloat(price.getText().substring(9).replace(",",""));
      resultList.add(priceFloat);
    }
    return resultList;
  }
}

