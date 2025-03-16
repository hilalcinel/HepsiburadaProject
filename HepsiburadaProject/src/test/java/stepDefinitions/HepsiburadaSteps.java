package stepDefinitions;

import io.cucumber.java.Before;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import pages.*;
import utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HepsiburadaSteps {

    HomePage homePage = new HomePage(Driver.getDriver());
    CategoryPage categoryPage = new CategoryPage(Driver.getDriver());
    ProductPage productPage = new ProductPage(Driver.getDriver());
    CartPage cartPage = new CartPage(Driver.getDriver());

    String productPrice;


    @Given("Kullanici Hepsiburada ana sayfasina gider")
    public void kullaniciHepsiburadaAnaSayfasinaGider() {
        Driver.getDriver().get("https://www.hepsiburada.com/");
    }


    @When("Kullanici Tablet kategorisine gider")
    public void kullaniciTabletKategorisineGider() {

        //homePage.acceptCookies();
        homePage.hoverOverElectronicsCategory();
        homePage.clickComputerTabletCategory();
        homePage.clickTabletCategory();


    }

    @And("Kullanici filtreleri uygular")
    public void kullaniciFiltreleriUygular() {
        categoryPage.applyFilters();
    }

    @And("Kullanici en yuksek fiyatli urunu secer")
    public void kullaniciEnYuksekFiyatliUrunuSecer() {

        categoryPage.scrollToElement(categoryPage.findHighestPricedProduct());
        categoryPage.clickHighestPricedProduct();

    }

    @And("Kullanici urunu sepete ekler")
    public void kullaniciUrunuSepeteEkler() {
        productPage.addToCart();
        productPrice = productPage.getProductPrice();
        productPage.goToCart();
    }

    @Then("Kullanici urunun sepete eklendigini dogrular")
    public void kullaniciUrununSepeteEklendiginiDogrular() {
        Assert.assertTrue(cartPage.isProductAdded(), "Ürün sepete eklenemedi!");
        Assert.assertEquals(cartPage.getCartProductPrice(), productPrice, "Ürün fiyatı eşleşmiyor!");

        Assert.assertEquals("","");
    }
}
