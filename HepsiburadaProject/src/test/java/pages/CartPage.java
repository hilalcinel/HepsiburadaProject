package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='product_price_uXU6Q']")
    private WebElement cartProductPrice;




    @FindBy(xpath = "//input[@id='selectedCheckBox']")
    private WebElement cartProductName;

    public boolean isProductAdded() {
        // Ürünün sepete eklendiğini doğrula
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(cartProductName))
                .isDisplayed();
    }

    public String getCartProductPrice() {
        // Sepetteki ürün fiyatını al
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(cartProductPrice))
                .getText();
    }
}
