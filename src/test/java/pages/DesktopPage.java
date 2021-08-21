package pages;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

  @FindBy ( xpath = "//div[@class=\"caption\"]/h4")
  List<WebElement> productNames;

  @FindBy ( xpath = "//ul[@class=\"pagination\"]//li[@class=\"active\"]//span")
  WebElement activePageNumber;

  @FindBy( xpath = "//ul[@class=\"pagination\"]//a[text()=\">\"]" )
  WebElement stepToNextPage;

  @FindBy( xpath = "//ul[@class=\"pagination\"]//a[text()=\"<\"]" )
  WebElement stepToPreviousPage;

  @FindBy( xpath = "//*[@id=\"content\"]/div[5]/div[2]" )
  WebElement showingPagesText;

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

  public List<String> getProductNames() {
    List<String> resultList = new ArrayList<>();
    for (WebElement product : productNames) {
      resultList.add(product.getText());
    }
    return resultList;
  }

  public List<String> getDataLines() {
    List<String> resultList = new ArrayList<>();
    List<Float> prices = getFloatPriceList();
    List<String> names = getProductNames();
    for (int i = 0; i < prices.size(); i++) {
      resultList.add( names.get(i) + ";" + prices.get(i));
    }
    return resultList;
  }

  public String getActivePageNumber() {
    return activePageNumber.getText();
  }

  public void stepToNextPage() {
    stepToNextPage.click();
    wait.until(ExpectedConditions.visibilityOf(showingPagesText));
  }

  public void stepPreviousPage() {
    stepToPreviousPage.click();
  }

  public void waitForAllProductVisibility(){
    wait.until(ExpectedConditions.visibilityOfAllElements(pricesTax));
  }

}

