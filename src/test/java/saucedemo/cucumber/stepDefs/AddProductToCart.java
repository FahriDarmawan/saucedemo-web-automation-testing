package saucedemo.cucumber.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddProductToCart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User already on Product Page")
    public void userAlreadyOnProductPage() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Assertion
        String productPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(productPageAssert, "Products");
    }

    @When("User click button Add to Cart")
    public void userClickButtonAddToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("User click the cart icon button")
    public void userClickTheCartIconButton() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("User will be redirected to Cart Page")
    public void userWillBeRedirectedToCartPage() {
        //Assertion
        String cartPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(cartPageAssert, "Your Cart");
    }

    @And("The product will be displayed on cart")
    public void theProductWillBeDisplayedOnCart() {
        //Assertion
        String productItemAssert = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(productItemAssert, "Sauce Labs Backpack");

        driver.close();
    }
}
