package saucedemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/features/Checkout.feature",
        glue = "saucedemo.cucumber.stepDefs",
        plugin = {"pretty",
                "html:target/HTML-Reports/CheckoutReport.html",
                "json:target/JSONReports/CheckoutReport.json",
                "junit:target/JUnitReports/CheckoutReport.xml"}
)

public class RunCheckout {
}
