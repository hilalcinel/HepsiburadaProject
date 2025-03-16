package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@data-test-id='price-current-price']")
    private WebElement productPrice;

    @FindBy(xpath = "//div[text()='Sepete ekle']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@id='shoppingCart']")
    private WebElement shoppingCart;

    public String getProductPrice() {
        // Ürün fiyatını al
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(productPrice))
                .getText();
    }

    public void addToCart() {
        // Sepete ekle butonuna tıkla
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addToCartButton))
                .click();
    }

    public void goToCart() {

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.invisibilityOf(addToCartButton));


        // Elemente scroll yap
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", shoppingCart);

        // Elementin tıklanabilir olmasını bekle
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCart));


        shoppingCart.click();


    }
}