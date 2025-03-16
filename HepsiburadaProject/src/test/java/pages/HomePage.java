package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement acceptCookies;

    @FindBy(xpath = "//span[text()='Tüm Kategoriler']")
    private WebElement allCategories;

    @FindBy(xpath = "(//span[contains(text(),'Elektronik')])[1]")
    private WebElement electronicsCategory;

    @FindBy(xpath = "//a[normalize-space()='Bilgisayar/Tablet']")
    private WebElement computerTabletCategory;

    @FindBy(xpath = "//a[@title='Tablet']")
    private WebElement tabletCategory;

    @FindBy(xpath = "//span[@id='shoppingCart']")
    private WebElement shoppingCart;




    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform(); // Fareyi elementin üzerine getir
    }



    public void acceptCookiesAndWaitForPageLoad() {
        // Çerezleri kabul et
        //acceptCookies.click();

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(acceptCookies));
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(acceptCookies))
                .click();

        // Sayfanın tamamen yüklenmesini bekle
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void acceptCookies() {

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(acceptCookies));
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(acceptCookies))
                .click();



    }

    public void hoverOverElectronicsCategory() {


        // Elektronik kategorisinin görünür olmasını bekle
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(electronicsCategory));

        // Fareyi elektronik kategorisinin üzerine getir
        Actions actions = new Actions(driver);
        actions.moveToElement(electronicsCategory).perform();


    }

    public void clickComputerTabletCategory() {
        // Tablet kategorisinin görünür olmasını bekle
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(computerTabletCategory))
                .click();



    }

    public void clickTabletCategory(){

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));


        new WebDriverWait(driver, Duration.ofSeconds(50))
                .until(ExpectedConditions.visibilityOf(shoppingCart));




        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(tabletCategory));

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(tabletCategory))
                .click();

        acceptCookiesAndWaitForPageLoad();



    }

//    // Belirli bir elementin görünür olmasını bekler
//    public void clickElementAndWaitForPageLoad(WebElement elementLocator, WebElement elementToWaitFor) {
//        // Elemente tıkla
//
//
//        // Yeni sayfadaki bir elementin görünür olmasını bekle
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
//    }


}
