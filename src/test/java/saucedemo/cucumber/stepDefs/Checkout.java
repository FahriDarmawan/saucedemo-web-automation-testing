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

public class Checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User already login and add product to the cart")
    public void userAlreadyLoginAndAddProductToTheCart() {
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

    @And("User access the Cart Page")
    public void userAccessTheCartPage() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        //Assertion
        String cartPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(cartPageAssert, "Your Cart");
    }

    @When("User click Checkout Button")
    public void userClickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("User will be redirected to Your Information Page")
    public void userWillBeRedirectedToYourInformationPage() {
        //Assertion
        String yourInformationPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(yourInformationPageAssert, "Checkout: Your Information");
    }

    @And("User input the First Name")
    public void userInputTheFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Fahri");
    }

    @And("User input the Last Name")
    public void userInputTheLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Darmawan");
    }

    @And("User input the ZipPostal Code")
    public void userInputTheZipPostalCode() {
        driver.findElement(By.id("postal-code")).sendKeys("123456");
    }

    @When("User click the Continue Button")
    public void userClickTheContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("User will be redirected to Overview Page")
    public void userWillBeRedirectedToOverviewPage() {
        //Assertion
        String overviewPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(overviewPageAssert, "Checkout: Overview");
    }

    @When("User click the Finish Button")
    public void userClickTheFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("User will be redirected to Complete Order Page")
    public void userWillBeRedirectedToCompleteOrderPage() {
        //Assertion
        String completeOrderPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(completeOrderPageAssert, "Checkout: Complete!");

        driver.close();
    }
}
