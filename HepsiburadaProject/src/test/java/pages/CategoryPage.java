package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class CategoryPage {
    WebDriver driver;


    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//a[@title='Apple Tablet']")
    private WebElement brandFilter;

    @FindBy(xpath = "//a[@title='Apple 13,2 inç Tablet']")
    private WebElement screenSizeFilter;

    @FindBy(xpath = "//div[@class='price-R57b2z0LFOTTCaDIKTgo']")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//span[@id='shoppingCart']")
    private WebElement shoppingCart;





    public void applyFilters() {
        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.visibilityOf(shoppingCart));

        new WebDriverWait(driver, Duration.ofSeconds(500))
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));


        Driver.reloadPage();

        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.visibilityOf(shoppingCart));

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        // Marka filtresini uygula

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(brandFilter))
                        .click();

        Driver.reloadPage();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));


        // Ekran boyutu filtresini uygula
        // Elemente scroll yap
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", screenSizeFilter);

        // Elementin tıklanabilir olmasını bekle
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(screenSizeFilter));

        // Elemente tıkla
        screenSizeFilter.click();

        Driver.reloadPage();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));



    }




    public WebElement findHighestPricedProduct() {
        WebElement highestPricedProduct = null;
        double maxPrice = 0;

        for (WebElement priceElement : productPrices) {
            // Fiyatı al ve sayısal değere dönüştür
            String priceText = priceElement.getText().replaceAll("[^0-9.,]", "").replace(",", ".");
            double price = Double.parseDouble(priceText);

            // En yüksek fiyatı bul
            if (price > maxPrice) {
                maxPrice = price;
                highestPricedProduct = priceElement;
            }
        }

        return highestPricedProduct;
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickHighestPricedProduct() {
        WebElement highestPricedProduct = findHighestPricedProduct();
        if (highestPricedProduct != null) {
            scrollToElement(highestPricedProduct); // Ekranı ürüne kaydır
            highestPricedProduct.click(); // Ürüne tıkla
        } else {
            throw new RuntimeException("En yüksek fiyatlı ürün bulunamadı!");
        }
    }
}
