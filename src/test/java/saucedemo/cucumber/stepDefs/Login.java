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

public class Login {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User access the SauceDemo login page")
    public void user_access_the_sauce_demo_login_page() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("User input the registered username")
    public void user_input_the_registered_standard_user_as_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User input the registered password")
    public void user_input_the_registered_secret_sauce_as_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click the Login Button")
    public void user_click_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User will be redirected to Products Page")
    public void user_will_be_redirected_to_products_page() {
        //Assertion
        String productPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(productPageAssert, "Products");

        driver.close();
    }

    @When("User input the unregistered username")
    public void userInputTheUnregisteredUsernameAsUsernameFailed() {
        driver.findElement(By.id("user-name")).sendKeys("fahri");
    }

    @And("User input the unregistered password")
    public void userInputTheUnregisteredPasswordAsPasswordFailed() {
        driver.findElement(By.id("password")).sendKeys("password");
    }

    @Then("Error message will be displayed")
    public void errorMessageWillBeDisplayed() {
        //Assertion
        String errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");

        driver.close();
    }
}
