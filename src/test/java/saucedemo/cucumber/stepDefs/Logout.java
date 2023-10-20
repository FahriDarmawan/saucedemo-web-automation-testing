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

public class Logout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User already login with the registered account")
    public void userAlreadyLoginWithTheRegisteredAccount() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("User click hamburger icon menu")
    public void userClickHamburgerIconMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("Sidebar menu will be displayed")
    public void sidebarMenuWillBeDisplayed() {
        driver.findElement(By.className("bm-menu-wrap")).isDisplayed();
    }

    @And("User click the logout button")
    public void userClickTheLogoutButton() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("User will be redirected to login page")
    public void userWillBeRedirectedToLoginPage() {
        //Assertion
        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
        driver.close();
    }
}
