package saucedemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/features/AddProductToCart.feature",
        glue = "saucedemo.cucumber.stepDefs",
        plugin = {"pretty",
                "html:target/HTML-Reports/AddProductToCartReport.html",
                "json:target/JSONReports/AddProductToCartReport.json",
                "junit:target/JUnitReports/AddProductToCartReport.xml"}
)

public class RunAddProductToCart {
}